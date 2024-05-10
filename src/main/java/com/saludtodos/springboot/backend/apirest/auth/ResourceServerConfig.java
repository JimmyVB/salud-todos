package com.saludtodos.springboot.backend.apirest.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.FilterRegistration;
import java.util.Arrays;

@Configuration
@EnableResourceServer //Habilitar el servidor de recurso
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    //Metodo que permite implementar todas las reglas de seguridad de nuestros endpoints
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/productos", "/api/clientes/page/**", "/api/productos/page/**", "/api/uploads/img/**", "/images/**")
               .permitAll()//Todas las rutas publicas
        //        .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
        //        .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
        //        .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
        //        .antMatchers("/api/clientes/**").hasRole("ADMIN")
        //.antMatchers("/api/clientes/{id}").permitAll()
        //.antMatchers("/api/facturas/**").permitAll()
        .anyRequest().authenticated()//Cualquier otro request debe ser autenticado
        .and().cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //Permite el dominio
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        //Registrar la config para todas las rutas del backend
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); //Todas las rutas del backend
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        //Metodo para registrar dentro del stack del conjunto de filtros que maneja Spring Framework, dandole prioridad alta
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
