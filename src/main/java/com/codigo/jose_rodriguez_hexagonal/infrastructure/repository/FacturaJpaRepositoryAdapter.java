package com.codigo.jose_rodriguez_hexagonal.infrastructure.repository;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.out.FacturaOut;
import com.codigo.jose_rodriguez_hexagonal.infrastructure.entity.FacturaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FacturaJpaRepositoryAdapter  implements FacturaOut {
    private final  FacturaJpaRepository facturaJpaRepository;

    public FacturaJpaRepositoryAdapter(FacturaJpaRepository facturaJpaRepository) {
        this.facturaJpaRepository = facturaJpaRepository;
    }

    @Override
    public List<Factura> getAll() {
        return facturaJpaRepository.findAll().stream().map(facturaEntity->facturaEntity.toDomain()).collect(Collectors.toList());
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return facturaJpaRepository.findById(id).map(facturaEntity -> facturaEntity.toDomain());
    }

    @Override
    public Factura save(Factura factura){

        return facturaJpaRepository.save(FacturaEntity.fromDomain(factura)).toDomain();
    }

    @Override
    public Factura update(Factura factura, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        facturaJpaRepository.deleteById(id);
    }
}
