package com.codigo.jose_rodriguez_hexagonal.dominio.ports.in;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoIn {
     List<Producto> getAll();
     Optional<Producto> findById(Integer id);
     Producto save(Producto producto);
     Optional<Producto> update(Producto producto,Integer id);
     void  delete(Integer id);
}
