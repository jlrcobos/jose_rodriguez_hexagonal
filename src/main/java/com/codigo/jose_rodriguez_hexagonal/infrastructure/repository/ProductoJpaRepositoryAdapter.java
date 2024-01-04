package com.codigo.jose_rodriguez_hexagonal.infrastructure.repository;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.out.ProductoOut;
import com.codigo.jose_rodriguez_hexagonal.infrastructure.entity.ProductoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductoJpaRepositoryAdapter implements ProductoOut {
    private final ProductoJpaRepository productoJpaRepository;


    @Override
    public List<Producto> getAll() {
        return productoJpaRepository.findAll().stream()
                .map(ProductoEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoJpaRepository.findById(id).map(ProductoEntity::toDomain);
    }

    @Override
    public Producto save(Producto producto) {
        return productoJpaRepository.save(ProductoEntity.fromModel(producto)).toDomain();
    }

    @Override
    public Optional<Producto> update(Producto producto, Integer id) {
        return productoJpaRepository.findById(id)
                .map(pde -> {
                    pde = ProductoEntity.fromModelUpdate(producto, pde);
                    return productoJpaRepository.save(pde).toDomain();
                });
    }

    @Override
    public void delete(Integer id) {
        productoJpaRepository.deleteById(id);
    }
}
