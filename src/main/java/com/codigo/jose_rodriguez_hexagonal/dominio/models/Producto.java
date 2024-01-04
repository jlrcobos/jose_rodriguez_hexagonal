package com.codigo.jose_rodriguez_hexagonal.dominio.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Producto {
   private Integer id;
   @NotNull
   @NotEmpty
   private String nombre;
   private String descripcion;
   @NotNull
   @Min(value = 0)
   private double precio;
   @NotNull
   @Min(value = 1)
   @Max(value = 9999)
   private int stock;
}
