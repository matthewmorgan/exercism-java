import org.joda.time.DateTime;

public class Meetup {

    DateTime yearMonth;

    public Meetup(int month, int year) {
        yearMonth = new DateTime(year, month, 1, 0, 0);
    }

    public DateTime day(int day, MeetupSchedule when) {
        DateTime first = getFirstDay(day);
        switch (when){
            case TEENTH: {
                int firstDay=first.getDayOfMonth();
                Double teenth = 14 + firstDay % 6 - Math.floor(firstDay / 6);
                return yearMonth.withDayOfMonth(teenth.intValue());
            }
            case LAST: {
                if (first.plusDays(28).getMonthOfYear()!=yearMonth.getMonthOfYear()){
                    return first.plusDays(21);
                } else {
                    return first.plusDays(28);
                }
            }
            case SECOND: {
                return first.plusDays(7);
            }
            case THIRD: {
                return first.plusDays(14);
            }
            case FOURTH: {
                return first.plusDays(21);
            }
        }
        return first;
    };

    private DateTime getFirstDay(int day) {
        DateTime first = yearMonth;
        while (first.getDayOfWeek() != day) {
            first = first.plusDays(1);
        }
        return first;
    }
}
