class Accum {
    private static Accum a = new Accum();
    private int counter = 0;

    private Accum() {}

    public static Accum getAccum() {
        return a;
    }

    public int getCount() {
        return counter;
    }

    public synchronized void updateCounter(int add) {
        counter += add;
    }
}
