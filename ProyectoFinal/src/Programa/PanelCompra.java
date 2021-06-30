package Programa;

import Moviles.Movil;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Map;

public class PanelCompra implements Serializable {
    private final JPanel panelCompras;
    private final JPanel panelMoviles;
    private final JPanel panelTiquet;
    private final Tiquet tiquet;
    private JLabel totalCompra;
    
    public PanelCompra(Tiquet tiquet) {
        this.panelCompras = new JPanel(new GridLayout(0, 1));
        this.panelMoviles = new JPanel(new GridLayout(0, 1));
        this.panelTiquet = new JPanel(new GridLayout(0, 1));
        this.tiquet = tiquet;
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
    
    public void generadorPanelTiquet() {
        panelTiquet.removeAll();
        JPanel panel = new JPanel();
        BoxLayout caja = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(caja);
        for (Map.Entry<Movil, Integer> movilIntegerEntry : tiquet.getCarritoMoviles().entrySet()) {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel label =  new JLabel(movilIntegerEntry.getKey().getMarca() + " " + movilIntegerEntry.getKey().getModelo() + " " + movilIntegerEntry.getValue() + " Total: " + movilIntegerEntry.getKey().getPrecioEuros());
            label.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
            tempPanel.add(label);
            JButton boton = new JButton("X");
            boton.addActionListener(e-> {
                tiquet.quitaDelCarrito(movilIntegerEntry.getKey());
                generadorPanelTiquet();
            });
            tempPanel.add(boton);
            panel.add(tempPanel);
        }
        panel.add(new JLabel("Total de la compra:" + tiquet.costeTotalCompra() ));
        panelTiquet.add(panel, BorderLayout.PAGE_START);
        panelTiquet.repaint();
        panelTiquet.revalidate();
        panelTiquet.getParent().repaint();
        panelTiquet.getParent().revalidate();
    }
}
