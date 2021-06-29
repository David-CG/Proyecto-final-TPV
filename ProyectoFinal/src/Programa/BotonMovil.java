package Programa;

import Moviles.Movil;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

public class BotonMovil implements Serializable {
    private final JButton boton;
    private final Movil movil;
    
    public BotonMovil(JButton boton, Movil movil) {
        this.boton = new JButton(movil.getIcono());
        this.boton.setIcon(movil.getIcono());
        // TODO lo del log
        this.movil = movil;
    }
    
    public JButton getBoton() {
        return boton;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotonMovil that = (BotonMovil) o;
        return movil.equals(that.movil);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(movil);
    }
}
