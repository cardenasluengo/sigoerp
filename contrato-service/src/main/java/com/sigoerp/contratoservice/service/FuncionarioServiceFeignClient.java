package com.sigoerp.contratoservice.service;

import com.sigoerp.contratoservice.models.Funcionario;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "empresa-service")
public interface FuncionarioServiceFeignClient {

//    @GetMapping("/funcionario")
//    List<ProductInventoryResponse> getInventoryLevels();

    @GetMapping("/funcionario/{rut}")
    Optional<Funcionario> getFuncionario(String rut);

}
