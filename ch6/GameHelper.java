import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader (new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        // Holds 'f6' type coordinates
        String[] alphacoords = new String[comSize];

        // temporary String for concatenation
        String temp = null;

        // current candidate coordinates
        int [] coords = new int[comSize];

        // current attempts counter
        int attempts = 0;

        // flag = found a good location
        boolean success = false;

        // current starting location
        int location = 0;

        // nth dot com to place.
        comCount++;

        // Set horizontal increment
        int incr = 1;
        if ((comCount % 2) == 1) {
            // if odd dot com, place vertically
            incr = gridLength;
        }

        // main search loop.
        while (!success & attempts++ < 200) {
            // get random starting point
            location = (int) (Math.random() * gridSize);
            //  System.out.print(" try " + location);
            // nth position in dotcom to place
            int x = 0;
            // Assume success
            success = true;
            while (success && x < comSize) {
                // Look for adjacent unused spots
                if (grid[location] == 0) {
                    // Save the location
                    coords[x++] = location;
                    // Try next adjacent
                    location += incr;

                    // out of bounds.
                    if (location >= gridSize) {
                        success = false;
                    } else if (x > 0 && (location % gridLength == 0)) {
                        // out of bounds on right
                        success = false;
                    }
                } else {
                    // System.out.print(" used " + location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
        // System.out.println("\n");
        while (x < comSize) {
            // Mark master grid points as used
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            // Convert to alpha
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            // Reveals location of DotCom
            // System.out.print(" coord " + x + " = " + alphaCells.get(x-1));
        }
        return alphaCells;
    }
}
