public class PhraseOMatic {
    public static void main (String[] args) {
        // make three sets of words to choose from.
        String[] wordListOne = {
            "24/7", "high-availability", "30,000 foot", "win-win",
            "B-to-B", "B-to-C", "cloud-based", "pervasive", "on-demand",
            "smart", "dynamic", "self-sustaining", "crowd-sourced"
        };

        String[] wordListTwo = {
            "empowered", "sticky", "value-added", "oriented", "centric",
            "distributed", "decentralized", "non-invasive", "seamless",
            "branded", "clustered", "leveraged", "outside-the-box",
            "aligned", "vertically integrated", "cooperative", "social",
            "targeted", "shared", "accelerated"
        };

        String[] wordListThree = {
            "process", "tipping-point", "solution", "architecture",
            "core competancy", "strategy", "mindshare", "portal",
            "space", "vision", "paradigm", "vision", "thought leadership"
        };

        // Find out how many words are in each list.
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        // Generate three random numbers
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        // Build a phrase
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + ".";

        // print it.
        System.out.println("What we need is a " + phrase);
    }
}
