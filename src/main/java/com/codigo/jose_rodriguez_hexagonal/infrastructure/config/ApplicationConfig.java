package com.codigo.jose_rodriguez_hexagonal.infrastructure.config;

import com.codigo.jose_rodriguez_hexagonal.application.service.FacturaService;
import com.codigo.jose_rodriguez_hexagonal.application.service.ProductoService;
import com.codigo.jose_rodriguez_hexagonal.application.useCase.FacturaServiceImpl;
import com.codigo.jose_rodriguez_hexagonal.application.useCase.ProductoServiceImpl;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.out.FacturaOut;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.out.ProductoOut;
import com.codigo.jose_rodriguez_hexagonal.infrastructure.repository.FacturaJpaRepositoryAdapter;
import com.codigo.jose_rodriguez_hexagonal.infrastructure.repository.ProductoJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductoService productoService(ProductoOut productoOut){
        return  new ProductoService(new ProductoServiceImpl(productoOut));
    }
    @Bean
    public  ProductoOut productoOut(ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter){
        return  productoJpaRepositoryAdapter;
    }

    @Bean
    public FacturaService facturaService(FacturaOut facturaOut){
        return  new FacturaService(new FacturaServiceImpl(facturaOut));
    }
    @Bean
    public  FacturaOut facturaOut(FacturaJpaRepositoryAdapter facturaJpaRepositoryAdapter){
        return  facturaJpaRepositoryAdapter;
    }
}
