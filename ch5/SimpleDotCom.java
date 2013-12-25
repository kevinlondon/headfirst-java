public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    public static void main (String[] args) {
        // Declare int variable to hold number of user guesses.
        // Instantiate a dotcom object
        // For each dotcom:
            // Build locations on grid

        // Compute a random number between 0 and 4 that will be starting cell position
        // While the dot com is still alive
            // Print "Enter a number"
            // Get user input from the command line
            // Validate guess
            // If invalid, re-prompt for new input
            // Else run checkYourself and see if there's a hit
            // If there's a hit
                // Remove that location
                // If the dot com is dead
                    // Remove it completely

            // Increment number of guesses way

        // When the dot com is dead, print total number of guesses
    }
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            } //end if
        } //end for

        if (numOfHits == locationCells.length) {
            result = "kill";
        } //end if

        System.out.println(result);
        return result;
    } // end method~
}
