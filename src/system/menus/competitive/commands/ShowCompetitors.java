package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.manager.ui.UI;

/**
 This class (implements command) is to show the members which are competitors.
 */
public class ShowCompetitors implements Command {
//Skal være fianl
  private Manager manager;

  public ShowCompetitors(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {

    for (Member member : manager.getMembers()) {
      if (member instanceof Competitor) {
        ui.displayLn(member.toString());
      }
    }
  }

  @Override
  public String getName() {
    return "Show Competitors";
  }
}
