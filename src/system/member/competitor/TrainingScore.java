package system.member.competitor;

import java.time.Duration;
import java.time.LocalDate;

public class TrainingScore {
  private final LocalDate DATE;
  private final Duration TIME;
  private final Discipline DISCIPLINE;

  public TrainingScore(LocalDate date, Duration time, Discipline discipline) {
    this.DATE = date;
    this.TIME = time;
    this.DISCIPLINE = discipline;
  }

  public LocalDate getDATE() {
    return DATE;
  }

  public Duration getTIME() {
    return TIME;
  }

  public Discipline getDISCIPLINE() {
    return DISCIPLINE;
  }

  @Override
  public String toString() {
    return "Date: " + DATE + ". Time: " + TIME.toMillis() + "ms" + ". Discipline: " + DISCIPLINE;
  }
}