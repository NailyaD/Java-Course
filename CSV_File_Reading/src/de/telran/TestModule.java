package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static de.telran.MethodModule.isSortedList;
import static de.telran.MethodModule.readingACSVFileToAList;

public class TestModule {
    File csvFile = new File ("ListOfPersons.csv");
    List<Person> persons = new ArrayList<>();

    @Before
    public void init() {

        persons.add(new Person ("Ivan", 18));
        persons.add(new Person ("Piotr", 20));
        persons.add(new Person ("Anna", 30));
        persons.add(new Person ("Vladimir", 19));
    }

    @Test
    public void gettingAListWithPersonsWhoseAgeIsGreaterThan17() {
        List<Person> expected = new ArrayList<>(persons);
        List<Person> actual = readingACSVFileToAList(csvFile);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAListWithPersonsWhoseAgeIsGreaterThan17() {
        List<Person> expected = new ArrayList<>(persons);
        expected.remove(2);
        List<Person> actual = readingACSVFileToAList(csvFile);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void gettingASortedListWithPersonsWhoseAgeIsGreaterThan17() {
        List<Person> expected = new ArrayList<>();
        expected.add(new Person ("Ivan", 18));
        expected.add(new Person ("Vladimir", 19));
        expected.add(new Person ("Piotr", 20));
        expected.add(new Person ("Anna", 30));

        List<Person> actual = isSortedList(persons);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetASortedListWithPersonsWhoseAgeIsGreaterThan17() {
        List<Person> expected = new ArrayList<>();
        expected.add(new Person ("Vladimir", 19));
        expected.add(new Person ("Ivan", 18));
        expected.add(new Person ("Piotr", 20));
        expected.add(new Person ("Anna", 30));

        List<Person> actual = isSortedList(persons);

        Assert.assertNotEquals(expected, actual);
    }
}
