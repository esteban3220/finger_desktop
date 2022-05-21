/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author SanthyHA
 */
public class Transacciones {
    private int idTransaccion;//PK
    private int numeroCuenta;//FK
    private int idSucursal;//FK
    private int numeroCuentaDestino;
    private float monto;
    private String tipo;
    private Date fecha;
    private Time hora;

    public Transacciones() {
    }

    public Transacciones(int idTransaccion, int numeroCuenta, int idSucursal,int numeroCuentaDestino, float monto, String tipo, Date fecha, Time hora) {
        this.idTransaccion = idTransaccion;
        this.numeroCuenta = numeroCuenta;
        this.idSucursal = idSucursal;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(int numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
    
}
