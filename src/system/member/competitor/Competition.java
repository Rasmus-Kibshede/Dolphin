package system.member.competitor;

import java.time.Duration;

/**
 This class is a Competition consiting of a name for the competition and respectively a competitor placement and
 competitor time
 */
public class Competition {
  private final String COMPETITION_NAME;
  private final int COMPETITOR_PLACEMENT;
  private final Duration COMPETITOR_TIME;

  public Competition(String competitionName, int competitiorPlacement, Duration time) {
    this.COMPETITION_NAME = competitionName;
    this.COMPETITOR_PLACEMENT = competitiorPlacement;
    this.COMPETITOR_TIME = time;
  }

  public String getCOMPETITION_NAME() {
    return COMPETITION_NAME;
  }

  public int getCOMPETITOR_PLACEMENT() {
    return COMPETITOR_PLACEMENT;
  }

  public Duration getCOMPETITOR_TIME() {
    return COMPETITOR_TIME;
  }

  @Override
  public String toString() {
    return "Competition name: "
            + COMPETITION_NAME
            + "  Placement: "
            + COMPETITOR_PLACEMENT
            + " Time: "
            + COMPETITOR_TIME.toMillis();
  }
}
