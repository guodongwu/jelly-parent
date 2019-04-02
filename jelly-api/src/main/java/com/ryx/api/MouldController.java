package com.ryx.api;

import com.ryx.common.BaseController;
import com.ryx.ryxrzt.entity.RztAgencyMould;
import com.ryx.ryxrzt.entity.RztMould;
import com.ryx.ryxrzt.service.RztMouldService;
import com.ryx.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wu
 * 分润模块管理
 */
@RestController
@RequestMapping("/mould")
@Api(tags = "MouldController|分润规则")
public class MouldController extends BaseController {

    @Autowired
    private RztMouldService rztMouldService;


    /**
     * 获取分润模板列表Agency ----->多个AgencyMould
     * @return
     */
    @ApiOperation(value ="获取分润模板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商ID",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "branchId",value = "品牌Id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "mouldName",value = "模板名称", paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "startDate",value = "生效开始日期", paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "endDate",value = "生效结束日期", paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "page",value = "页码",defaultValue = "1",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "limit",value = "页数",defaultValue = "20",paramType = "query"),
    })

    @RequestMapping(value = "/getAgencyUseableMouldList",method = {RequestMethod.POST,RequestMethod.GET})
    public JsonResult getAgencyUseableMouldList(HttpServletRequest request)  {
        JsonResult jsonResult;
        Map<String, Object> params =getParamsToMap(request);
        logger.info("getAgencyUseableMouldList:"+params);
        List<Map<String,Object>> rztMouldList= rztMouldService.getAgencyUseableMouldList(params);
        if(rztMouldList==null || rztMouldList.size()==0){
            jsonResult=new JsonResult("4001","暂无生效或待生效的模板规则");
        }else  {
            Integer total=rztMouldService.getAgencyUseableMouldCount(params);
            jsonResult=new JsonResult("0000","处理成功");
            Map<String, Object> map=new HashMap<String,Object>();
            map.put("total",total);
            map.put("items",rztMouldList);
            jsonResult.setResult(map);
        }
        logger.info("/getAgencyUseableMouldList:"+jsonResult.toString());
        return  jsonResult;
    }

    /**
     * 获取分润模板列表Agency ----->多个AgencyMould
     * @return
     */
    @ApiOperation(value ="通过代理商获取分润模板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商ID",paramType = "query")
    })
    @RequestMapping(value = "/getAgencyMouldList",method = {RequestMethod.POST,RequestMethod.GET})
    public JsonResult getAgencyMouldList(HttpServletRequest request)  {
        JsonResult jsonResult;
        Map<String, Object> params =getParamsToMap(request);
        logger.info("/getAgencyMouldList:"+params);
        if(null==params){
            jsonResult=new JsonResult("4001","缺少必要的参数");
            return  jsonResult;
        }else{
            String agencyId=MapUtils.getString(params,"agencyId");
            if(StringUtils.isBlank(agencyId)){
                jsonResult=new JsonResult("4001","缺少必要的参数");
                return  jsonResult;
            }
        }
        List<RztAgencyMould> rztMouldList= rztMouldService.getAgencyMouldList(params);
        if(rztMouldList==null || rztMouldList.size()==0){
            jsonResult=new JsonResult("4001","暂无生效或待生效的模板规则");
        }else  {
            jsonResult=new JsonResult("0000","处理成功");
            jsonResult.setResult(rztMouldList);
        }
        logger.info("/getAgencyMouldList:"+jsonResult.toString());
        return  jsonResult;
    }



    /**
     * 添加模板 1自己的顶级模板 2 子模版  添加自己的模板
     * @param request
     * @return
     */
    @ApiOperation(value ="添加分润模板")
    @ApiImplicitParams({
        @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商ID",paramType = "query"),
        @ApiImplicitParam(dataType ="String",name = "jsonStr",value = "实体json字符串",required = true,paramType = "query"),
        @ApiImplicitParam(dataType ="String",name = "validityDate",value = "生效时间",required = true,paramType = "query"),
        @ApiImplicitParam(dataType ="String",name = "ruleId",value = "上级规则Id",paramType = "query"),
        @ApiImplicitParam(dataType ="String",name = "mouldName",value = "分润模板名称",required = true,paramType = "query"),
        @ApiImplicitParam(dataType ="String",name = "branchId",value = "品牌id",paramType = "query"),
    })
    @RequestMapping(value = "/addAgencyMould",method = RequestMethod.POST)
    public  JsonResult addAgencyMould(HttpServletRequest request)  {
        Map<String, Object> params = getParamsToMap(request);
        JsonResult result;
        logger.info("/addAgencyMould:"+params);
        //添加顶级模板
        String agencyId= MapUtils.getString(params,"agencyId");
        String branchId=MapUtils.getString(params,"branchId");
        if(StringUtils.isBlank(agencyId)){
            agencyId=branchId;
        }
        if(StringUtils.isBlank(agencyId)||
                StringUtils.isBlank(MapUtils.getString(params, "jsonStr"))||
                StringUtils.isBlank(MapUtils.getString(params, "validityDate"))||
                StringUtils.isBlank(MapUtils.getString(params, "mouldName"))
        ){
            result = new JsonResult("1000","缺少必须参数");
        }else{

            result=rztMouldService.addAgencyMould(params);
            logger.info("/addAgencyMould:"+result.toString());
        }
        return result;
    }

    /**
     * 更新分润规则
     * @param request
     * @return
     */
    @ApiOperation(value ="更新模板分润规则")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商ID",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "branchId",value = "品牌id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "jsonStr",value = "实体json字符串",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "validityDate",value = "生效时间",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "ruleId",value = "规则id",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "mouldName",value = "分润模板名称",required = true,paramType = "query"),
    })
    @RequestMapping(value = "/upAgencyMould",method = RequestMethod.POST)
    public  JsonResult updateAgencyMould(HttpServletRequest request)  {
        Map<String, Object> params = getParamsToMap(request);
        JsonResult result;
        logger.info("/upAgencyMould:"+params);
        String agencyId= MapUtils.getString(params,"agencyId");
        String branchId=MapUtils.getString(params,"branchId");
        if(StringUtils.isBlank(agencyId)){
            agencyId=branchId;
        }
        if(StringUtils.isBlank(agencyId)||
                StringUtils.isBlank(MapUtils.getString(params, "jsonStr"))
        ){
            result = new JsonResult("1000","缺少必须参数");
        }else{

            result=rztMouldService.updateAgencyMould(params);
            logger.info("/upAgencyMould:"+result.toString());
        }
        return result;
    }




    /**
     * 删除模板
     */
    @ApiOperation(value ="删除分润规则模板")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "branchId",value = "品牌id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "ruleId",value = "规则id",required = true,paramType = "query"),
    })
    @RequestMapping(value = "/delAgencyMould",method =RequestMethod.POST)
    public JsonResult delAgencyMould(HttpServletRequest request)  {
        Map<String, Object> params =  getParamsToMap(request);

        JsonResult result;
        logger.info("/delAgencyMould:"+params);
        String agencyId= MapUtils.getString(params,"agencyId");
        String branchId=MapUtils.getString(params,"branchId");
        if(StringUtils.isBlank(agencyId)){
            agencyId=branchId;
        }
        if(StringUtils.isBlank(agencyId)||
                StringUtils.isBlank(MapUtils.getString(params, "ruleId"))
        ){
            result = new JsonResult("1000","缺少必须参数");
        }else{

            result=rztMouldService.delMould(params);
            logger.info("/delAgencyMould:"+result.toString());
        }
        return  result;

    }

    /**
     * 分配模板
     * @param request
     * @return
     */
    @ApiOperation(value ="分配分润规则模板" )
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "branchId",value = "品牌id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "ruleId",value = "规则id",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "validityDate",value = "生效时间",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "childAgencyId",value = "下级代理商ids",required = true,paramType = "query"),

    })
    @RequestMapping(value = "/assignMould",method = RequestMethod.POST)
    public  JsonResult assignMould(HttpServletRequest request)  {
        Map<String, Object> params =  getParamsToMap(request);

        JsonResult result  = null;
        logger.info("/assignMould:"+ params);

        String agencyId= MapUtils.getString(params,"agencyId");
        String branchId=MapUtils.getString(params,"branchId");
        if(StringUtils.isBlank(agencyId)){
            agencyId=branchId;
        }

        if(StringUtils.isBlank(agencyId)||
                StringUtils.isBlank(MapUtils.getString(params, "childAgencyId"))||
                StringUtils.isBlank(MapUtils.getString(params, "ruleId"))||
                StringUtils.isBlank(MapUtils.getString(params, "validityDate"))
        ){
            result = new JsonResult("1000","缺少必须参数");
        }else{

            result=rztMouldService.assignMould(params);
            logger.info("/assignMould:"+result.toString());
        }
        return result;
    }

    /**
     * 获取模板的规则值
     * @param request
     * @return
     */
    @ApiOperation(value ="获取分润模板值")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "代理商id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "ruleId",value = "规则id",paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "parentRuleId",value = "规则上级id",paramType = "query")
    })
    @RequestMapping(value = "/getMouldRule",method = {RequestMethod.POST,RequestMethod.GET})
    public  JsonResult getMouldRule(HttpServletRequest request)  {
        Map<String, Object> params =  getParamsToMap(request);

        JsonResult result;
        logger.info("/getMouldRule:"+params);
        String agencyId= MapUtils.getString(params,"agencyId");
        if(	StringUtils.isBlank(agencyId)){
            result = new JsonResult("1000","缺少必须参数");
        }else{

            result=rztMouldService.getMouldRule(params);

            logger.info("/getMouldRule:"+result.toString());
        }
        return  result;
    }







/**=============================暂时忽略的接口=========================================**/
    /**
     * 获取分润模板详情  AgencyMould----->多个Mould
     * @param request  暂时不用
     * @return
     */
    @ApiOperation(value ="获取分润模板LIST" )
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "agencyId",value = "机构ID",required = true,paramType = "query"),
            @ApiImplicitParam(dataType ="String",name = "ruleId",value = "规则id",required = true,paramType = "query"),
    })
    @ApiIgnore
    @RequestMapping(value = "/getMouldList",method = RequestMethod.POST)
    public  JsonResult getMouldList(HttpServletRequest request)  {
        Map<String, Object> params = getParamsToMap(request);

        JsonResult result;
        logger.info("getMouldList:"+params);
        if(StringUtils.isBlank(MapUtils.getString(params,"agencyId"))||
                StringUtils.isBlank(MapUtils.getString(params, "ruleId"))
        ){
            result = new JsonResult("1000","缺少必须参数");
        }else{
            List<RztMould> rztMoulds=rztMouldService.getMouldList(params);
            result=new JsonResult("0000","连接成功");
            result.setResult(rztMoulds);
            logger.info("rep:"+result.toString());
        }
        return result;
    }

    /**
     * 获取单个mould 暂时不用
     * @param request
     * @return
     */
    @ApiOperation(value ="获取分润模板详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(dataType ="String",name = "ruleNum",value = "规则编号",required = true,paramType = "query"),
    })
    @ApiIgnore
    @RequestMapping(value = "/getMould",method = RequestMethod.POST)
    public JsonResult getMould(HttpServletRequest request)  {
        Map<String, Object> params = getParamsToMap(request);
        JsonResult result;
        logger.info("getMould:"+params);
        String ruleNum=MapUtils.getString(params,"ruleNum");
        if(StringUtils.isBlank(ruleNum)){
            result = new JsonResult("1000","缺少必须参数");
        }else  {
            RztMould rztMould=rztMouldService.getMould(ruleNum);
            result=new JsonResult("0000","连接成功");
            result.setResult(rztMould);
        }
        logger.info("getMould:"+result.toString());
        return result;
    }


    /**
     * 获取所有下级模板 (可能没啥用)
     * @param request
     * @throws Exception
     */
    @ApiOperation(value ="获取所有下级模板" )
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "agencyId",value = "机构Id",required = true,paramType = "query"),
            @ApiImplicitParam(dataType = "String",name = "pageIndex",value = "页码",required = true,paramType = "query"),
            @ApiImplicitParam(dataType = "String",name = "startDate",value = "开始时间",format ="yyyyMMdd" ,paramType = "query"),
            @ApiImplicitParam(dataType = "String",name = "endDate",value = "结束时间",format ="yyyyMMdd" ,paramType = "query")
    })
    @ApiIgnore
    @RequestMapping(value = "/getChildAgencyMould",method = RequestMethod.POST)
    public JsonResult getChildAgencyMould(HttpServletRequest request)  {
        Map<String, Object> params =getParamsToMap(request);
        JsonResult result;
        logger.info("getChildAgencyMould:"+params);
        String agencyId=params.get("agencyId").toString();
        String pageIndex=params.get("pageIndex").toString();

        if(StringUtils.isNotEmpty(agencyId)&&
                StringUtils.isNotEmpty(pageIndex))
        {
            List<RztAgencyMould> rztAgencyMoulds= rztMouldService.getAgencyMouldList(params);
            result = new JsonResult("0000","连接成功");
            result.setResult(rztAgencyMoulds);
            return result;
        }else
        {
            result = new JsonResult("1000","缺少必须参数");
        }
        logger.info("req:"+result.toString());
        return result;
    }
/**=============================暂时忽略的接口=========================================**/
}
