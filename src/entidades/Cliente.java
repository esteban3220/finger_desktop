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
public class Cliente {
    private String rfc; //PK
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String fechaNacimiento;
    private String telefono;
    private Image huella;

    
    
    //Image image1 = new Image("/flower.png", true);
    //Image image2 = new Image("my/res/flower.png", 100, 150, false, false);

    public Cliente() {
    }

    public Cliente(String rfc, String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String telefono, Image huella) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.huella = huella;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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
     
    
    
}
