package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.telran.MethodModule.*;

public class TestModule {
    Person anna = new Person("Anna", 15);
    Person maria = new Person("Maria", 18);
    Person olga = new Person("Olga", 25);
    Person mikhail = new Person("Mikhail", 30);
    Person vladimir = new Person("Vladimir", 10);
    Person svetlana = new Person("Svetlana", 15);

    List<Person> persons = Arrays.asList(anna, maria, olga, mikhail, vladimir, svetlana);

    @Test
    public void gettingASumOfAgesGreaterThan17() {
        int expected = 73;
        int actual = sumOfAgesGreaterThan17(persons);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetASumOfAgesGreaterThan17() {
        int expected = 100;
        int actual = sumOfAgesGreaterThan17(persons);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void personsOfLegalAge() {
        String expected = "In Germany Maria and Olga and Mikhail are of legal age.";
        String actual = legalAge(persons);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void personsOfNotLegalAge() {
        String expected = "In Germany Anna and Vladimir are of legal age.";
        String actual = legalAge(persons);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void gettingAMapOfPersonsWithAgeKeys() {
        Map<Integer, List<Person>> expected = new HashMap<>();
        expected.put(15, Arrays.asList(anna, svetlana));
        expected.put(18, Arrays.asList(maria));
        expected.put(25, Arrays.asList(olga));
        expected.put(30, Arrays.asList(mikhail));
        expected.put(10, Arrays.asList(vladimir));

        Map<Integer, List<Person>> actual = getAMapWithAgeKeys(persons);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAMapOfPersonsWithAgeKeys() {
        Map<Integer, List<Person>> expected = new HashMap<>();
        expected.put(15, Arrays.asList(anna));
        expected.put(18, Arrays.asList(maria, svetlana));
        expected.put(25, Arrays.asList(olga));
        expected.put(30, Arrays.asList(mikhail));
        expected.put(10, Arrays.asList(vladimir));

        Map<Integer, List<Person>> actual = getAMapWithAgeKeys(persons);

        Assert.assertNotEquals(expected, actual);
    }
}
