/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.market.persistance.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    
    private Integer cantidad;
    private Double Tolal;
    private Boolean estado;
    
    @ManyToOne
    @JoinColumn(name="idCompra", insertable=false, updatable=false)
    private Compra compra;
    
    @ManyToOne
    @JoinColumn(name="idProducto", insertable=false, updatable=false)
    private Producto producto;
    
    //GyS

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTolal() {
        return Tolal;
    }

    public void setTolal(Double Tolal) {
        this.Tolal = Tolal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
