package de.telran;

import java.util.ArrayList;
import java.util.List;

public class GetYesNoElements {
    public static List<String> getYesNoElements (List<Integer> list1, List<Integer> list2) {
        List<String> yesNoList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                yesNoList.add("Yes");
            } else {
                yesNoList.add("No");
            }
        }
        return yesNoList;
    }
}
