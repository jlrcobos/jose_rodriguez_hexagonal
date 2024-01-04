package com.codigo.jose_rodriguez_hexagonal.application.useCase;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.in.FacturaIn;
import com.codigo.jose_rodriguez_hexagonal.dominio.ports.out.FacturaOut;

import java.util.List;
import java.util.Optional;

public class FacturaServiceImpl  implements FacturaIn {
    private final FacturaOut facturaOut;

    public FacturaServiceImpl(FacturaOut facturaOut) {
        this.facturaOut = facturaOut;
    }

    @Override
    public List<Factura> getAll() {
        return facturaOut.getAll();
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return facturaOut.findById(id);
    }

    @Override
    public Factura save(Factura factura) throws Exception{
        return facturaOut.save(factura);
    }

    @Override
    public Factura update(Factura factura, Integer id) {
        return facturaOut.update(factura,id);
    }

    @Override
    public void delete(Integer id) {
        facturaOut.delete(id);
    }
}
