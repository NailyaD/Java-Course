package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.ExceptNamesWithLengthFour.exceptNamesWithLengthFour;

public class ExceptNamesWithLengthFourTest {
    private List<String> names = new ArrayList<>();

    @Before
    public void init() {
        names.add("Ivan");
        names.add("Maria");
        names.add("Stephan");
        names.add("John");
        names.add("Amalia");
    }

    @Test
    public void gettingAListOfNamesExceptNamesWithLengthFour() {

        List<String> expected = Arrays.asList("Maria", "Stephan", "Amalia");
        List<String> actual = exceptNamesWithLengthFour(names);

        Assert.assertEquals("Lists are identical", expected, actual);
    }

    @Test
    public void failToGetAListOfNamesExceptNamesWithLengthFour() {

        List<String> expected = Arrays.asList("Ivan", "Maria", "Stephan", "Amalia");
        List<String> actual = exceptNamesWithLengthFour(names);

        Assert.assertNotEquals("Lists are identical", expected, actual);
    }
}
