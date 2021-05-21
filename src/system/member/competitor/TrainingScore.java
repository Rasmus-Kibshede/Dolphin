package system.member.competitor;

import java.time.Duration;
import java.time.LocalDate;

public class TrainingScore {
  private LocalDate date;
  private Duration time;

  public TrainingScore(LocalDate date, Duration time) {
    this.date = date;
    this.time = time;
  }

  public LocalDate getDate() {
    return date;
  }

  public Duration getTime() {
    return time;
  }
}
