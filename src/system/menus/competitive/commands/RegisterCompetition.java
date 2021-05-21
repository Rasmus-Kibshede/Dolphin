package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;

public class RegisterCompetition implements Command {
  private Manager manager;

  public RegisterCompetition(Manager manager){
    this.manager = manager;
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
