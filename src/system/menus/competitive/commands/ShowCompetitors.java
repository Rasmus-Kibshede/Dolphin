package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.manager.ui.UI;

/**
 * This class (implements command) is to show the members which are competitors.
 */
public class ShowCompetitors implements Command {
  private final Manager MANAGER;

  public ShowCompetitors(Manager manager) {
    this.MANAGER = manager;
  }

  @Override
  public void execute(UI ui) {
    ui.displayLine();
    for (Member member : MANAGER.getMembers()) {
      if (member instanceof Competitor) {
        ui.displayMember(member);
      }
    }
  }

  @Override
  public String getName() {
    return "Show Competitors";
  }
}
