package de.telran;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MethodModule {

    public static List<Person> readingACSVFileToAList(File csvFile) {
        List<Person> persons = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] person = line.split(",");
                String name = person[0].substring(1, person[0].length()-1);
                String stringAge = person[1].substring(1, person[1].length()-1);
                int age = Integer.parseInt(stringAge);
                if (age > 17) {
                    persons.add(new Person(name, age));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static List<Person> isSortedList(List<Person> persons) {
        return persons.stream().sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }
}
