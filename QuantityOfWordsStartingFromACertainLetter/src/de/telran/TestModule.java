package de.telran;

import org.junit.Assert;

import static de.telran.MethodModule.numberOrNot;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import static de.telran.MethodModule.getQuantityOfWordsBeginningFromACertainLetter;


public class TestModule {

    String sentence = "this is a this is, this a this yes this is a this what it may be i do not care about this";
    String number = "157783";

    @Test
    public void gettingAQuantityOfWordsBeginningFromACertainLetter() {
        long expected = 4;
        long actual = getQuantityOfWordsBeginningFromACertainLetter(sentence,"a");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAQuantityOfWordsBeginningFromACertainLetter() {
        long expected = 10;
        long actual = getQuantityOfWordsBeginningFromACertainLetter(sentence,"a");

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void failToGetAQuantityOfWordsBeginningFromALetterWhichIsAbsentInTheGivenSentence() {
        long expected = 10;
        long actual = getQuantityOfWordsBeginningFromACertainLetter(sentence,"y");

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void isNumber() {
        assertTrue(numberOrNot(number));
    }

    @Test
    public void isNotNumber() {
        assertFalse(numberOrNot(sentence));
    }
}
