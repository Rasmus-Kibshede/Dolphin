package system.menus.competitive.commands;

import org.junit.jupiter.api.Test;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.member.competitor.TrainingScore;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTrainingScoreTest {

    @Test
    void execute() {
        String birthDate = "1995-05-04";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);

        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.BREASTSTROKE);

        Competitor member = new Competitor("Hans", dateOfBirth, "hans@gmail.com", "573827282", true, 1, disciplines);

        //Access
        String d = "2021-06-03";
        LocalDate date = LocalDate.parse(d, formatter);
        Duration time = Duration.ofMillis(2030);
        TrainingScore trainingScore = new TrainingScore(date, time, Discipline.BREASTSTROKE);
        boolean expected = member.getTrainingScores().add(new TrainingScore(date, time, Discipline.BREASTSTROKE));

        //Act
        boolean actual = member.getTrainingScores().add(trainingScore);

        //Assert
        assertEquals(expected, actual);
    }
}