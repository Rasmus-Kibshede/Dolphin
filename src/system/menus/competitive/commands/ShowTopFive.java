package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.competitor.Competitor;
import system.member.competitor.Team;
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
          longs.add(competitor.getTrainingScore().getTime().getSeconds());
        }

        ArrayList<Long> top5 = new ArrayList<>(longs.subList(longs.size()-5, longs.size()));

        for (int i = 0; i < top5.size(); i++) {
          int RankIndex = ((i)+1);
          if (top5.get(i) == team.getCompetitors().get(i).getTrainingScore().getTime().toMillis()) {
            ui.display(RankIndex + ". ");
            ui.displayLn(team.getCompetitors().get(i).getName());
          }
        }
      }else {
        ui.displayLn("The team is empty");
      }


    }
  }


  @Override
  public String getName() {
    return "Show top 5";
  }
}
