package com.codigo.jose_rodriguez_hexagonal.application.service;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.in.FacturaIn;

import java.util.List;
import java.util.Optional;

public class FacturaService  implements FacturaIn {
    private final FacturaIn facturaIn;

    public FacturaService(FacturaIn facturaIn) {
        this.facturaIn = facturaIn;
    }

    @Override
    public List<Factura> getAll() {
        return facturaIn.getAll();
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return facturaIn.findById(id);
    }

    @Override
    public Factura save(Factura factura) throws Exception{
        return facturaIn.save(factura);
    }

    @Override
    public Factura update(Factura factura, Integer id) {
        return facturaIn.update(factura,id);
    }

    @Override
    public void delete(Integer id) {
        facturaIn.delete(id);
    }
}
