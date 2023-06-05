package com.bharath.springcloud.Config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.bharath.springcloud.security.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.formLogin();
        http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/productapi/products/**","/index","/showListNewProduct",
        		"/getProduct","/productDetails")
        .hasAnyRole("USER","ADMIN")
        .mvcMatchers(HttpMethod.GET,"/showGetProduct","/listNewProduct","/createResponse").hasRole("ADMIN")
        .mvcMatchers(HttpMethod.POST,"/grtProduct").hasAnyRole("USER", "ADMIN")
        
        .mvcMatchers(HttpMethod.POST,"/productapi/products","/saveProduct","/getProduct").hasRole("ADMIN")
        .mvcMatchers("/","/login","/logout","/showReg","/registerUser").permitAll()
        .anyRequest().denyAll().and().logout().logoutSuccessUrl("/");
        
        
//        http.csrf(csrfCustomizer ->{
//			csrfCustomizer.ignoringAntMatchers("/productapi/products/**");
//			RequestMatcher requestMatchers = new RegexRequestMatcher("/productapi/products/{id:^[0-9]+$}" , "POST");
//			requestMatchers= new MvcRequestMatcher(new HandlerMappingIntrospector(), "/getProduct");
//			csrfCustomizer.ignoringRequestMatchers(requestMatchers);
//		});
//        
//        http.cors(corsCustomizer ->{
//			org.springframework.web.cors.CorsConfigurationSource configurationSource = request->{
//				CorsConfiguration corsConfiguration = new CorsConfiguration();
//				corsConfiguration.setAllowedOrigins(List.of("localhost:3000"));
//				corsConfiguration.setAllowedMethods(List.of("POST"));
//				return corsConfiguration;
//				};
//				corsCustomizer.configurationSource(configurationSource);
//		});
//        
        
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
    	return super.authenticationManagerBean();
    }
    
}
