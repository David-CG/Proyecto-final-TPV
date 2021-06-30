package Programa;

import Moviles.Marcas;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

public class BotonMarca implements Serializable {
    
    private final Marcas marca;
    private final JButton boton;
    
    public BotonMarca(Marcas marca) {
        this.marca = marca;
        this.boton = new JButton(marca.getMarca());
    }
    
    public Marcas getMarca() {
        return marca;
    }
    
    public JButton getBoton() {
        return boton;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotonMarca that = (BotonMarca) o;
        return marca == that.marca;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }
}
