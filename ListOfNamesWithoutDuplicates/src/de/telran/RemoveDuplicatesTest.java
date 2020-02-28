package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.RemoveDuplicates.removeDuplicates;

public class RemoveDuplicatesTest {
    List<String> names = new ArrayList<>();

    @Before
    public void init() {

        names.add("Maria");
        names.add("Ivan");
        names.add("Ivan");
        names.add("Anna");
        names.add("Alexander");
    }

    @Test
    public void gettingAListWithoutDuplicates() {
        List<String> expected = Arrays.asList("Maria", "Ivan", "Anna", "Alexander");
        List<String> actual = removeDuplicates(names);

        Assert.assertEquals("List is correct", expected, actual);
    }

    @Test
    public void failToGetAListWithoutDuplicates() {
        List<String> expected = Arrays.asList("Maria", "Ivan", "Ivan", "Anna", "Alexander");
        List<String> actual = removeDuplicates(names);

        Assert.assertNotEquals("List is not correct", expected, actual);
    }
}
