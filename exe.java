
import javax.swing.JFrame;

public class exe {

    public static void main(String[] args) {
        VentanaPrincipal app = new VentanaPrincipal();
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1000, 700);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

}
