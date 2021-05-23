package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.competitor.Competitor;
import system.member.competitor.Team;
import system.member.competitor.TrainingScore;
import java.util.ArrayList;

public class ShowTopFive implements Command {

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

      if (!team.getCompetitors().isEmpty()){
        for (Competitor competitor : team.getCompetitors()) {
          for (TrainingScore trainingScore: competitor.getTrainingScores()) {
            if (trainingScore.getDiscipline() == team.getDiscipline()) {
              longs.add(trainingScore.getTime().toMillis());
            }
          }
        }

        ArrayList<Long> top5 = new ArrayList<>(longs.subList(longs.size()-5, longs.size()));

        for (int i = 0; i < top5.size(); i++) {
          int RankIndex = ((i)+1);
          for (TrainingScore trainingScore : team.getCompetitors().get(i).getTrainingScores()) {
            if (trainingScore.getDiscipline() == team.getDiscipline()) {
              if (top5.get(i) == trainingScore.getTime().toMillis()) {
                ui.display(RankIndex + ". ");
                ui.displayLn(team.getCompetitors().get(i).getName());
              }
            }
          }
        }
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
