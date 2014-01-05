// Required imports
import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyDrawPanel panel = new MyDrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // Do not call directly. Handled by Java.
    public void paintComponent(Graphics g) {
        // Tell shape to fill itself with this color and be this size.
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }
}
