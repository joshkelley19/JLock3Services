package kelley.josh.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by joshuakelley on 5/12/17.
 */
public class SchemeGenerator {
    private static final char LETTER = 'R';
    private static final char UPPERCASE = 'L';
    private static final char LOWERCASE = 'l';
    private static final char NUMBER = 'N';
    private static final char ANYSYMBOL = '!';
    private static final char SYMBOL = '#';

    public static char[] randomizeAll(int length) {
        ArrayList<Character> charsList = new ArrayList<>();
        charsList.add(LETTER);
        charsList.add(NUMBER);
        charsList.add(ANYSYMBOL);

        char[] scheme = new char[length];
        for (int i = 0; i < length; ) {
            try {
                scheme[i] = charsList.get((int) Math.floor(Math.random() * 3));
                i++;
            } catch (NullPointerException e) {
                System.out.println("Received " + i + " as a selection value");
                e.printStackTrace();
            }
        }
        return scheme;
    }

    static List<Character> randomizeWithSpecs(int letters, int numbers, int symbols) {
        int total = letters + numbers + symbols;
        ArrayList<Character> charsList = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            if (i < letters) {
                charsList.add(LETTER);
            } else if (i >= letters && i < numbers) {
                charsList.add(NUMBER);
            } else {
                charsList.add(SYMBOL);
            }
        }
        Collections.shuffle(charsList);

        return charsList;
    }
}
