package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.ExceptValuesMoreThanGiven.exceptValuesMoreThanGiven;

public class ExceptValuesMoreThanGivenTest {
    List<Integer> values = new ArrayList<>();
    int number = 5;

    @Before
    public void init() {
        values.add(5);
        values.add(10);
        values.add(2);
        values.add(12);
        values.add(3);
    }

    @Test
    public void gettingAListWithOnlyElementsMoreThanGivenValue() {
        List<Integer> expected = Arrays.asList(5, 2, 3);
        List<Integer> actual = exceptValuesMoreThanGiven(values, number);

        Assert.assertEquals("List is correct", expected, actual);
    }

    @Test
    public void failToGetAListWithOnlyElementsMoreThanGivenValue() {
        List<Integer> expected = Arrays.asList(5, 10, 12);
        List<Integer> actual = exceptValuesMoreThanGiven(values, number);

        Assert.assertNotEquals("List is not correct", expected, actual);
    }
}
