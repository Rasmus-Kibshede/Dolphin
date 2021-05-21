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

  public String getStringOfCompetitors(){
    StringBuilder stringBuilder = new StringBuilder();
    if (competitors != null){
      for (Competitor competitor : competitors) {
        stringBuilder.append(competitor.getName());
      }
    }else {
      stringBuilder.append("There are no competitors");
    }

    return stringBuilder.toString();
  }

  @Override
  public String toString() {
    return "Coach: "
            + coachName
            + "\nCompetitors: "
            + getStringOfCompetitors()
            ;
  }
}