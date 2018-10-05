package com.joaomanoel.hotel.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

   public WebConfig() {
       
   }
    
   @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(CorsConfiguration.ALL)
                .allowedMethods("HEAD,GET,POST,PUT,DELETE,PATCH,OPTIONS".split(","))
                .allowedHeaders(("Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method," + 
                        "Access-Control-Request-Headers,App-Context,App-Links,Authorization," + 
                        "User-Access,Filter-Encoded").split(","));
    }

    @Bean
public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    MappingJackson2HttpMessageConverter converter = 
        new MappingJackson2HttpMessageConverter(mapper);
    return converter;
}
    
}
