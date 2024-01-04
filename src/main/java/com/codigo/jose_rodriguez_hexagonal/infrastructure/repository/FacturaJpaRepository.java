package com.codigo.jose_rodriguez_hexagonal.infrastructure.repository;

import com.codigo.jose_rodriguez_hexagonal.infrastructure.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaJpaRepository  extends JpaRepository<FacturaEntity,Integer> {
}
