package de.telran;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    public Game game;
    public Word word;

    @Before
    public void init() {
        game = new Game();
        word = new Word("orange", "fruit of the citrus species");
    }

    @Test
    public void openLetterOneFailedAttempt() {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('y');
        assertEquals(game.getBalance(), -5);
        assertEquals(game.getAttempts(), 1);
    }

    @Test
    public void openLetterOneSuccessfulAttempt() {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('r');
        assertEquals(game.getBalance(), 5);
        assertEquals(game.getAttempts(), 1);
    }

    @Test
    public void openLetterTwoSuccessfulAttempts() {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('r');
        game.openLetter('g');
        assertEquals(game.getBalance(), 10);
        assertEquals(game.getAttempts(), 2);
    }

    @Test
    public void openWordAtOnceSuccesfullAttempt() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openWord("orange");
        assertEquals(game.getBalance(), 50);
        assertEquals(game.getAttempts(), 2);
    }

    @Test
    public void openWordAtOnceFailedlAttempt() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openWord("cherry");
        assertEquals(game.getBalance(), -25);
        assertEquals(game.getAttempts(), 2);
    }

    @Test
    public void openWordAfterOneLetterHasBeenGuessedSuccessfulAttempt() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('r');
        game.openWord("orange");
        assertEquals(game.getBalance(), 55);
        assertEquals(game.getAttempts(), 3);
    }

    @Test
    public void openWordAfterOneLetterHasBeenGuessedFailedAttempt() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('o');
        game.openWord("cherry");
        assertEquals(game.getBalance(), -20);
        assertEquals(game.getAttempts(), 3);
    }

    @Test
    public void GameIsWon() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openWord("orange");
        assertTrue(game.isWin());
    }

    @Test
    public void GameIsLost() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openWord("cherry");
        assertFalse(game.isWin());
    }

    @Test
    public void GameIsWonAfterOpeningOneLetterAndTheWholeWord() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('r');
        game.openWord("orange");
        assertTrue(game.isWin());
    }

    @Test
    public void GameIsLostAfterOpeningOneLetterAndTheWrongWord() throws WrongWordLengthException {
        game.startGame(word.getWord(), word.getDescription());
        game.openLetter('r');
        game.openWord("cherry");
        assertFalse(game.isWin());
    }
}
