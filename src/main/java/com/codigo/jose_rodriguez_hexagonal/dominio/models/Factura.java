package com.codigo.jose_rodriguez_hexagonal.dominio.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Factura {
    private Integer id;
    @NotNull
    @NotEmpty
    private String clienteNombre;
    @NotNull
    @NotEmpty
    private String clienteDocumento;
    @NotNull
    private LocalDate fechaEmision;
    @NotNull
    private double total;

    @NotNull
    @JsonManagedReference
    private List<FacturaDetalle> detalle;
}
