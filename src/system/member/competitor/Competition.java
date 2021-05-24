package system.member.competitor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Competition {
  private String competitionName;
  private int competitionPlacement;
  private Duration time;

  public Competition(String competitionName, int competitionPlacement, Duration time) {
    this.competitionName = competitionName;
    this.competitionPlacement = competitionPlacement;
    this.time = time;
  }

  public String getCompetitionName() {
    return competitionName;
  }

  public int getCompetitionPlacement() {
    return competitionPlacement;
  }

  public Duration getTime() {
    return time;
  }

  @Override
  public String toString() {
    return "Competition name: "
            + competitionName
            + "  Placement: "
            + competitionPlacement
            + " Time: "
            + time.toMillis();
  }
}
