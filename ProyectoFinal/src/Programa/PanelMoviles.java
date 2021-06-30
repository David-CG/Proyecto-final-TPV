package Programa;

import Moviles.Movil;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Set;

public class PanelMoviles implements Serializable {
    private PanelCompra panelCompra;
    private final JPanel panelMovil;
    
    public PanelMoviles(PanelCompra panelCompra) {
        this.panelCompra = panelCompra;
        this.panelMovil = new JPanel(new GridLayout(4, 4));
    }
    
    public JPanel getPanelMovil() {
        return panelMovil;
    }
    
    public void anyadeMovil(Movil movil) {
        BotonMovil boton = new BotonMovil(movil);
        boton.getBoton().addActionListener(e -> panelCompra.pulsar(movil));
    }
    
    public JButton devuelveBoton(Movil movil) {
        BotonMovil botonMovil = new BotonMovil(movil);
        botonMovil.getBoton().addActionListener(e -> panelCompra.pulsar(movil));
        return botonMovil.getBoton();
    }
    
    public void actualizaBotones(Set<Movil> listaDeJuegos) {
        panelMovil.removeAll();
        for (Movil movil : listaDeJuegos) {
            anyadeMovil(movil);
        }
        panelMovil.revalidate();
        panelMovil.repaint();
    }
}
