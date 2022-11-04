import java.time.LocalDate;

public class Calendar {
    static LocalDate[] GetDates() {

        LocalDate now = GetNow();

        LocalDate monday = now.minusDays(now.getDayOfWeek().getValue() -1);

        LocalDate[] week = new LocalDate[7];

        for (int i = 0; i < 7; i++) {
            week[i] = monday.plusDays(i);
            System.out.println(week[i]);
        }

        return week;
    }
    static boolean CompareDate(LocalDate dates) {
        LocalDate now = GetNow();
        return now.isEqual(dates);
    }
    static LocalDate GetNow() {
        return LocalDate.now();
    }
}
