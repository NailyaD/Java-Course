package de.telran;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodModule {

    public static Map<Person, List<String>> getAMapWithOwnersAndTheirBA(List<BankAccount> listWithBAAndOwners) {
        return listWithBAAndOwners.stream()
                .collect(Collectors.groupingBy(BankAccount::getOwner, Collectors.mapping(BankAccount::getIBAN, Collectors.toList())));
    }

    public static List<String> getAListWithIBANsWithAsterisks(List<BankAccount> listWithBAAndOwners) {
        return listWithBAAndOwners.stream().map(BankAccount::getIBAN)
                .map(s -> s.substring(0, 3) + s.substring(3).replaceAll("\\d", "*"))
                .collect(Collectors.toList());
    }

    public static List<String> getAListWithBA(List<Person> persons) {
        return persons.stream().map(Person::getBankAccounts).flatMap(Collection::stream)
                .map(s -> s.substring(0, 3) + s.substring(3).replaceAll("\\d", "*")).collect(Collectors.toList());
    }
}
