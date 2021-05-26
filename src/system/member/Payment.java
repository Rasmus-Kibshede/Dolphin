package system.member;

import java.time.LocalDate;
import java.time.Period;

public class Payment {
    private final int PASSIVE_PRICE = 500;
    private final int JUNIOR_PRICE = 1000;
    private final double SENIOR_PRICE = 1600 * 0.75;
    private final int GROWNUP_PRICE = 1600;

    public double getPrice(LocalDate dateOfBirth, boolean active) {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

        if (!active) {
            return PASSIVE_PRICE;
        }

        if (age < 18) {
            return JUNIOR_PRICE;
        } else if (age >= 60) {
            return SENIOR_PRICE;
        }
        return GROWNUP_PRICE;
    }
}
