public class DotComTest {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public void testGameSetup() {
        // Instantiate a set of 3 objects
        // For each object, check that they do not overlap
        // For each object, make sure that they do not extend beyond bounds
    }

    public void testGamePlay(DotCom dot) {
        // Using the dot object, try every square as though we were a user
        // Check that the game terminates
    }

    public void testUserGuess() {
        // Build a set of user guesses
        // Check that each one is valid
        // Check that the code properly bounces those that are not valid.
    }

    public void testTermination() {
        // Create a list of guesses
        // Check that the math properly works out so we get the result expected
        // For instance, few guesses should be a win
        // More would give an insulting message.
    }
}
