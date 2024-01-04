package com.codigo.jose_rodriguez_hexagonal.dominio.ports.in;


import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaIn {
    List<Factura> getAll();
    Optional<Factura> findById(Integer id);
    Factura save(Factura factura) throws Exception;
    Factura update(Factura factura,Integer id);
    void  delete(Integer id);
}
