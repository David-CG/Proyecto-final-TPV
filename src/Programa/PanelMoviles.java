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
        this.panelMovil = new JPanel(new GridLayout(3, 3));
    }
    
    public JPanel getPanelMovil() {
        return panelMovil;
    }
    
    public void anyadeMovil(Movil movil) {
        BotonMovil boton = new BotonMovil(movil, panelCompra);
        boton.getBoton().setPreferredSize(new Dimension(200, 200));
        boton.getBoton().addActionListener(e -> panelCompra.pulsar(movil));
        panelMovil.add(boton.getBoton());
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
