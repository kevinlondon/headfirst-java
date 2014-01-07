import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class MiniMusicPlayer3 {

    static JFrame f = new JFrame("My First Music Video");
    static MyDrawPanel myPanel;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        // Create the panel within the frame
        myPanel = new MyDrawPanel();
        f.setContentPane(myPanel);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            // Make and open a sequencer.
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Register for events. 127 is the event.
            sequencer.addControllerEventListener(myPanel, new int[] {127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i +=4) {
                r = (int) ((Math.random() * 50) + 1);
                // Creates a random note on the beat
                // Must add the ControlChange event first or there will be no sound.
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception ex) {ex.printStackTrace();}
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        // First four params are for the Message, last is for when the message should be.
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) { }
        return event;
    }


    class MyDrawPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (!msg) {
                return;
            }

            Graphics2D g2 = (Graphics2D) g;
            int red = (int) (Math.random() * 250);
            int green = (int) (Math.random() * 250);
            int blue = (int) (Math.random() * 250);
            g.setColor(new Color(red, green, blue));

            int height = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            int x = (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);
            g.fillRect(x, y, height, width);
            msg = false;
        }
    }
}
