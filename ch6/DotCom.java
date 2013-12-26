import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;

    public static void main (String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        DotCom theDotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5);

        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive == true) {
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses.");
            } // close if
        } // close while
    } // close main

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        // Find out if user guess is in the arraylist by asking for its index
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            // If index is greater than or equal to zero, user guess in list.
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                // If this list is empty, that was the killing blow.
                result = "kill";
            } else {
                result = "hit";
            }
        }
        System.out.println(result);
        return result;
    } // end method~
}
