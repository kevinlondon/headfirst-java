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
        // Cast it so we can access G2D methods
        Graphics2D g2d = (Graphics2D) g;
        // Starting point, color, gradient point, color.

        Color startColor = MyDrawPanel.makeRandomColor();
        Color endColor = MyDrawPanel.makeRandomColor();
        GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
        // Set virtual paint brush to a gradient instead of solid color.
        g2d.setPaint(gradient);
        // Fill oval with whatever is loaded on to the paintbrush
        g2d.fillOval(70,70,100,100);
    }

    public static Color makeRandomColor() {
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        return new Color(red, green, blue);
    }
}
