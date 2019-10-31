package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static de.telran.isCyclicVersion.isCyclicVersion;

import java.util.LinkedList;

public class isCyclicVersionTest {
    LinkedList<String> list1 = new LinkedList<>();
    LinkedList<String> list2 = new LinkedList<>();

    @Before
    public void init() {
        list1.add("dd");
        list1.add("ee");
        list1.add("ff");
        list1.add("gg");

    }

    @Test
    public void OneListIsACyclicVersionOfAnotherList() {
        list2.add("dd");
        list2.add("ee");
        list2.add("ff");
        list2.add("gg");

        Assert.assertTrue(isCyclicVersion(list1, list2));
    }

    @Test
    public void OneListIsNotACyclicVersionOfAnotherList() {
        list2.add("dd");
        list2.add("ff");
        list2.add("ee");
        list2.add("gg");

        Assert.assertFalse(isCyclicVersion(list1, list2));
    }
}
