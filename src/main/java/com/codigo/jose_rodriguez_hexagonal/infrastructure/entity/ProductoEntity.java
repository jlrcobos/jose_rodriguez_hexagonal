package com.codigo.jose_rodriguez_hexagonal.infrastructure.entity;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class ProductoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "producto_id")
  private Integer id;
    @Column(length = 100,nullable = false)
  private String nombre;
  private String descripcion;
  @Column(columnDefinition = "numeric(10,2)",nullable = false)
  private double precio;
  @Column(nullable = false)
   private int stock;

  public  static ProductoEntity fromModel(Producto producto){
    ProductoEntity  productoEntity=new ProductoEntity();
    productoEntity.setId(producto.getId());
    productoEntity.setNombre(producto.getNombre());
    productoEntity.setDescripcion(producto.getDescripcion());
    productoEntity.setStock(producto.getStock());
    productoEntity.setPrecio(producto.getPrecio());
    return  productoEntity;
  }

    public  static ProductoEntity fromModelUpdate(Producto producto, ProductoEntity productoEntity){
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setDescripcion(producto.getDescripcion());
        productoEntity.setStock(producto.getStock());
        productoEntity.setPrecio(producto.getPrecio());
        return  productoEntity;
    }

  public Producto toDomain(){
        Producto producto=new Producto();
        producto.setId(this.id);
        producto.setNombre(this.nombre);
        producto.setDescripcion(this.descripcion);
        producto.setStock(this.stock);
        producto.setPrecio(this.precio);
        return  producto;
  }
}
