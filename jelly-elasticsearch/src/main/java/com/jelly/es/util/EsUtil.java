package com.jelly.es.util;

import com.alibaba.fastjson.JSON;
import com.jelly.es.entity.ElasticEntity;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EsUtil {
    public final String INDEX="t_dws_finc_tran_detal_info_day_t";
    public final String DOC="_doc";
    @Resource(name = "restHighLevelClient2")
    private RestHighLevelClient restHighLevelClient;
    public void createIndex(String idxName,String idxSql) throws IOException {
        boolean r=this.indexExists(idxName);
        if(r){
            return;
        }
        CreateIndexRequest request=new CreateIndexRequest(idxName);
        buildSetting(request);
        request.mapping(idxSql, XContentType.JSON);
        CreateIndexResponse response=restHighLevelClient.indices().create(request,RequestOptions.DEFAULT);
        if(!response.isAcknowledged()){
            throw  new RuntimeException("创建失败");
        }
    }
    public  void buildSetting(CreateIndexRequest request){
        request.settings(Settings.builder().put("index.number_of_shards",3)
                .put("index.number_of_replicas",2));
    }
    public boolean indexExists(String idxName) throws IOException {
        GetIndexRequest request=new GetIndexRequest(idxName);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);
        request.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
        return restHighLevelClient.indices().exists(request,RequestOptions.DEFAULT);
    }
    public void insertOrUpdateOne(String idxName, ElasticEntity entity) throws IOException {
        IndexRequest request=new IndexRequest(idxName);
        request.id(entity.getId());
        request.source(JSON.toJSONString(entity.getData()),XContentType.JSON);
        restHighLevelClient.index(request,RequestOptions.DEFAULT);
    }
    public void insertBatch(String idxName, List<ElasticEntity> list) throws IOException {
        BulkRequest request=new BulkRequest();
        list.forEach(item->request.add(new IndexRequest(idxName).id(item.getId()).source(JSON.toJSONString(item.getData()),XContentType.JSON)));
        restHighLevelClient.bulk(request,RequestOptions.DEFAULT);

    }
    public void deleteIndex(String idxName) throws IOException {
        restHighLevelClient.indices().delete(new DeleteIndexRequest(idxName),RequestOptions.DEFAULT);
    }
    public <T> void  deleteBatch(String idxName, Collection<T> idList) throws IOException {
        BulkRequest request=new BulkRequest();
        idList.forEach(p->request.add(new DeleteRequest(idxName,p.toString())));
        restHighLevelClient.bulk(request,RequestOptions.DEFAULT);
    }
    public  <T> List<T> search(String idxName, SearchSourceBuilder builder,Class<T> clazz) throws IOException {
        SearchRequest request=new SearchRequest(idxName);
        request.source(builder);
        SearchResponse response=restHighLevelClient.search(request,RequestOptions.DEFAULT);
        SearchHit [] hits=response.getHits().getHits();
        List<T> res=new ArrayList<>(hits.length);
        for (SearchHit hit:hits){
            res.add(JSON.parseObject(hit.getSourceAsString(),clazz));
        }
        return res;
    }
    public void deleteByQuery(String idxName, QueryBuilder builder) throws IOException {
        DeleteByQueryRequest request=new DeleteByQueryRequest(idxName);
        request.setQuery(builder);
        request.setBatchSize(10000);
        request.setConflicts("proceed");
        restHighLevelClient.deleteByQuery(request,RequestOptions.DEFAULT);

    }

    public  <T> List<T> searchScroll(String idxName, SearchSourceBuilder builder,Class<T> clazz) throws IOException {
        SearchRequest request=new SearchRequest(idxName);
        request.source(builder);
        List<String> scrollList=new ArrayList<>();
        TimeValue timeValue=new TimeValue(30000);
        request.scroll(timeValue);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        List<T> res = new ArrayList<>(hits.length);
        for (SearchHit hit : hits) {
            res.add(JSON.parseObject(hit.getSourceAsString(), clazz));
        }
        String scrollId=response.getScrollId();
        scrollList.add(scrollId);
        SearchResponse rep;
        SearchScrollRequest scrollRequest;
        while (true){
            scrollRequest=new SearchScrollRequest(scrollId);
            scrollRequest.scroll(timeValue);
            rep= restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
            if(rep.getHits().getHits().length==0){
                break;
            }
            SearchHit[] scrollHits = rep.getHits().getHits();
            for (SearchHit hit : scrollHits) {
                res.add(JSON.parseObject(hit.getSourceAsString(), clazz));
            }
            scrollId=rep.getScrollId();
            scrollList.add(scrollId);
        }
        ClearScrollRequest clearScrollRequest=new ClearScrollRequest();
        clearScrollRequest.setScrollIds(scrollList);
        restHighLevelClient.clearScroll(clearScrollRequest,RequestOptions.DEFAULT);
        return  res;
    }

}
