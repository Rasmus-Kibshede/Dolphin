package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.competitor.Competitor;
import system.member.competitor.Team;
import system.member.competitor.TrainingScore;

import java.util.ArrayList;
import java.util.Collections;

public class ShowTopFive implements Command {

  //Skal vi ikke bare lave den final??
  private Manager manager;

  public ShowTopFive(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    ArrayList<Long> longs = new ArrayList<>();

    for (Team team : manager.getTeams()) {
      ui.displayLn("");
      ui.displayLn(team.getTeamName());

      if (!team.getCompetitors().isEmpty()) {
        for (Competitor competitor : team.getCompetitors()) {

          for (TrainingScore trainingScore : competitor.getTrainingScores()) {
            if (trainingScore.getDISCIPLINE() == team.getDiscipline() && trainingScore.getTIME().toMillis() != 0) {
              longs.add(trainingScore.getTIME().toMillis());
            }
          }
        }
        Collections.sort(longs);
        ArrayList<Long> top5;

        if (longs.size() > 5) {
          top5 = new ArrayList<>(longs.subList(0, 5));
        } else {
          top5 = new ArrayList<>(longs.subList(0, longs.size()));
        }

        //for (int i = 0; i < top5.size(); i++) {


        for (Competitor competitor : team.getCompetitors()) {
          for (TrainingScore trainingScore : competitor.getTrainingScores()) {
            if (top5.contains(trainingScore.getTIME().toMillis())) {
              ui.display((top5.indexOf(trainingScore.getTIME().toMillis()) + 1) + ". ");
              ui.displayLn(competitor.getName());
            }
          }
        }

        //}

      } else {
        ui.displayLn("The team is empty");
      }
    }
  }


  @Override
  public String getName() {
    return "Show top 5";
  }
}
