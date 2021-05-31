package com.christian.springbootecommercedemoapp.config;

import com.christian.springbootecommercedemoapp.entity.Product;
import com.christian.springbootecommercedemoapp.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        HttpMethod[] theUnspportedActions= {HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT};


        //Lock down and make sure its only read only
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnspportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnspportedActions)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnspportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnspportedActions)));
    }
}
