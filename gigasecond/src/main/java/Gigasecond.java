import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    LocalDateTime birthday;
    LocalDateTime anniversary;

    public Gigasecond(LocalDate birthday) {
        this(birthday.atStartOfDay());
    }

    public Gigasecond(LocalDateTime birthday){
        this.birthday=birthday;
        this.anniversary = this.birthday.plusSeconds(1000000000);
    }

    public LocalDateTime getDate() {
        return anniversary;
    }
}
