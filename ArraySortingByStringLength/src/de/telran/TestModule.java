package de.telran;

import org.junit.Test;

import java.util.Arrays;

import static de.telran.MethodModule.isSortedArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class TestModule {
    String[] lines = {"January", "March", "August", "September"};

    @Test
    public void gettingAnArrayWithLinesSortedByLengthOfALine() {
        String[] expected = {"March", "August", "January", "September"};
        String[] actual = isSortedArray(lines);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void failToGetAnArrayWithLinesSortedByLengthOfALine() {
        String[] expected = {"August", "January", "March", "September"};
        String[] actual = isSortedArray(lines);

        assertFalse(Arrays.equals(expected, actual));
    }
}
