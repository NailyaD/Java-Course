package de.telran;

import java.util.ArrayList;
import java.util.List;

public class ExceptValuesMoreThanGiven {
    public static List<Integer> exceptValuesMoreThanGiven(List<Integer> values, int number) {
        List<Integer> listOfNewValues = new ArrayList<>();
        for (Integer value : values) {
            if(value <= number)
                listOfNewValues.add(value);
        }
        return listOfNewValues;
    }
}
