package de.telran;

import java.util.ArrayList;
import java.util.List;

public class ExceptNamesWithLengthFour {
    public static List<String> exceptNamesWithLengthFour(List<String> names) {
        List<String> newListOfNames = new ArrayList<>();
        for (String string : names) {
            if(string.length() > 4)
                newListOfNames.add(string);
        }
        return newListOfNames;
    }
}
