package de.telran;

import java.util.ArrayList;
import java.util.List;

public class GetAddresses {

    public static List<Address> getAddresses(List<Person> persons) {
        List<Address> addresses = new ArrayList<>();
        for(Person p:persons) {
            addresses.add(p.getAddress());
        }
        return addresses;
    }
}
