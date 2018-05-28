package Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class SpanishDictionary {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("is", "es");
        dictionary.put("house", "casa");
        dictionary.put("my", "me");
        dictionary.put("your", "su");

        for (String word: "my house is your house".split(" ")){
            System.out.print(dictionary.get(word) + " ");
        }
    }
}