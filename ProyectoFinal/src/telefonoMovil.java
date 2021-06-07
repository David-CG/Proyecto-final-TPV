import javax.swing.*;

public class telefonoMovil {
    private final String marca;
    private final String modelo;
    private int almacenamiento;
    private final int ram;
    private int precioEuros;
    private ImageIcon icono;


    public telefonoMovil(String marca, String modelo, int almacenamiento, int ram, int precioEuros, ImageIcon icono) {
        this.marca = marca;
        this.modelo = modelo;
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.precioEuros = precioEuros;
        this.icono = icono;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public int getRam() {
        return ram;
    }

    public int getPrecioEuros() {
        return precioEuros;
    }

    public void setPrecioEuros(int precioEuros) {
        this.precioEuros = precioEuros;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }

    public String infoMovil(){
        return marca+" "+modelo+" con "+almacenamiento+"GB de almacenamiento y "+ram+"GB de memoria RAM y cuesta "+precioEuros+"€";
    }

    public String nombreMovil(){
        return marca+" "+modelo;
    }
}
