package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.competitor.Competitor;
import system.member.competitor.Team;

import java.util.ArrayList;
import java.util.Arrays;


public class ShowTopFive implements Command {

  private Manager manager;

  public ShowTopFive(Manager manager) {
    this.manager = manager;
  }


  @Override
  public void execute(UI ui) {

    /*

    ArrayList<Long> longs = new ArrayList<>();

    for (Team team : manager.getTeams()) {
      for (Competitor competitor : team.getCompetitors()) {
        longs.add(competitor.getTrainingScore().getTime().getSeconds());
      }

      ArrayList<Long> top5 = new ArrayList<>(longs.subList(longs.size()-5, longs.size()));

      for (Competitor competitor : team.getCompetitors()) {
        for (Long aLong : top5) {
          if (aLong == competitor.getTrainingScore().getTime().getSeconds()){
            ui.displayLn(competitor.getName());
          }
        }
      }

    }

    //se hvem af comp der har de bedste tider



     */

  }

  @Override
  public String getName() {
    return "Show top 5";
  }
}
