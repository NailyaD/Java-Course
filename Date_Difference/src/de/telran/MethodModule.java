package de.telran;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class MethodModule {

    public static long differenceBetweenDates (List<LocalDateTime> dates) {
        List<LocalDateTime> sortedList = dates.stream().sorted().collect(Collectors.toList());
        return ChronoUnit.DAYS.between(sortedList.get(0), sortedList.get(sortedList.size() - 1));
    }
}
