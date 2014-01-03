public class ExTestDrive {

    public static void main(String[] args) {
        String test = args[0];
        System.out.print("t");
        try {
            doRisky(test);
            System.out.print("a");
        } catch (MyEx e) {
            System.out.print("r");
            System.out.print("o");
        } finally {
            System.out.print("w");
            System.out.println("s");
        }
    }

    static void doRisky(String t) throws MyEx {
        System.out.print("h");
        if ("yes".equals(t)) {
            throw new MyEx();
        }
    }

}
