import javax.swing.*;

public class SimpleGui1 {
    public static void main (String[] args) {
        // make jframe and button
        JFrame frame = new JFrame();
        // pass text we want on the button
        JButton button = new JButton("Click me");

        // quit as soon as you close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add button to the frames content pane
        frame.getContentPane().add(button);

        // give frame a size, in pixels.
        frame.setSize(300, 300);

        // Make it visible.
        frame.setVisible(true);
    }
}
