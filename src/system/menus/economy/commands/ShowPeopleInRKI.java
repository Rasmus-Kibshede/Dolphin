package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

/**
 This class implements the Interface Command. This class displays the people in RKI to the user.
 */
public class ShowPeopleInRKI implements Command {
  private final Manager MANAGER;

  public ShowPeopleInRKI(Manager MANAGER) {
    this.MANAGER = MANAGER;
  }

  @Override
  public void execute(UI ui) {
    ui.displayLine();
    for (Member member : MANAGER.getPeopleInRKI()) {
      ui.displayMember(member);
    }
  }

  @Override
  public String getName() {
    return "Show People In RKI";
  }
}
