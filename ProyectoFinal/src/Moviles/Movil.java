package Moviles;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class Movil {
    private final String marca;
    private final String modelo;
    private int precioEuros;
    
    
    public Movil(String marca, String modelo, int precioEuros) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioEuros = precioEuros;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getPrecioEuros() {
        return precioEuros;
    }
    
    public void setPrecioEuros(int precioEuros) {
        this.precioEuros = precioEuros;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movil movil = (Movil) o;
        return precioEuros == movil.precioEuros &&
                Objects.equals(modelo, movil.modelo) &&
                marca.equals(movil.marca);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, precioEuros);
    }
    
    public ImageIcon getIcono() {
        File pathIcono = new File("Moviles" + File.separator + modelo + ".jpeg");
        ImageIcon icono = new ImageIcon(pathIcono.getPath());
        
        return icono;
    }
    
    
}
