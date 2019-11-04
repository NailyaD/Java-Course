package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.GetAddresses.getAddresses;

public class GetAddressesTest {
    private List<Person> persons = new ArrayList<>();

    Address address1 = new Address("Thulestr.", 5);
    Address address2 = new Address("Berlinerstr.", 20);
    Address address3 = new Address("Petersburgerstr.", 15);
    Address address4 = new Address("Kuglerstr.", 10);

    Person person1 = new Person("Ivanov", address1);
    Person person2 = new Person("Petrov", address2);
    Person person3 = new Person("Sidorov", address3);
    Person person4 = new Person("Mikhailov", address4);

    @Before
    public void init() {
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
    }

    @Test
    public void gettingAListOnlyWithAddresses() {

        List<Address> expected = Arrays.asList(address1, address2, address3, address4);
        List<Address> actual = getAddresses(persons);

        Assert.assertEquals("List contains only addresses", expected, actual);
    }
}
