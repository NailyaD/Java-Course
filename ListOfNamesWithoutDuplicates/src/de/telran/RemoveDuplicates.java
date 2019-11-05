package de.telran;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static List<String> removeDuplicates (List<String> names) {
        List<String> listWithoutDuplicates = names.stream()
                .distinct()
                .collect(Collectors.toList());
        return listWithoutDuplicates;
    }
}
