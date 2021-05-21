package system.member.competitor;

import java.util.ArrayList;

public class Team {
  private String coachName;
  private ArrayList<Competitor> competitors;
  private String teamName;
  private Discipline discipline;

  public Team(String coachName, ArrayList<Competitor> competitors, String teamName, Discipline discipline) {
    setCoachName(coachName);
    setCompetitors(competitors);
    setTeamName(teamName);
    setDiscipline(discipline);
  }

  public Team(String coachName, String teamName, Discipline discipline) {
    setCoachName(coachName);
    setTeamName(teamName);
    setDiscipline(discipline);
  }

  public String getCoachName() {
    return coachName;
  }

  public void setCoachName(String coachName) {
    this.coachName = coachName;
  }

  public ArrayList<Competitor> getCompetitors() {
    return competitors;
  }

  public void setCompetitors(ArrayList<Competitor> competitors) {
    this.competitors = competitors;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public Discipline getDiscipline() {
    return discipline;
  }

  public void setDiscipline(Discipline discipline) {
    this.discipline = discipline;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Competitor competitor : competitors) {
      stringBuilder.append(competitor.getName());
    }

    return "Coach: "
            + coachName
            + "\nCompetitors: "
            + stringBuilder
            ;
  }
}