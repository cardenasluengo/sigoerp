package com.sivalabs.oauth2server.service;

import com.sivalabs.oauth2server.models.Usuario;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "contrato-service")
public interface UsuarioServiceFeignClient {

    @GetMapping("/usuario/byrut/{rut}")
    Optional<Usuario> getUsuarioByRut(String rut);

}
