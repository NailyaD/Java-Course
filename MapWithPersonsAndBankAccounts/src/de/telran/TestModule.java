package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.telran.MethodModule.*;


public class TestModule {
    Person anna = new Person("Anna");
    Person vladimir = new Person("Vladimir");
    Person marina = new Person("Marina");

    Person anna1 = new Person("Anna", Arrays.asList("123456", "789456", "123987"));
    Person vladimir1 = new Person("Vladimir", Arrays.asList("456123", "789654"));
    Person marina1 = new Person("Marina", Arrays.asList("321456", "654123"));

    BankAccount BA1 = new BankAccount("123456", anna);
    BankAccount BA2 = new BankAccount("789456", anna);
    BankAccount BA3 = new BankAccount("456123", vladimir);
    BankAccount BA4 = new BankAccount("123987", anna);
    BankAccount BA5 = new BankAccount("321456", marina);

    List<BankAccount> listWithBAAndOwners = Arrays.asList(BA1, BA2, BA3, BA4, BA5);
    List<Person> persons = Arrays.asList(anna1, vladimir1, marina1);

    @Test
    public void gettingAMapWithOwnersAndTheirBA() {

        Map<Person, List<String>> expected = new HashMap<>();
        expected.put(anna, Arrays.asList("123456", "789456", "123987"));
        expected.put(vladimir, Arrays.asList("456123"));
        expected.put(marina, Arrays.asList("321456"));
        Map<Person, List<String>> actual = getAMapWithOwnersAndTheirBA(listWithBAAndOwners);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAMapWithOwnersAndTheirBA() {

        Map<Person, List<String>> expected = new HashMap<>();
        expected.put(anna, Arrays.asList("123456", "789456"));
        expected.put(vladimir, Arrays.asList("456123", "123456"));
        expected.put(marina, Arrays.asList("321456"));
        Map<Person, List<String>> actual = getAMapWithOwnersAndTheirBA(listWithBAAndOwners);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void gettingAListWithIBANsWithAsterisks() {
        List<String> expected = Arrays.asList("123***", "789***", "456***", "123***", "321***");
        List<String> actual = getAListWithIBANsWithAsterisks(listWithBAAndOwners);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAListWithIBANsWithAsterisks() {
        List<String> expected = Arrays.asList("12345*", "789***", "4561**", "12398*", "321456");
        List<String> actual = getAListWithIBANsWithAsterisks(listWithBAAndOwners);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void gettingAListWithBA() {
        List<String> expected = Arrays.asList("123***", "789***", "123***", "456***", "789***", "321***", "654***");
        List<String> actual = getAListWithBA(persons);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAListWithBA() {
        List<String> expected = Arrays.asList("123***", "789***", "123***", "456***");
        List<String> actual = getAListWithBA(persons);

        Assert.assertNotEquals(expected, actual);
    }
}
