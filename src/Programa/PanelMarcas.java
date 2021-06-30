package Programa;

import Moviles.Marcas;
import Moviles.Movil;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class PanelMarcas implements Serializable {
    private final PanelMoviles panelMoviles;
    private final JPanel panelMarcas;
    private final Set<BotonMarca> botonMarca;
    private final Map<Marcas, Set<Movil>> listaMarcas;
    
    public PanelMarcas(PanelMoviles panelMoviles) {
        this.panelMoviles = panelMoviles;
        this.panelMarcas = new JPanel(new GridLayout(0, 1));
        this.botonMarca = new HashSet<>();
        this.listaMarcas = new HashMap<>();
        mapMarcas();
        generadorBotones();
    }
    
    public JPanel getPanelMarcas() {
        return panelMarcas;
    }
    
    private void mapMarcas() {
        for (Marcas marca : Marcas.values()) {
            listaMarcas.put(marca, new HashSet<>());
        }
    }
    
    public void anyadeMovilAMarca(Movil movil) {
        listaMarcas.get(movil.getMarca()).add(movil);
        listaMarcas.get(Marcas.TODOS).add(movil);
    }
    
    private void generadorBotones() {
        for (Map.Entry<Marcas, Set<Movil>> map : listaMarcas.entrySet()){
            botonMarca.add(new BotonMarca(map.getKey()));
        }
        for (BotonMarca boton : botonMarca) {
            panelMarcas.add(boton.getBoton());
            boton.getBoton().addActionListener(e -> panelMoviles.actualizaBotones(listaMarcas.get(boton.getMarca())));
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanelMarcas that = (PanelMarcas) o;
        return Objects.equals(listaMarcas, that.listaMarcas) && Objects.equals(botonMarca, that.botonMarca) && Objects.equals(panelMoviles, that.panelMoviles) && Objects.equals(panelMarcas, that.panelMarcas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(listaMarcas, botonMarca, panelMoviles, panelMarcas);
    }
}
