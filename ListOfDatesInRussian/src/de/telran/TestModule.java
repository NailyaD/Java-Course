package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static de.telran.MethodModule.listOfDatesInAPrederminedFormat;

public class TestModule {
    List<String> dates = Arrays.asList("25 Jan 1948", "25 May 1982", "10 Mar 1982", "13 Jul 1944", "28 Nov 2016");

    @Test
    public void gettingAListOfSortedDatesOfAPredeterminedFormat() {
        List<String> expected = Arrays.asList("Чт, 13 июля 1944", "Вс, 25 января 1948", "Ср, 10 марта 1982", "Вт, 25 мая 1982", "Пн, 28 ноября 2016");
        List<String> actual = listOfDatesInAPrederminedFormat(dates);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetAListOfSortedDatesOfAPredeterminedFormat() {
        List<String> expected = Arrays.asList("Вс, 25 января 1948", "Ср, 10 марта 1982", "Чт, 13 июля 1944", "Вт, 25 мая 1982", "28 ноября 2016, Пн");
        List<String> actual = listOfDatesInAPrederminedFormat(dates);

        Assert.assertNotEquals(expected, actual);
    }
}
