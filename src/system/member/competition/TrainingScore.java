package system.member.competition;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingScore {
  private LocalDate date;
  private LocalTime time;

  public TrainingScore(LocalDate date, LocalTime time) {
    this.date = date;
    this.time = time;
  }
}
