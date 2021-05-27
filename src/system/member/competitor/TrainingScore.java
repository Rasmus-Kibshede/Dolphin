package system.member.competitor;

import java.time.Duration;
import java.time.LocalDate;

public class TrainingScore implements Comparable<TrainingScore>{
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

  @Override
  public int compareTo(TrainingScore other) {

    // Taking care of trainingScores is 0
    if (this.getTIME().toMillis() == 0 && other.getTIME().toMillis() == 0) {
      return 0;
    } else if (this.getTIME().toMillis() == 0) {
      return 1;
    } else if (other.getTIME().toMillis() == 0) {
      return -1;
    }

    return this.getTIME().compareTo(other.getTIME());
  }
}