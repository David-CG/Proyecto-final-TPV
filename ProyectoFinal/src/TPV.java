import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TPV {

    JFrame frame;
    JPanel panelizq;
    JPanel panelder;
    JPanel xiaomi;
    JPanel redmi;
    JPanel poco;
    JButton boton;
    JTextArea texto;
    ImageIcon logo;

    void ventana() {
        frame = new JFrame("Xiaomi Elche");
        frame.setLayout(new GridLayout());
        frame.add(panelizq);
        frame.add(panelder);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setLocation(100,50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logo = new ImageIcon("milogo.png");
        frame.setIconImage(logo.getImage());
    }

    void panelIzq() {
        panelizq = new JPanel();
        xiaomi = new JPanel();
        redmi = new JPanel();
        poco = new JPanel();
        panelizq.setLayout(new GridLayout(0, 1, 5, 5));
        panelizq.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, Color.getHSBColor(0, 100, 256)));
        JTabbedPane tp = new JTabbedPane();
        tp.add("Mi", xiaomi);
        tp.add("RedMi", redmi);
        tp.add("POCO", poco);
        panelizq.add(tp);

    }

    void panelDer() {
        panelder = new JPanel();
        panelder.setLayout(new GridLayout());
        panelder.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.getHSBColor(0, 100, 256)));

    }

    public TPV() {
        panelIzq();
        panelDer();
        ventana();
    }

    public static void main(String[] args) {
        ArrayList<telefonoMovil> listaMoviles = new ArrayList<telefonoMovil>();
        listaMoviles.add(new telefonoMovil("Xiaomi", "Mi 10", 128, 8, 799, new ImageIcon("mi10.jpeg")));
        listaMoviles.add(new telefonoMovil("Xiaomi", "Mi 11", 128, 8, 750, new ImageIcon("mi11.jpeg")));
        listaMoviles.add(new telefonoMovil("Xiaomi", "Mi 11 Ultra", 256, 12, 1200, new ImageIcon("mi11ultra.jpeg")));
        listaMoviles.add(new telefonoMovil("Redmi", "9", 128, 4, 200, new ImageIcon("redmi9.jpeg")));
        listaMoviles.add(new telefonoMovil("Redmi", "Note 9", 128, 4, 149, new ImageIcon("redminote9.jpeg")));
        listaMoviles.add(new telefonoMovil("Redmi", "Note 10", 128, 4, 200, new ImageIcon("redminote10.jpeg")));
        listaMoviles.add(new telefonoMovil("POCOPHONE", "F2 Pro", 256, 8, 530, new ImageIcon("pocof2pro.jpeg")));
        listaMoviles.add(new telefonoMovil("POCOPHONE", "F3", 256, 8, 370, new ImageIcon("pocof3.jpeg")));
        listaMoviles.add(new telefonoMovil("POCOPHONE", "X3 Pro", 256, 8, 300, new ImageIcon("pocox3pro.jpeg")));

        new TPV();
    }
}
