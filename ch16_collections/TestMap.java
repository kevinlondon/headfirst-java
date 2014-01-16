import java.util.*;

public class TestMap {

    public static void main(String[] args) {
        // A HashMap has two key parameters, one for the key and one for value
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Kathy", 42);
        scores.put("Bert", 343);
        scores.put("Skyler", 420);

        System.out.println(scores);
        // get() takes a key and returns value
        System.out.println(scores.get("Bert"));
    }
}
