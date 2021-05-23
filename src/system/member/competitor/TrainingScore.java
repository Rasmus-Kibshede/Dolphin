package system.member.competitor;

import java.time.Duration;
import java.time.LocalDate;

public class TrainingScore {
  private LocalDate date;
  private Duration time;
  private Discipline discipline;

  public TrainingScore(LocalDate date, Duration time, Discipline discipline) {
    this.date = date;
    this.time = time;
    this.discipline = discipline;
  }

  public LocalDate getDate() {
    return date;
  }

  public Duration getTime() {
    return time;
  }

  public Discipline getDiscipline() {
    return discipline;
  }

  @Override
  public String toString() {
    return "Date: " + date + ". Time: " + time.toMillis() + "ms" + ". Discipline: " + discipline;
  }
}