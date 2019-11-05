package de.telran;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodModule {

    public static int sumOfAgesGreaterThan17(List<Person> persons) {
        return persons.stream().map(Person::getAge).filter(a -> a > 17).reduce(0, Integer::sum);
    }

    public static String legalAge(List<Person> persons) {
        return persons.stream().filter(a -> a.getAge() > 17)
                .map(Person::getName).collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
    }

    public static Map<Integer, List<Person>> getAMapWithAgeKeys (List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }
}
