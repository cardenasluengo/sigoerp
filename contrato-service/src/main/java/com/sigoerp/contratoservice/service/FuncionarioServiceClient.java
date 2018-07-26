package com.sigoerp.contratoservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sigoerp.contratoservice.utils.MyThreadLocalsHolder;
import com.sigoerp.contratoservice.models.Funcionario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FuncionarioServiceClient {
    private final RestTemplate restTemplate;
    //TODO; move this to config file
    //private static final String FUNCIONARIO_API_PATH = "http://funcionario-service/api/";
    private static final String FUNCIONARIO_API_PATH = "http://empresa-service/";


    @Autowired
    public FuncionarioServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    
    @HystrixCommand(fallbackMethod = "getDefaultFuncionarioById")
    public Optional<Funcionario> getFuncionarioById(String rut)
    {
       
        log.info("CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
        log.info("--------------------**********--------------");
        ResponseEntity<Funcionario> funcionarioResponse =
                restTemplate.getForEntity(FUNCIONARIO_API_PATH + "funcionario/{rut}",
                        Funcionario.class,
                        rut);

           /*
            Simulate Delay
            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         */

        if (funcionarioResponse.getStatusCode() == HttpStatus.OK) {
            
            return Optional.of(funcionarioResponse.getBody());
            
        } else {
            log.error("Error al encontrar el funcionario con rut: " + rut + ", StatusCode: " + funcionarioResponse.getStatusCode());
            return Optional.empty();
        }
    }

    @SuppressWarnings("unused")
    Optional<Funcionario> getDefaultFuncionarioById(String rut) {
        
        log.info("DEfault Funcionario rut: "+rut);
        log.info("CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            
        return Optional.empty();
    }


}
