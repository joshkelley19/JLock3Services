package kelley.josh.utilityTests;

import static org.junit.Assert.*;

import kelley.josh.model.CharacterConfig;
import kelley.josh.model.PasswordConfig;
import kelley.josh.utility.SchemeGenerator;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 6/17/17.
 */
@ActiveProfiles("local")
public class SchemeGeneratorTests {
    SchemeGenerator schemeGenerator = new SchemeGenerator(null);


    @Test
    public void createSchemeTest() {
        ArrayList<Character> list = new ArrayList<Character>();
        list.add('R');
        list.add('L');
        list.add('l');
        list.add('N');
        list.add('!');
        list.add('#');
        String expected = "RLlN!#";
        String actual = schemeGenerator.createScheme(list);
        assertEquals("Testing that characters build to string", expected, actual);
    }

    @Test
    public void addLetterTest0() {
        Object[] expected = new Object[]{'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',};
        Object[] actual = schemeGenerator.addLetter(10, 0, 'R', false).toArray();
        assertArrayEquals("Confirms string of consecutive characters is created", expected, actual);
    }

    @Test
    public void addLetterTest1() {
        Object[] actual = schemeGenerator.addLetter(8, 0, 'R', false).toArray();
        assertTrue("Confirms consecutive character list length is correct", actual.length == 8);
    }

    @Test
    public void addLetterTest2() {
        Object[] actual = schemeGenerator.addLetter(50, 0, 'R', false).toArray();
        assertTrue("Confirms consecutive character list length is correct", actual.length == 50);
    }

    @Test
    public void addLetterTest3() {
        Object[] actual = schemeGenerator.addLetter(305, 0, 'R', false).toArray();
        assertTrue("Confirms consecutive character list length is correct", actual.length == 305);
    }

    @Test
    public void setAmountTest() {
        int actual = schemeGenerator.setAmount(22);
        System.out.println("Actual Value: " + actual);
        assertTrue("Confirms randomly generated value is within range", actual >= 1 && actual <= 22);
    }

    @Test
    public void randomPatternTest() {
        SchemeGenerator sg = new SchemeGenerator(new PasswordConfig(false, 20, true, new CharacterConfig(0, "NONE"), null, new CharacterConfig(0, "NONE"), new CharacterConfig(0, "NONE")));
        assertTrue("confirm scheme returned has specific characters within range", testRandomPattern(sg.determineRandomPattern()));
    }

    private static boolean testRandomPattern(List<Character> characters) {
        for (char character : characters) {
            if (character == 'R' || character == '!' || character == 'N') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
