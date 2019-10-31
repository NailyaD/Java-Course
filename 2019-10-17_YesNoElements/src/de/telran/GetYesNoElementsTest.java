package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.GetYesNoElements.getYesNoElements;

public class GetYesNoElementsTest {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    @Before
    public void init() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(5);
        list2.add(2);
        list2.add(3);
        list2.add(8);
    }
    @Test
    public void gettingAListWithYesNoElements() {

        List<String> expected = Arrays.asList("No", "Yes", "Yes", "No");
        List<String> actual = getYesNoElements(list1, list2);

        Assert.assertEquals("List is correct", expected, actual);
    }

    @Test
    public void failToGetAListWithYesNoElements() {

        List<String> expected = Arrays.asList("Yes", "Yes", "Yes", "No");
        List<String> actual = getYesNoElements(list1, list2);

        Assert.assertNotEquals("List is not correct", expected, actual);
    }

}
