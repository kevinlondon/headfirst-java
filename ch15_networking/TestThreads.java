
public class TestThreads {

    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        Thread one = new Thread(t1);
        Thread two = new Thread(t2);
        one.start();
        two.start();
    }

    class Accum {
        private Accum() {
            private int counter = 0;
        }

        public static Accum getAccum() {

        }

        public int getCount() {

        }

        public void updateCounter(int add) {
            counter += add;
        }
    }

    class ThreadOne implements Runnable {

    }

    class ThreadTwo implements Runnable {
        public void run() {

        }
    }

}
