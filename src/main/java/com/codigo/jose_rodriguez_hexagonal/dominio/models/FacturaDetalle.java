package com.codigo.jose_rodriguez_hexagonal.dominio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacturaDetalle {
    private  Integer id;
    @JsonBackReference
    private Factura factura;
    @NotNull
    private Producto producto;

    @NotNull
    private int cantidad;
    @NotNull
    private double precioUnitario;
    @NotNull
    private double subTotal;
}
