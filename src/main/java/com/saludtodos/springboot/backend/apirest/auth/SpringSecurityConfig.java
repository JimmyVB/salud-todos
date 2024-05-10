package com.saludtodos.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService usuarioService;

    @Bean //Anotacion para registrar objetos que retornan un metodo, en el contenedor de spring e inyectar
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //Metodo para encriptar password y es un impl de spring security
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean() // Para retornar el metodo existente y @Component que se coloca a una clase creada
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //Cualquier otro request debe ser autenticado
                .and()
                .csrf().disable() // Protejer nuestro formulario a traves de un token, pero angular no necesitamos esta proteccion de formulario
                .sessionManagement().
                    sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Desabilitar estados porque
                                                                            // usaremos tokens para autenticar.
    }
}
