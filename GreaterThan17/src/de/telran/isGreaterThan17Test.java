package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.isGreaterThan17.getAddresses;

public class isGreaterThan17Test {
    List<Person> persons = new ArrayList<>();

    Address address1 = new Address("Thulestr.", 5);
    Address address2 = new Address("Berlinerstr.", 20);
    Address address3 = new Address("Petersburgerstr.", 15);
    Address address4 = new Address("Kuglerstr.", 10);

    Person person1 = new Person("Ivanov", 25, address1);
    Person person2 = new Person("Petrov", 10,  address2);
    Person person3 = new Person("Sidorov", 20, address3);
    Person person4 = new Person("Mikhailov", 15, address4);

    @Before
    public void init() {
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
    }

    @Test
    public void gettingAListOnlyWithAddressesOfPeopleWhichAgeIsGreaterThan17() {

        List<Address> expected = Arrays.asList(address1, address3);
        List<Address> actual = getAddresses(persons);

        Assert.assertEquals("List contains only addresses", expected, actual);
    }
}
