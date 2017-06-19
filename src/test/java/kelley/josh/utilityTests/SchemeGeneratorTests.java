package kelley.josh.utilityTests;

import static org.junit.Assert.*;

import kelley.josh.model.CharacterConfig;
import kelley.josh.utility.SchemeGenerator;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 6/17/17.
 */
@ActiveProfiles("local")
public class SchemeGeneratorTests {

    @Test
    public void createSchemeTest(){
        ArrayList<Character> list = new ArrayList<Character>();
        SchemeGenerator schemeGenerator = new SchemeGenerator(null);
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
}
