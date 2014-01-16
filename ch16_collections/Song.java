class Song implements Comparable<Song>{
    String title;
    String artist;
    String rating;
    String bpm;


    public boolean equals(Object aSong) {
        Song a = (Song) aSong;
        // Title is a String, so it already has an equals method.
        return getTitle().equals(a.getTitle());
    }

    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    Song(String t, String a, String r, String bpm) {
        title = t;
        artist = a;
        rating = r;
        bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        // Override toString() so we see the title when printing a list.
        return artist + ": " + title;
    }
}
