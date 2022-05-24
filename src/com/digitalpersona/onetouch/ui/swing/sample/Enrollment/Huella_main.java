package com.digitalpersona.onetouch.ui.swing.sample.Enrollment;
import javax.swing.*;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

public class Huella_main extends JFrame {

    public static String TEMPLATE_PROPERTY = "template";

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vista_main main = new Vista_main();
            try {
                UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
            }
            
            main.setVisible(true);
        });
    }

}
