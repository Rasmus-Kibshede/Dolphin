package system;

import system.member.competition.Competition;
import system.member.competition.Discipline;
import system.member.competition.Team;
import java.util.ArrayList;

public class CompetitorManager {
  private Team[] teams;
  private ArrayList<Competition> competitions;

  public CompetitorManager() {
    teams = new Team[8];
    teams[0] = new Team("Stinna", "Junior Crawl", Discipline.Crawl);
    teams[1] = new Team("Benjamin", "Junior Back Crawl", Discipline.Backcrawl);
    teams[2] = new Team("Benjamin", "Junior Butterfly", Discipline.Butterfly);
    teams[3] = new Team("Stinna", "Junior Breaststroke", Discipline.Breaststroke);
    teams[4] = new Team("Babette", "Senior Crawl", Discipline.Crawl);
    teams[5] = new Team("Tim", "Senior Back Crawl", Discipline.Backcrawl);
    teams[6] = new Team("Babette", "Senior Butterfly", Discipline.Butterfly);
    teams[7] = new Team("Jim", "Senior Breaststroke", Discipline.Breaststroke);
  }

  public Team[] getTeams() {
    return teams;
  }

  public ArrayList<Competition> getCompetitions(){
    return competitions;
  }
}
