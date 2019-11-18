package de.telran;

import java.util.Arrays;
import java.util.Comparator;

public class MethodModule {

    public static String[] isSortedArray(String[] lines) {
        return Arrays.stream(lines).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
    }
}
