package de.telran;

import java.util.List;
import java.util.stream.Collectors;

public class isGreaterThan17 {
    public static List<Address> getAddresses(List<Person> persons) {
        List<Address> addresses = persons.stream().filter(a -> a.getAge() > 17)
                .map(Person::getAddress)
                .collect(Collectors.toList());
        return addresses;
    }
}
