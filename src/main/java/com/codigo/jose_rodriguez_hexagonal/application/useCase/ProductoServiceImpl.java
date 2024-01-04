package com.codigo.jose_rodriguez_hexagonal.application.useCase;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.in.ProductoIn;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.out.ProductoOut;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl  implements ProductoIn {

   private final ProductoOut productoOut;
   public  ProductoServiceImpl(ProductoOut productoOut){
       this.productoOut=productoOut;
   }
    @Override
    public List<Producto> getAll() {
        return productoOut.getAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoOut.findById(id);
    }

    @Override
    public Producto save(Producto producto){
        return productoOut.save(producto);
    }

    @Override
    public Optional<Producto> update(Producto producto, Integer id) {
        return productoOut.update(producto,id);
    }

    @Override
    public void delete(Integer id) {
        productoOut.delete(id);
    }
}
