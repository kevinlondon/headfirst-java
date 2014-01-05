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
        Image image = new ImageIcon("pumpkin.jpg").getImage();
        // Param 1 and 2 are x and y coordinates. 3 from left, 4 from top.
        // Always relative to the widget and not the entire frame.
        g.drawImage(image, 3, 4, this);
    }
}
