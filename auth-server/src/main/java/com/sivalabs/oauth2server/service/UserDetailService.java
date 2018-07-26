package com.sivalabs.oauth2server.service;

import com.sivalabs.oauth2server.models.Usuario;
import com.sivalabs.oauth2server.utils.MyThreadLocalsHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@Transactional
@Slf4j
public class UserDetailService implements UserDetailsService{
    
    private final UsuarioServiceClient usuarioServiceClient;
    
   

    @Autowired
    public UserDetailService(UsuarioServiceClient usuarioServiceClient) {
        this.usuarioServiceClient = usuarioServiceClient;
    }


    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

            Optional<Usuario> usuarioResponseEntity =
                    this.usuarioServiceClient.findUserByRut(string);
            if (usuarioResponseEntity.isPresent()) {
                
                log.info("UserDetailService After CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
                          
              return  new UserAdapter(usuarioResponseEntity.get());
            }else{
                
                log.info("UserDetailService After CorrelationID: "+ MyThreadLocalsHolder.getCorrelationId());
                throw new UsernameNotFoundException(String.format("User with %s doesn't exist!", string));
            }
            

        
    }
    
    private Set<SimpleGrantedAuthority> getAuthority(Usuario user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getFunciones().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNombre()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
    
    
}
