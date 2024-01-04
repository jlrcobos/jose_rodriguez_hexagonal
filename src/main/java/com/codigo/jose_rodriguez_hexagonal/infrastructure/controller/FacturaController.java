package com.codigo.jose_rodriguez_hexagonal.infrastructure.controller;

import com.codigo.jose_rodriguez_hexagonal.application.service.FacturaService;
import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }
    @GetMapping
    public ResponseEntity<List<Factura>> getAll(){
        List<Factura> facturas= facturaService.getAll();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Factura> getById(@PathVariable Integer id){
        Optional<Factura> factura=facturaService.findById(id);
        if(factura.isPresent()) return new ResponseEntity<>(factura.get(),HttpStatus.OK);
        else return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Factura> save(@Valid @RequestBody Factura request)throws Exception{
        return  new ResponseEntity<>(facturaService.save(request),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Optional<Factura> factura=facturaService.findById(id);
        if(factura.isPresent()) {
            facturaService.delete(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
