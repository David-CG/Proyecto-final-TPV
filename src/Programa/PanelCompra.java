package Programa;

import Moviles.Movil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;

public class PanelCompra implements Serializable {
    private final JPanel panelCompras;
    private final JPanel panelMoviles;
    private final JPanel panelTiquet;
    private final Tiquet tiquet;
    
    public PanelCompra(Tiquet tiquet) {
        this.panelCompras = new JPanel(new GridLayout(0, 1));
        panelCompras.setPreferredSize(new Dimension(400, 720));
        panelCompras.setBorder(BorderFactory.createEmptyBorder(0, 50 ,0 ,0));
        this.panelMoviles = new JPanel(new GridLayout(0, 1));
        this.panelTiquet = new JPanel(new BorderLayout());
        this.tiquet = tiquet;
        this.panelCompras.add(panelTiquet);
        this.panelCompras.add(panelMoviles);
        generadorPanelCompra();
    }
    
    public JPanel getPanelCompras(){
        return panelCompras;
    }
    
    public JPanel getPanelMoviles(){
        return panelMoviles;
    }
    
    public JPanel getPanelTiquet(){
        return panelTiquet;
    }
    
    public void pulsar(Movil movil) {
        tiquet.anyadeATiquet(movil);
        panelMoviles.removeAll();
        panelMoviles.repaint();
        panelMoviles.revalidate();
    }
    
    public void generadorPanelCompra() {
        panelTiquet.removeAll();
        JPanel panel = new JPanel();
        BoxLayout caja = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(caja);
        for (Map.Entry<Movil, Integer> entry : tiquet.getCarritoMoviles().entrySet()) {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel label =  new JLabel(entry.getKey().getMarca() + " " + entry.getKey().getModelo() + " x" + entry.getValue() + " Total: " + entry.getKey().getPrecioEuros() + "€");
            label.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
            tempPanel.add(label);
            JButton boton = new JButton("x");
            boton.addActionListener(e-> {
                tiquet.quitaDelCarrito(entry.getKey());
                generadorPanelCompra();
            });
            tempPanel.add(boton);
            panel.add(tempPanel);
        }
        panel.add(new JLabel("Total de la compra:" + tiquet.costeTotalCompra() ));
        panelTiquet.add(panel, BorderLayout.PAGE_END);
        panelTiquet.repaint();
        panelTiquet.revalidate();
        panelTiquet.getParent().repaint();
        panelTiquet.getParent().revalidate();
    }
}
