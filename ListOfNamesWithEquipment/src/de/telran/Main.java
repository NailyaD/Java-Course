package de.telran;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        File file = new File("ListOfNamesWithEquipmentAndCost.txt");
        Map<String, Integer> personsAndAmounts = readingAFileToAMap(file);
        Map<String, Integer> isASortedMap = isASortedMap(personsAndAmounts);
        writingAMapToAFile(isASortedMap);
    }

    public static Map<String, Integer> readingAFileToAMap(File file) {
        Map<String, Integer> personsAndAmounts = new HashMap<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] string = line.split(",");
                String firstName = string[0];
                String lastName = string[1];
                String stringCost = string[3];
                int cost = Integer.parseInt(stringCost);

                String key = firstName + " " + lastName;
                if (personsAndAmounts.containsKey(key)) {
                    personsAndAmounts.put(key, personsAndAmounts.get(key) + cost);
                } else {
                    personsAndAmounts.put(key, cost);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personsAndAmounts;
    }

    public static Map<String, Integer> isASortedMap(Map<String, Integer> personsAndAmounts) {
        return personsAndAmounts.entrySet().stream().sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    public static void writingAMapToAFile(Map<String, Integer> personsAndAmounts) {
        try {
            Files.write(Paths.get("ListOfNamesWithAmountsSorted.txt"), () -> personsAndAmounts.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + "," + e.getValue())
                    .iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
