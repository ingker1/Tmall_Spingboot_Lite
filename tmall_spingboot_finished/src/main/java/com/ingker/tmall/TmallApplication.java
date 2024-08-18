package com.ingker.tmall;

import com.ingker.tmall.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableElasticsearchRepositories(basePackages = "com.ingker.tmall.es")
@EnableJpaRepositories(basePackages = {"com.ingker.tmall.entity.dao", "com.ingker.tmall.entity.pojo"})
public class TmallApplication {
    static {
        PortUtil.checkPort(6379,"Redis 服务端",true);
        PortUtil.checkPort(9300,"ElasticSearch 服务端",true);
    }
    public static void main(String[] args) {
        SpringApplication.run(TmallApplication.class, args);
        try {
            Runtime.getRuntime().exec("cmd /c start http://127.0.0.1:8080/tmall_springboot/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


