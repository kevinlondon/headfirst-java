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
        // fill entire panel with black
        g.fillRect(0,0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        // Make color based on random values rolled above.
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        // Start 70 px from left, 70 px from top, 100 x 100 dimensions
        g.fillOval(70,70,100,100);
    }
}
