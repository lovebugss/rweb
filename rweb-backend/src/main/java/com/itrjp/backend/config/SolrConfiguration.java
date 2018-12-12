package com.itrjp.backend.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * solr配置bean
 */
@Configuration
public class SolrConfiguration {
    @Value("${spring.data.solr.host}")
    private String url;
    @Bean
    public SolrClient solrClient(){
        SolrClient client = new HttpSolrClient.Builder(url)
                //超时时间
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)

                .withResponseParser(new XMLResponseParser())
                .build();
        return client;
    }

}
