package Programa;

import Moviles.Marcas;
import Moviles.Movil;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class TPV {
        public static void main (String[]args){
            File fichero = new File("ListaDeMoviles.csv"); // TODO No encuentra el fichero
            Tiquet tiquet = new Tiquet();
            PanelCompra panelCompra = new PanelCompra(tiquet);
            PanelMoviles panelMoviles = new PanelMoviles(panelCompra);
            PanelMarcas panelMarcas = new PanelMarcas(panelMoviles);
    
            try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    List<String> campos = Arrays.asList(linea.split(","));
                    Marcas marcas = Marcas.valueOf(campos.get(0));
                    Movil movil = new Movil(marcas, campos.get(1), Integer.parseInt(campos.get(2)));
                    panelMoviles.anyadeMovil(movil);
                    panelMarcas.anyadeMovilAMarca(movil);
                }
            } catch (FileNotFoundException notFoundException) {
                Log.log(Level.SEVERE, "Fichero inexistente.");
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                Log.log(Level.WARNING, "Móvil descatalogado.");
            } catch (IllegalArgumentException argumentException) {
                Log.log(Level.WARNING, "Argumento inválido");
            } catch (IOException ioException) {
                Log.log(Level.WARNING, "Algo no ha ido bien.");
            }
    
    
            JFrame frame = new JFrame("Xiaomi Elche");
            frame.setLayout(new BorderLayout());
            frame.add(panelMarcas.getPanelMarcas(), BorderLayout.EAST);
            frame.add(panelMoviles.getPanelMovil(), BorderLayout.CENTER);
            frame.add(panelCompra.getPanelCompras(), BorderLayout.WEST);
            frame.pack();
            frame.setSize(1280, 720);
            frame.setLocation(100, 50);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
            ImageIcon logo = new ImageIcon("milogo.png");
            frame.setIconImage(logo.getImage());
        }
    }