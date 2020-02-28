package de.telran;

import java.util.LinkedList;

public class isCyclicVersion {
    public static boolean isCyclicVersion(LinkedList<String> list1, LinkedList<String> list2) {
        if (list1.containsAll(list2) && list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                String s = list1.peekLast();
                list1.addFirst(s);
                list1.removeLast();
                if (list1.equals(list2)) {
                    return true;
                }
            }
        }

        return false;
    }

}
