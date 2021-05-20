package system.member.competition;

import java.time.LocalTime;
import java.util.ArrayList;

public class Competition {
  private String competitionName;
  private int competitionPlacement;
  private LocalTime time;
  private ArrayList<Competitor> competitors;

  public Competition(String competitionName, int competitionPlacement, LocalTime time, ArrayList<Competitor> competitors) {
    this.competitionName = competitionName;
    this.competitionPlacement = competitionPlacement;
    this.time = time;
    this.competitors = competitors;
  }

  public String getCompetitionName() {
    return competitionName;
  }

  public int getCompetitionPlacement() {
    return competitionPlacement;
  }

  public LocalTime getTime() {
    return time;
  }

  public ArrayList<Competitor> getCompetitors() {
    return competitors;
  }
}