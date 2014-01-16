class ThreadOne implements Runnable {
    Accum a = Accum.getAccum();

    public void run() {

        for (int x = 0; x < 99; x++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {}
            a.updateCounter(1000);
        }
        System.out.println("one " + a.getCount());

    }
}
