import javax.swing.*;
import java.awt.*;

public class TPV {

    JFrame frame;
    JPanel panelizq;
    JPanel panelder;
    JPanel mi;
    JPanel redmi;
    JPanel poco;
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
        mi = new JPanel();
        redmi = new JPanel();
        poco = new JPanel();
        panelizq.setLayout(new GridLayout(0, 1, 5, 5));
        panelizq.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, Color.getHSBColor(0, 100, 256)));
        JTabbedPane tp = new JTabbedPane();
        tp.add("Mi", mi);
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
        new TPV();
    }
}
