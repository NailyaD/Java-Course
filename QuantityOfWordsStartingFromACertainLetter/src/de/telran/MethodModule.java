package de.telran;

import java.util.stream.Stream;

public class MethodModule {

    public static long getQuantityOfWordsBeginningFromACertainLetter(String sentence, String letter) {
        return Stream.of(sentence.split(" ")).filter(s -> s.startsWith(letter)).count();
    }

    public static boolean numberOrNot(String number) {
        return number.chars().allMatch(Character::isDigit);
    }
}
