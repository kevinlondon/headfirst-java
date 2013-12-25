public class SimpleDotCom() {
    int[] locationCells;
    int numOfHits = 0;

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
