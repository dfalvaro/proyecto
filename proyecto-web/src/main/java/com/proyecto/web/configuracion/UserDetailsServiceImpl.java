/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.web.configuracion;

import com.proyecto.web.model.TabUsuario;
import com.proyecto.web.service.UsuarioService;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author J0RG3
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @EJB
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        List<TabUsuario> listaUsuario = usuarioService.buscar(new TabUsuario(usuario));
        User.UserBuilder  builder = null;

        if (!listaUsuario.isEmpty()) {
            builder = User.withUsername(usuario);
            builder.disabled(Boolean.FALSE);
            builder.password(listaUsuario.get(0).getClave());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();
    }

}
