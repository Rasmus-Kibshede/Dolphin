package system.member.competitor;

import java.util.ArrayList;

public class Team {
  private String coachName;
  private ArrayList<Competitor> competitors = new ArrayList<>();
  private String teamName;
  private Discipline discipline;

  public Team(String coachName, String teamName, Discipline discipline) {
    setCoachName(coachName);
    setTeamName(teamName);
    setDiscipline(discipline);
  }

  public void setCoachName(String coachName) {
    this.coachName = coachName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public void setDiscipline(Discipline discipline) {
    this.discipline = discipline;
  }

  public ArrayList<Competitor> getCompetitors() {
    return competitors;
  }

  public String getTeamName() {
    return teamName;
  }

  public Discipline getDiscipline() {
    return discipline;
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
    return "Team: "
            + teamName
            + "\nCoach: "
            + coachName
            + "\nCompetitors: "
            + getStringOfCompetitors()
            ;
  }
}