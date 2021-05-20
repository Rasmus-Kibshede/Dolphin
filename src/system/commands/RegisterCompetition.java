package system.commands;

import system.CompetitorManager;
import system.member.competition.Competition;
import system.ui.UI;

public class RegisterCompetition implements Command{


  private CompetitorManager competitorManager;

  public RegisterCompetition(CompetitorManager competitorManager){
    this.competitorManager = competitorManager;
  }



  @Override
  public void execute(UI ui) {

    ui.display("Competition name: ");
    String CompetitionName = ui.getString();


    //competitorManager.getCompetitions().add(new Competition(CompetitionName))




  }

  @Override
  public String getName() {
    return "Register Competition";
  }
}
