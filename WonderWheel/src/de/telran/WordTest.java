package de.telran;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {
    public Word word;

    @Before
    public void init() {
        word = new Word("orange", "fruit of the citrus species");
    }

    @Test
    public void testGetWordWithSTars() {
        word.getWordWithStars();
        assertEquals(word.getWordWithStars(), "******");
    }

    @Test
    public void testOpenLetterValidUpperCaseChar() {
        word.openLetter('O');
        assertEquals(word.getWordWithStars(), "******");
    }

    @Test
    public void testOpenLetterValidLowerCaseChar() {
        word.openLetter('e');
        assertEquals(word.getWordWithStars(), "*****e");
    }

    @Test
    public void testOpenLetterInvalidSpecialSymbolChar() {
        word.openLetter(')');
        assertEquals(word.getWordWithStars(), "******");
    }

    @Test
    public void testOpenLetterInvalidCyrillicChar() {
        word.openLetter('н');
        assertEquals(word.getWordWithStars(), "******");
    }

    @Test
    public void testOpenCorrectWord() throws WrongWordLengthException {
        assertTrue(word.openWord("orange"));
    }

    @Test
    public void testNotOpenIncorrectWord() throws WrongWordLengthException {
        assertFalse(word.openWord("cherry"));
    }

    @Test(expected = WrongWordLengthException.class)
    public void testNotOpenAWordWithIncorrectLength() throws WrongWordLengthException {
        assertFalse(word.openWord("peach"));
    }
}
