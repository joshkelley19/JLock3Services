package kelley.josh.utility;

import kelley.josh.model.CharacterConfig;
import kelley.josh.model.PasswordConfig;

import java.util.*;

/**
 * Created by joshuakelley on 5/12/17.
 */
public class SchemeGenerator {

    private PasswordConfig passwordConfig;
    private static final char LETTER = 'R';
    private static final char UPPERCASE = 'L';
    private static final char LOWERCASE = 'l';
    private static final char NUMBER = 'N';
    private static final char ANYSYMBOL = '!';
    private static final char SYMBOL = '#';

    public SchemeGenerator(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }

    public String randomizeScheme() {
        List list = /*passwordConfig.isCustom() ? determineCustomPattern() :*/ determineRandomPattern();
        return createScheme(list);
    }


    public String createScheme(List list) {
//        convert scheme letter list into string
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    public List<Character> determineRandomPattern() {
//        add all selected scheme letters
        ArrayList<Character> charsList = new ArrayList<>();
        System.out.println(passwordConfig.toString());
        if (passwordConfig.isLetters()) {
            charsList.add(LETTER);
        }
        if (passwordConfig.isNumbers()) {
            charsList.add(NUMBER);
        }
        if (passwordConfig.isSymbols()) {
            charsList.add(ANYSYMBOL);
        }
        char currentChar;

//        todo throw custom exception if charsList.size() < 1

        ArrayList<Character> scheme = new ArrayList<Character>();
        for (int i = 0; i < passwordConfig.getLength(); ) {
            try {
//                add random scheme letter to list
                currentChar = charsList.get((int) Math.floor(Math.random() * charsList.size()));
                scheme.add(currentChar);
                i++;
            } catch (NullPointerException e) {
                System.err.println("Received " + i + " as a selection value");
                e.printStackTrace();
            }
        }
        return scheme;
    }

    private List<Character> determineCustomPattern() {
        List<Character> pattern;
        Map<Integer, Character> map = new HashMap<>();

//        map amount of types to scheme letters
//        map.put(passwordConfig.getNumbers().amount, NUMBER);
//        char symbols = passwordConfig.isCharStandard() ? ANYSYMBOL : SYMBOL;
//        map.put(passwordConfig.getCharacters().amount, symbols);
//        if (passwordConfig.getLowerCase().amount == 0 && passwordConfig.getUpperCase().amount == 0) {
//            map.put(passwordConfig.getLowerCase().amount, LOWERCASE);
//            map.put(passwordConfig.getUpperCase().amount, UPPERCASE);
//        } else {
//            map.put(passwordConfig.getLength() - map.size(), LETTER);
//        }

//        add lists of individual scheme letters to master list
        pattern = new ArrayList<>(concatSchemeLists(map));

//        randomize list
        Collections.shuffle(pattern);

        return pattern;
//        new CharacterConfig(3, "open");//todo figure out error response;
    }

    private List concatSchemeLists(Map<Integer, Character> map) {
        List list = new ArrayList();
        Map<Integer, Character> tempMap = map;
        Set<Map.Entry<Integer, Character>> set = map.entrySet();
        int length = map.size();

        for (Map.Entry e : set) {
            list.addAll(addLetter((int) e.getKey(), passwordConfig.getLength() - list.size(),
                    tempMap.remove((int) e.getKey()), map.size() == 1));
        }
        return list;
    }

    //    creates and returns list filled with consecutive characters
    public List<Character> addLetter(int amount, int listAmount, char character, boolean end) {
        List<Character> list = new ArrayList<Character>();
        if (amount == 0 && end) {
            amount = end ? listAmount : setAmount(listAmount);
        }
        for (int i = 0; i < amount; i++) {
            list.add(character);
        }
        return list;
    }

    public int setAmount(int currentListAmount) {
        return (int) Math.floor(Math.random() * (currentListAmount - 1)) + 1;
    }

//    public List<Character> randomizeWithSpecs(int letters, int numbers, int symbols) {
//        int total = letters + numbers + symbols;
//        ArrayList<Character> charsList = new ArrayList<>();
//        for (int i = 0; i < total; i++) {
//            if (i < letters) {
//                charsList.add(LETTER);
//            } else if (i >= letters && i < numbers) {
//                charsList.add(NUMBER);
//            } else {
//                charsList.add(SYMBOL);
//            }
//        }
//        Collections.shuffle(charsList);
//
//        return charsList;
//    }
}
