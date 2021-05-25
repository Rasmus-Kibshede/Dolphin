package system.member.competitor;

import java.time.Duration;

/**
 This class is a Competition consiting of a name for the competition and respectively a competitor placement and
 competitor time
 */
public class Competition {
  private String competitionName;
  private int competitorPlacement;
  private Duration competitorTime;

  public Competition(String competitionName, int competitiorPlacement, Duration time) {
    this.competitionName = competitionName;
    this.competitorPlacement = competitiorPlacement;
    this.competitorTime = time;
  }

  public String getCompetitionName() {
    return competitionName;
  }

  public int getCompetitorPlacement() {
    return competitorPlacement;
  }

  public Duration getCompetitorTime() {
    return competitorTime;
  }

  @Override
  public String toString() {
    return "Competition name: "
            + competitionName
            + "  Placement: "
            + competitorPlacement
            + " Time: "
            + competitorTime.toMillis();
  }
}
