
package com.back.market.persistance.entity;


import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Compra{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;
    
    private String idCliente;
    private LocalDateTime fecha;
    private String medioPago;
    private String comentario;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="idCliente", insertable=false, updatable=false)
    private Cliente cliente;
    
    @OneToMany(mappedBy="compra", cascade={CascadeType.ALL})
    private List<ComprasProducto>productos;
    
  //Getter and Setter

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

   
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }
    
    
}
