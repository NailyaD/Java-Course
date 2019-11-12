package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static de.telran.MethodModule.differenceBetweenDates;

public class TestModule {

    LocalDateTime date1 = LocalDateTime.of(2019, 6, 25, 15, 25);
    LocalDateTime date2 = LocalDateTime.of(2019, 6, 25, 15, 28);
    LocalDateTime date3 = LocalDateTime.of(2018, 10, 5, 10, 13);
    LocalDateTime date4 = LocalDateTime.of(2018, 8, 10, 3, 8);
    LocalDateTime date5 = LocalDateTime.of(2019, 5, 25, 18, 0);

    List<LocalDateTime> dates = Arrays.asList(date1, date2, date3, date4, date5);

    @Test
    public void gettingADifferenceBetweenDates() {
        long expected = 319;
        long actual = differenceBetweenDates(dates);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void failToGetADifferenceBetweenDates() {
        long expected = 280;
        long actual = differenceBetweenDates(dates);

        Assert.assertNotEquals(expected, actual);
    }
}
