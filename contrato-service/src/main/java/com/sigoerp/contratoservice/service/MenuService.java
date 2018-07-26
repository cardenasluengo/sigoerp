package com.sigoerp.contratoservice.service;

import com.sigoerp.contratoservice.models.Funcionario;

import com.sigoerp.contratoservice.models.MenuModel;
import com.sigoerp.contratoservice.models.MenuModuloModel;
import com.sigoerp.contratoservice.models.MenuSeccionModel;
import com.sigoerp.contratoservice.models.MenuFuncionModel;

import com.sigoerp.contratoservice.entities.UsuarioEntity;
import com.sigoerp.contratoservice.entities.FuncionEntity;
import com.sigoerp.contratoservice.entities.SeccionEntity;
import com.sigoerp.contratoservice.entities.ModuloEntity;
import com.sigoerp.contratoservice.entities.DetalleFuncionesEntity;

import com.sigoerp.contratoservice.repositories.UsuarioRepository;
import com.sigoerp.contratoservice.repositories.DetalleFuncionRepository;
import com.sigoerp.contratoservice.repositories.FuncionRepository;
import com.sigoerp.contratoservice.repositories.SeccionRepository;
import com.sigoerp.contratoservice.repositories.ModuloRepository;

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
public class MenuService {

    private final UsuarioRepository usuarioRepository;
    private final FuncionarioServiceClient funcionarioServiceClient;
    private final DetalleFuncionRepository detalleFuncionRepository;
    private final FuncionRepository funcionRepository;
    private final SeccionRepository seccionRepository;
    private final ModuloRepository moduloRepository;

    @Autowired
    public MenuService(UsuarioRepository usuarioRepository,
            FuncionarioServiceClient funcionarioServiceClient,
            DetalleFuncionRepository detalleFuncionRepository,
            FuncionRepository funcionRepository,
            SeccionRepository seccionRepository,
            ModuloRepository moduloRepository) {
        this.usuarioRepository = usuarioRepository;
        this.funcionarioServiceClient = funcionarioServiceClient;
        this.detalleFuncionRepository = detalleFuncionRepository;
        this.funcionRepository = funcionRepository;
        this.seccionRepository = seccionRepository;
        this.moduloRepository = moduloRepository;
    }

    public Optional<MenuModel> findByRut(String rut) {

        MenuModel menu = new MenuModel();

        Optional<UsuarioEntity> u = usuarioRepository.findByFuncionario(rut);

        if (u.isPresent()) {

            menu.setId(u.get().getId());
            menu.setEstado(u.get().isEstado());

            String correlationId = UUID.randomUUID().toString();
            MyThreadLocalsHolder.setCorrelationId(correlationId);
            log.info("Before CorrelationID: " + MyThreadLocalsHolder.getCorrelationId());
            log.info("--------------------**********--------------");

            Optional<Funcionario> funcionarioResponseEntity
                    = this.funcionarioServiceClient.getFuncionarioById(u.get().getFuncionario());
            if (funcionarioResponseEntity.isPresent()) {

                menu.setFuncionario(funcionarioResponseEntity.get());

            } else {
                menu.setFuncionario(null);
            }
            log.info("After CorrelationID: " + MyThreadLocalsHolder.getCorrelationId());

            //se arma el menu-------
            Set<FuncionEntity> lFunE = new HashSet();
            Set<SeccionEntity> lSecE = new HashSet();
            Set<ModuloEntity> lModE = new HashSet();

            Set<DetalleFuncionesEntity> setdfe = new HashSet(detalleFuncionRepository.findAllByUsuario(u.get()));

            for (DetalleFuncionesEntity dfe : setdfe) {

                FuncionEntity fEntity = dfe.getFuncion();

                lFunE.add(fEntity); //agrega funciones sin repetir
                lSecE.add(fEntity.getSeccion()); //agrega Secciones sin repetir
                lModE.add(fEntity.getSeccion().getModulo()); //agrega modulos sin repetir

            }

            Set<MenuModuloModel> listaModulos = new HashSet();

            for (ModuloEntity mE : lModE) {
                Set<MenuSeccionModel> listaSecciones = new HashSet();

                for (SeccionEntity sE : lSecE) {
                    Set<MenuFuncionModel> listaFunciones = new HashSet();

                    if (sE.getModulo().getId() == mE.getId()) {

                        for (FuncionEntity fE : lFunE) {
                            if (fE.getSeccion().getId() == sE.getId()) {
                                listaFunciones.add(new MenuFuncionModel(
                                        fE.getId(),
                                        fE.getNombre(),
                                        fE.getAcceso(),
                                        fE.isMantencion()));
                            }
    
                        }
                        
                        listaSecciones.add(new MenuSeccionModel(
                                    sE.getId(),
                                    sE.getNombre(),
                                    listaFunciones));

                    }

                    listaModulos.add(new MenuModuloModel(
                            mE.getId(),
                            mE.getNombre(),
                            listaSecciones));

                }

            }

            menu.setModulos(listaModulos);

        }

        return Optional.of(menu);

    }

}
