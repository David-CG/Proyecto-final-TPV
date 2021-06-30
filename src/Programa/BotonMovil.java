package Programa;

import Moviles.Movil;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;

public class BotonMovil implements Serializable {
    private final JButton boton;
    private final Movil movil;
    
    public BotonMovil(Movil movil, PanelCompra panelCompra) {
        this.movil = movil;
        this.boton = new JButton(movil.getIcono());
        this.boton.addActionListener(e -> {
            panelCompra.generadorPanelCompra();
            Log.log(Level.INFO, movil.getMarca() + " " + movil.getModelo() + " añadido al carrito.");
        });
    }
    
    public JButton getBoton() {
        return boton;
    }
    
    public Movil getMovil() {
        return movil;
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
