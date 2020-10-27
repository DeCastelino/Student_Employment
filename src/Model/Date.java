package Model;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date implements Serializable {

    LocalDate currentDate;
    LocalDate previousDate;

    Date () {
        currentDate = LocalDate.now();
        previousDate = LocalDate.now();
    }

    //Find difference in dates
    // Accessed by employers
    public int getDuration () {
        LocalDate currentDate = LocalDate.now();
        return (int) Math.abs(ChronoUnit.DAYS.between(previousDate, this.currentDate));
    }


    public LocalDate getLastUpdated () {
        return currentDate;
    }


    public void updateDate () {
        previousDate = currentDate;
        currentDate = LocalDate.now();
    }
}
