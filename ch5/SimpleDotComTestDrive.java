public class SimpleDotComTestDrive {
    public static void main (String[] args) {
        SimpleDotCom dot = new SimpleDotCom();

        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        String userGuess = "2";
        String testResult = check(dot.checkYourself(userGuess), "hit");
        System.out.println("Hit: " + testResult);

        userGuess = "1";
        testResult = check(dot.checkYourself(userGuess), "miss");
        System.out.println("Miss: " + testResult);

        dot.checkYourself("3");
        testResult = check(dot.checkYourself("4"), "kill");
        System.out.println("Kill: " + testResult);

        userGuess = "A";
        testResult = check(dot.checkYourself(userGuess), "invalid input");
        System.out.println("Invalid Input Handling: " + testResult);
    }

    public String check (String intended_result, String actual_result) {
        if (intended_result.equals(actual_result)) {
            return "passed";
        } else {
            return "failed";
        }
    }
}
