package de.telran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MethodModule {

    public static List<String> listOfDatesInAPrederminedFormat(List<String> dates) {
        DateTimeFormatter formatterOfTheExistingDate = DateTimeFormatter.ofPattern("d MMM yyyy");
        DateTimeFormatter formatterOfAFutureDate = DateTimeFormatter.ofPattern("E, d MMMM yyyy", Locale.forLanguageTag("ru"));

        return dates.stream().map(date -> LocalDate.parse(date, formatterOfTheExistingDate))
                    .sorted().map(date -> date.format(formatterOfAFutureDate)).collect(Collectors.toList());
    }
}
