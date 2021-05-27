package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Team;
import system.member.competitor.TrainingScore;
import system.menus.competitive.CompareCompetitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowTopFive implements Command {

  //Skal vi ikke bare lave den final??
  private Manager manager;

  public ShowTopFive(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    for (Team team : manager.getTeams()) {
      ui.displayLn("");
      ui.displayLn(team.getTeamName());
      displayTopFive(team, ui);
    }
  }

  private void displayTopFive(Team team, UI ui) {
    if (team.getCompetitors().isEmpty()) {
      ui.displayLn("The team is empty");
      return;
    }

    List<Competitor> competitors = team.getCompetitors();
    competitors.sort(new CompareCompetitor(team.getDiscipline()));

    if (competitors.size() > 5) {
      // Reduces the competitors to top 5
      competitors = competitors.subList(0, 5);
    }

    // Displays top 5
    for (int i = 0; i < competitors.size(); i++) {
      Competitor competitor = competitors.get(i);
      ui.display((i + 1) + ". " + competitor.getName() + " Time: ");

      for (TrainingScore trainingScore : competitor.getTrainingScores()) {
        if (trainingScore.getDISCIPLINE().equals(team.getDiscipline())) {
          ui.display(trainingScore.getTIME().toMillis() + " ms");
        }
      }
      ui.displayLn("");
    }
  }

  @Override
  public String getName() {
    return "Show top 5";
  }
}