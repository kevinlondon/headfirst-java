import javax.swing.*;
import java.awt.*;

public class Panel2 {

    public static void main(String[] args) {
        Panel2 gui = new Panel2();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        // delegate box layout manager and give each element a new line
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.EAST, panel);

        JButton button = new JButton("Shock me!");
        JButton button2 = new JButton("Bliss...");
        JButton button3 = new JButton("Huh??");
        panel.add(button);
        panel.add(button2);
        panel.add(button3);

        frame.setSize(250, 200);
        frame.setVisible(true);
    }
}
