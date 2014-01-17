import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TwoButtons {

    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pass instance of the appropriate listener class instead of "this"
        JButton labelButton = new JButton("Change Label.");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle.");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label.");
        MyDrawPanel drawPanel = new MyDrawPanel();

        // Add two widgets to the regions of the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");
        }
    } // End of inner class.

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // When user clicks, tell the frame to repaint.
            frame.repaint();
        }
    }
}
