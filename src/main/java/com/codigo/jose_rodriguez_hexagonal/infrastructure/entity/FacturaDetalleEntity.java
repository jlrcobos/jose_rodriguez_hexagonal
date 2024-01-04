package com.codigo.jose_rodriguez_hexagonal.infrastructure.entity;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;
import com.codigo.jose_rodriguez_hexagonal.dominio.models.FacturaDetalle;
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
@Table(name = "facturadetalle")
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private  Integer id;
    @ManyToOne
    @JoinColumn(name = "factura_id",nullable = false)
    private FacturaEntity factura;
    @ManyToOne
    @JoinColumn(name = "producto_id",nullable = false)
    private ProductoEntity producto;
    @Column(nullable = false)
    private int cantidad;
    @Column(name = "precio_unitario",columnDefinition = "numeric(10,2)",nullable = false)
    private double precioUnitario;
    @Column(name = "subtotal",columnDefinition = "numeric(10,2)",nullable = false)
    private double subTotal;

    public  static  FacturaDetalleEntity fromDomain(FacturaDetalle facturaDetalle,FacturaEntity  facturaEntity){
        FacturaDetalleEntity facturaDetalleEntity=new FacturaDetalleEntity();
        facturaDetalleEntity.setId(facturaDetalle.getId());
        facturaDetalleEntity.setCantidad(facturaDetalle.getCantidad());
        facturaDetalleEntity.setPrecioUnitario(facturaDetalle.getPrecioUnitario());
        facturaDetalleEntity.setSubTotal(facturaDetalle.getSubTotal());

        ProductoEntity productoEntity=new ProductoEntity();
        productoEntity.setId(facturaDetalle.getProducto().getId());
        facturaDetalleEntity.setProducto(productoEntity);

        facturaDetalleEntity.setFactura(facturaEntity);

        return  facturaDetalleEntity;
    }
    public  FacturaDetalle toDomain(){
        FacturaDetalle facturaDetalle=new FacturaDetalle();
        facturaDetalle.setId(this.id);
        facturaDetalle.setCantidad(this.cantidad);
        facturaDetalle.setPrecioUnitario(this.precioUnitario);
        facturaDetalle.setSubTotal(this.subTotal);

        Producto producto=new Producto();
        producto.setId(this.getProducto().getId());
        producto.setNombre(this.getProducto().getNombre());
        producto.setPrecio(this.getProducto().getPrecio());
        producto.setStock(this.getProducto().getStock());

        facturaDetalle.setProducto(producto);

        Factura factura=new Factura();
        factura.setId(this.factura.getId());
        facturaDetalle.setFactura(factura);
        return  facturaDetalle;
    }
}
