package com.codigo.jose_rodriguez_hexagonal.infrastructure.repository;

import com.codigo.jose_rodriguez_hexagonal.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaRepository  extends JpaRepository<ProductoEntity,Integer> {
}
