package com.sivalabs.oauth2server;

import static java.lang.Math.log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan({"com.sivalabs.oauth2server.service"})
@Slf4j
public class Oauth2ServerApplication {
    
    //@Value("${security.jwt.uri:/auth/**}")
    //private String uri = "";

    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
        
        
       // log.info("url: " + Uri);
        
    }

}
