import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertEquals;

public class TransformerTest {
    @Test
    public void testLength3UpperCase() {
        String input = "aaa bb ccde";
        String expected = "AAA bb ccde";

        String actual = Transformer.transform(input);

        assertEquals("Wrong result sentence", expected, actual);
    }

    @Test
    public void testLength3UpperCaseSingleWord() {
        String input = "abc";
        String expected = "ABC";

        String actual = Transformer.transform(input);

        assertEquals("Wrong result sentence", expected, actual);
    }

    @Test
    public void testLength4UpperCaseNew() {
        String input = "aaa bB ccdE";
        String expected = "aaa bB ccde";

        Predicate<String> p = s -> s.length() == 4;
        Function<String, String> f = s -> s.toLowerCase();

        String actual = Transformer.transform(input, p, f);

        assertEquals("Wrong result sentence", expected, actual);

    }

    @Test
    public void testLength3UpperCaseNew() {
        String input = "aaa bB ccde";
        String expected = "AAA bB ccde";

        Predicate<String> p = s -> s.length() == 3;
        Function<String, String> f = s -> s.toUpperCase();

        String actual = Transformer.transform(input, p, f);

        assertEquals("Wrong result sentence", expected, actual);

    }
}
