/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javafx.scene.image.Image;

/**
 *
 * @author SanthyHA
 */
public class Empleado {
    private int idEmpleado; //PK
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String fechaNacimiento;
    private String rfc;
    private String telefono;
    private Image huella;
    private int idSucursal; //FK

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String rfc, String telefono, Image huella, int idSucursal
    ) {
        this.idEmpleado = idEmpleado;//PK
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.telefono = telefono;
        this.huella = huella;
        this.idSucursal = idSucursal;//FK
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Image getHuella() {
        return huella;
    }

    public void setHuella(Image huella) {
        this.huella = huella;
    }
    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
}
