
class ThreadTester {
    public static void main(String[] args) {

        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);

        // Thread not active until you start it.
        myThread.start();

        System.out.println("Back in main");
    }
}
