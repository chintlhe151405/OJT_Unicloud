package com.example.demoexception_2.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;


@KeycloakConfiguration
class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    // Submits the KeycloakAuthenticationProvider to the Authe<nticationManager
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    // Specifies the session authentication strategy
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
      //  http.anonymous().disable();
        http.csrf().disable();
        http.authorizeRequests()
             .antMatchers("/customers*", "/users*").hasRole("user")
               //.antMatchers().hasRole("user")
                .anyRequest().permitAll();
//                .and()
//                .oauth2ResourceServer()
//                .jwt()
//                .jwtAuthenticationConverter(jwtAuthenticationConverter());
    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        web.ignoring().antMatchers("/login", "/register", "/exception");
//    }
//    private JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
//        jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakGrantedAuthoritiesConverter());
//        return jwtConverter;
//    }
}
