package com.codigo.jose_rodriguez_hexagonal.application.service;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.in.ProductoIn;

import java.util.List;
import java.util.Optional;

public class ProductoService  implements ProductoIn {

   private final ProductoIn productoIn;
   public  ProductoService(ProductoIn productoIn)
   {
            this.productoIn=productoIn;
   }
    @Override
    public List<Producto> getAll() {
        return productoIn.getAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoIn.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoIn.save(producto);
    }

    @Override
    public Optional<Producto> update(Producto producto, Integer id) {
        return productoIn.update(producto,id);
    }

    @Override
    public void delete(Integer id) {
        productoIn.delete(id);
    }
}
