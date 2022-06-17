package com.jelly.es.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.jelly.es.*")
@PropertySource(value = {"classpath:application.properties"})
public class EsConfig {
    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.user}")
    private String user;

    @Value("${elasticsearch.password}")
    private String password;

    @Value("${elasticsearch.connTimeout}")
    private int connTimeout;

    @Value("${elasticsearch.socketTimeout}")
    private int socketTimeout;

    @Value("${elasticsearch.connectionRequestTimeout}")
    private int connectionRequestTimeout;

    @Bean(name = "restHighLevelClient",destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient() {
       String[] hosts=host.split(",");
       HttpHost[]httpHosts=new HttpHost[hosts.length];
       for (int i=0;i<hosts.length;i++){
           HttpHost httpHost=new HttpHost(hosts[i].trim(),port);
           httpHosts[i]=httpHost;
       }
       RestClientBuilder builder = RestClient.builder(httpHosts)
                .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(connTimeout)
                        .setSocketTimeout(socketTimeout)
                        .setConnectionRequestTimeout(connectionRequestTimeout));
        return new RestHighLevelClient(builder);
    }

    @Bean(name = "restHighLevelClient2",destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient2() {
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                AuthScope.ANY, new UsernamePasswordCredentials(user,password));//账号密码
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port))
                .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(connTimeout)
                        .setSocketTimeout(socketTimeout)
                        .setConnectionRequestTimeout(connectionRequestTimeout))
                .setHttpClientConfigCallback(httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        return new RestHighLevelClient(builder);
    }
}
