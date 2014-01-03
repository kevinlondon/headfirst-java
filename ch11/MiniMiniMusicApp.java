import javax.sound.midi.*;

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            //Get a Sequencer and open it
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            // "Ready bake arguments"
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // Ask the sequence for a track.
            Track track = seq.createTrack();

            // Put MidiEvents into the track.
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            // Give the Sequence to the Sequencer
            player.setSequence(seq);

            player.start();
        } catch (Exception ex) {
            // Probably too broad an exception to catch...
            ex.printStackTrace();
        }
    }
}
