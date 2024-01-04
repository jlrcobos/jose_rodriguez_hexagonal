package com.codigo.jose_rodriguez_hexagonal.infrastructure.repository;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;
import com.codigo.jose_rodriguez_hexagonal.infrastructure.entity.ProductoEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductoJpaRepositoryAdapterTest2 {

    @Mock
    ProductoJpaRepository productoJpaRepository;

    @InjectMocks
    ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter;

    @Test
    @DisplayName("Crear producto")
    void crearProducto() {
        //preparar
        Producto productoDomain = new Producto(1, "Laptop HTP", "", 2000, 10);

        ProductoEntity productoEntity = new ProductoEntity(1, "Laptop HTP", "", 2000, 10);

        //Simular y ejecutar
        Mockito.when(productoJpaRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);

        Producto productoAdapter = productoJpaRepositoryAdapter.save(productoDomain);

        assertEquals(productoDomain.getId(), productoAdapter.getId());
    }

    @Test
    void findById_IsEmpty() {
        //preparar
        Producto productoDomain = new Producto(4, "Laptop HTP", "", 2000, 10);

        // Optional<ProductoEntity> productoEntity = Optional.of(new ProductoEntity(3, "Laptop HTP", "", 2000, 10));
        //Simular y ejecutar
        Mockito.when(productoJpaRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        Optional<Producto> productoFindAdapter = productoJpaRepositoryAdapter.findById(productoDomain.getId());

        assertTrue(productoFindAdapter.isEmpty());
    }

    @Test
    void findById_ExistingId_Returns() {
  //preparar
        Producto productoDomain = new Producto(4, "Laptop HTP", "", 2000, 10);

        Optional<ProductoEntity> productoEntity = Optional.of(new ProductoEntity(3, "Laptop HTP", "", 2000, 10));
        //Simular y ejecutar
        Mockito.when(productoJpaRepository.findById(Mockito.anyInt()))
                .thenReturn(productoEntity);

        Optional<Producto> productoFindAdapter = productoJpaRepositoryAdapter.findById(productoDomain.getId());

        assertFalse(productoFindAdapter.isEmpty());
    }

    @Test
    void update_ExistingIdAndValid_ReturnsUpdated() {

    }

    @Test
    void deleteById_NonExistingId_ReturnsFalse() {

    }

    @Test
    void deleteById_ExistingId_ReturnsTrue() {

    }

    @Test
    void getAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}