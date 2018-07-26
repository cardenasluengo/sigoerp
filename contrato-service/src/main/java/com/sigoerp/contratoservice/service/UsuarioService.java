package com.sigoerp.contratoservice.service;

import com.sigoerp.contratoservice.models.UsuarioLargo;
import com.sigoerp.contratoservice.models.UsuarioCorto;
import com.sigoerp.contratoservice.models.Funcionario;
import com.sigoerp.contratoservice.entities.UsuarioEntity;
import com.sigoerp.contratoservice.entities.DetalleFuncionesEntity;
import com.sigoerp.contratoservice.repositories.UsuarioRepository;
import com.sigoerp.contratoservice.repositories.DetalleFuncionRepository;
import com.sigoerp.contratoservice.utils.MyThreadLocalsHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UsuarioService {
    private final  UsuarioRepository usuarioRepository;
    private final FuncionarioServiceClient funcionarioServiceClient;
    private final DetalleFuncionRepository detalleFuncionRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
            FuncionarioServiceClient funcionarioServiceClient,
            DetalleFuncionRepository detalleFuncionRepository) 
    {
        this.usuarioRepository = usuarioRepository;
        this.funcionarioServiceClient = funcionarioServiceClient;
        this.detalleFuncionRepository = detalleFuncionRepository;
    }

    public ArrayList<UsuarioCorto> findAll(){
        ArrayList<UsuarioCorto> listaUsuarios = new ArrayList<>();
        
        for (UsuarioEntity u : usuarioRepository.findAll()) {
            UsuarioCorto newUser = new UsuarioCorto();
            newUser.setId(u.getId());
            newUser.setRut(u.getFuncionario());
            newUser.setEstado(u.isEstado());
            
            String correlationId = UUID.randomUUID().toString();
            MyThreadLocalsHolder.setCorrelationId(correlationId);
            log.info("Before CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            log.info("--------------------**********--------------");
            
            Optional<Funcionario> funcionarioResponseEntity =
                    this.funcionarioServiceClient.getFuncionarioById(u.getFuncionario());
            if (funcionarioResponseEntity.isPresent()) {
               
                newUser.setNombre(funcionarioResponseEntity.get().getNombre() + " " + funcionarioResponseEntity.get().getApellidoP());

            }else{
                newUser.setNombre("");
            }
            log.info("After CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            
            
            listaUsuarios.add(newUser);
        }  
        return listaUsuarios;
    }
    
    public Optional<UsuarioLargo> findById(Long id){
        
        UsuarioLargo userL = new UsuarioLargo();
        
        Optional<UsuarioEntity> u = usuarioRepository.findById(id);
        
        if (u.isPresent()) {
        
            userL.setId(u.get().getId());
            userL.setEstado(u.get().isEstado());
            
            String correlationId = UUID.randomUUID().toString();
            MyThreadLocalsHolder.setCorrelationId(correlationId);
            log.info("Before CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            log.info("--------------------**********--------------");
            
            Optional<Funcionario> funcionarioResponseEntity =
                    this.funcionarioServiceClient.getFuncionarioById(u.get().getFuncionario());
            if (funcionarioResponseEntity.isPresent()) {
               
                userL.setFuncionario(funcionarioResponseEntity.get());

            }else{
                userL.setFuncionario(null);
            }
            log.info("After CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            
            
            
            userL.setRoles(new HashSet(detalleFuncionRepository.findAllByUsuario(u.get())));
        
        }
        
        
        return Optional.of(userL);
    }
    
    public Optional<UsuarioLargo> findUserByRut(String rut) {
        
        UsuarioLargo userL = new UsuarioLargo();
        
        Optional<UsuarioEntity> u = usuarioRepository.findByFuncionario(rut);
        
        if (u.isPresent()) {
        
            userL.setId(u.get().getId());
            userL.setEstado(u.get().isEstado());
            userL.setPassword(u.get().getPassword());
            
            String correlationId = UUID.randomUUID().toString();
            MyThreadLocalsHolder.setCorrelationId(correlationId);
            log.info("Before CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            log.info("--------------------**********--------------");
            
            Optional<Funcionario> funcionarioResponseEntity =
                    this.funcionarioServiceClient.getFuncionarioById(u.get().getFuncionario());
            if (funcionarioResponseEntity.isPresent()) {
               
                userL.setFuncionario(funcionarioResponseEntity.get());

            }else{
                userL.setFuncionario(null);
            }
            log.info("After CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
            
            
            
            userL.setRoles(new HashSet(detalleFuncionRepository.findAllByUsuario(u.get())));
        
        }
        
        
        return Optional.of(userL);
    
    }
    
    
    
}
