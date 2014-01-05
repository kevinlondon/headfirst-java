// Required imports
import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel {

    // Do not call directly. Handled by Java.
    public void paintComponent(Graphics g) {
        // Tell shape to fill itself with this color and be this size.
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }
}
