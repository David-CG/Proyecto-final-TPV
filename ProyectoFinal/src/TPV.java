import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TPV {

    JFrame frame;
    JPanel panel;
    JButton boton;

    void ventana() {
        frame = new JFrame("Xiaomi Elche");
        frame.setLayout(new GridLayout());
        frame.add(panel);
        frame.pack();
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
