import javax.sound.midi.*;

public class MiniMusicPlayer1 {

    public static void main(String[] args) {

        try {
            // Make and open a sequencer.
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Make a sequence and a track.
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i +=4) {
                // Make a bunch of events to make the notes keep going up.
                // Create a note on and note off pair.
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            // Set it running.
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
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

        // Return the completed MidiEvent
        return event;
    }
}
