import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private LocalDateTime birthday;
    private static final int MS_PER_GS = 1000000000;

    public Gigasecond(LocalDate birthday) {
        this(birthday.atStartOfDay());
    }

    public Gigasecond(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getDate() {
        return this.birthday.plusSeconds(MS_PER_GS);
    }
}
