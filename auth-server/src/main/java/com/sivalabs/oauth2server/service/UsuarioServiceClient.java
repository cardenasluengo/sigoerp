package com.sivalabs.oauth2server.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sivalabs.oauth2server.utils.MyThreadLocalsHolder;
import com.sivalabs.oauth2server.models.Usuario;
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
public class UsuarioServiceClient {
    private final RestTemplate restTemplate;
    
    private static final String CONTRATO_API_PATH = "http://contrato-service/usuario/";


    @Autowired
    public UsuarioServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    
    @HystrixCommand(fallbackMethod = "findUserByRutDefault")
    public Optional<Usuario> findUserByRut(String rut)
    {
        
        log.info("CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
        log.info("--------------------**********--------------");
        log.info("rut: " + rut);
        log.info("--------------------**********--------------");
        ResponseEntity<Usuario> usuarioResponse =
                restTemplate.getForEntity(CONTRATO_API_PATH + "byrut/{rut}",
                        Usuario.class,
                        rut);

        if (usuarioResponse.getStatusCode() == HttpStatus.OK) {

            return Optional.of(usuarioResponse.getBody());
            
        } else {
            log.error("Error al encontrar el USUARIO con rut: " + rut + ", StatusCode: " + usuarioResponse.getStatusCode());
            return Optional.empty();
        }
    }

    @SuppressWarnings("unused")
    Optional<Usuario> findUserByRutDefault(String rut) {
        
        log.info("DEFAULT Usuario rut: "+rut);
        log.info("CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            
        return Optional.empty();
    }


}
