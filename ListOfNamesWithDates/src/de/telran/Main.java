package de.telran;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        File file = new File("ListOfNamesWithDates.txt");
        Map<String, LocalDate> personsAndDates = readingAFileToAMap(file);
        System.out.println(personsAndDates);
        Map<String, LocalDate> sortedList = isASortedMap(personsAndDates);
        System.out.println(sortedList);
        writingAMapToAFile(sortedList);
    }

    public static Map<String, LocalDate> readingAFileToAMap(File file) {
        Map<String, LocalDate> personsAndDates = new HashMap<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] string = line.split(",");
                String name = string[0];
                String date = string[1];

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate parsedDate = LocalDate.parse(date, dateTimeFormatter);

                personsAndDates.put(name, parsedDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personsAndDates;
    }

    public static Map<String, LocalDate> isASortedMap(Map<String, LocalDate> personsAndDates) {
        return personsAndDates.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    public static void writingAMapToAFile(Map<String, LocalDate> personsAndDates) {
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            Files.write(Paths.get("ListOfNamesWithDatesSorted.txt"), () -> personsAndDates.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + "," + e.getValue().format(newDateTimeFormatter))
                    .iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
