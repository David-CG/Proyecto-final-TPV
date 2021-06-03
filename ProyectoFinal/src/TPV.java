import javax.swing.*;
import java.awt.GridLayout;

public class TPV {

    JFrame frame;
    JPanel panel;
    JButton boton;
    ImageIcon logo;

    void ventana() {
        frame = new JFrame("Xiaomi Elche");
        frame.setLayout(new GridLayout());
        frame.add(panel);
        frame.pack();
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logo = new ImageIcon("milogo.png");
        frame.setIconImage(logo.getImage());
    }

    void panelPrincipal() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 5, 5, 5));
        boton = new JButton("");

    }

    public TPV() {
        panelPrincipal();
        ventana();
    }

    public static void main(String[] args) {
        new TPV();
    }
}
