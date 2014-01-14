public class RyanAndMonicaExample implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main (String[] args) {
        RyanAndMonicaExample example = new RyanAndMonicaExample();
        Thread one = new Thread(example);
        Thread two = new Thread(example);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawl(10);
            if (account.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized void makeWithdrawl(int amount) {
        String name = Thread.currentThread().getName();
        if (account.getBalance() >= amount) {
            System.out.println(name + " will withdraw.");
            try {
                System.out.println(name + " falling asleep.");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(name + " woke up.");
            account.withdraw(amount);
            System.out.println(name + " completes Withdrawl");
        } else {
            System.out.println("Sorry, not enough for " + name);
        }
    }
}
