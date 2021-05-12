package system.member;

import java.time.LocalDate;
import java.time.Period;

public class Payment {
    private final int PASSIVEPRICE = 500;
    private final int JUNIORPRICE = 1000;
    private final double SENIORPRICE = 1600 * 0.75;
    private final int EIGHTTEENPLUSPRICE = 1600;

    public double getPrice(LocalDate dateOfBirth, boolean active) {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

        if (!active) {
            return PASSIVEPRICE;
        }

        if (age < 18) {
            return JUNIORPRICE;
        } else if (age >= 60) {
            return SENIORPRICE;
        }
        return EIGHTTEENPLUSPRICE;
    }
}
