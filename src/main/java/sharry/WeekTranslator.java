package sharry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeekTranslator {

    private static final String FMT_MSG = "Day number=%s, \t Chiese name=%s, \t English name=%s";
    private int day;
    private String enName;
    private String cnName;

    public WeekTranslator(int day) {
        this.day = day;
    }

    public String toString() {
        return String.format(FMT_MSG, this.getDay(), this.getCnName(), this.getEnName());
    }
}
