package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.Member;
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

    for (Team team : manager.getTeams()) {
      ui.displayLn("");
      ui.displayLn(team.getTeamName());

      if (!team.getCompetitors().isEmpty()) {

        ArrayList<Competitor> competitors = new ArrayList<>();

        for (int i = 0; i < team.getCompetitors().size(); i++) {

          Competitor competitor = team.getCompetitors().get(i);

          for (int j = 0; j < competitor.getTrainingScores().size(); j++) {
            if (competitor.getTrainingScores().get(j).getDISCIPLINE().equals(team.getDiscipline())) {
              if (competitor.getTrainingScores().get(j).getTIME().toMillis() != 0) {
                competitors.add(competitor);
              }
            }
          }


        }

        Collections.sort(competitors);


        int size = 0;
        if (competitors.size() > 5) {
          size = 5;
        } else {
          size = competitors.size();
        }

        for (int i = 0; i < size; i++) {
          int rankIndex = ((i) + 1);
          ui.displayLn(rankIndex + ". " + competitors.get(i).getName());
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
