package system.member.competitor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 This class is a Competition consiting of a name for the competition and respectively a competitor placement and
 competitor time
 */
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
