package com.codigo.jose_rodriguez_hexagonal.infrastructure.entity;

import com.codigo.jose_rodriguez_hexagonal.dominio.models.Factura;
import com.codigo.jose_rodriguez_hexagonal.dominio.models.FacturaDetalle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturacabecera")
public class FacturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Integer id;
    @Column(name = "cliente_nombre",length = 100,nullable = false)
    private String clienteNombre;
    @Column(name = "cliente_num_documento",length = 15,nullable = false)
    private String clienteDocumento;
    @Column(name = "fecha_emision",columnDefinition = "DATE",nullable = false)
    private LocalDate fechaEmision;
    @Column(columnDefinition = "numeric(10,2)",nullable = false)
    private double total;


    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/)
    private List<FacturaDetalleEntity> detalle;
    public  static  FacturaEntity fromDomain(Factura factura){
        FacturaEntity facturaEntity=new FacturaEntity();
        facturaEntity.setId(factura.getId());
        facturaEntity.setClienteNombre(factura.getClienteNombre());
        facturaEntity.setClienteDocumento(factura.getClienteDocumento());
        facturaEntity.setFechaEmision(factura.getFechaEmision());
        facturaEntity.setTotal(factura.getTotal());
        facturaEntity.detalle=new ArrayList<>();
        for(FacturaDetalle det:factura.getDetalle()){
            facturaEntity.detalle.add(FacturaDetalleEntity.fromDomain(det,facturaEntity));
        }
        return  facturaEntity;
    }
     public  Factura toDomain(){
         Factura factura=new Factura();
         factura.setId(this.id);
         factura.setClienteNombre(this.clienteNombre);
         factura.setClienteDocumento(this.clienteDocumento);
         factura.setFechaEmision(this.fechaEmision);
         factura.setTotal(this.getTotal());

         List<FacturaDetalle> detalle=new ArrayList<>();
         for(FacturaDetalleEntity detalleEntity:this.getDetalle()){
             detalle.add(detalleEntity.toDomain());
         }
         factura.setDetalle(detalle);
         return  factura;
     }
}
