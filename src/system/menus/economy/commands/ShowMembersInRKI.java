package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

public class ShowMembersInRKI implements Command {

  private final Manager MANAGER;

  public ShowMembersInRKI(Manager MANAGER) {
    this.MANAGER = MANAGER;
  }

  @Override
  public void execute(UI ui) {
    for (Member member : MANAGER.getMembersInRKI()) {
      ui.displayLn(member.toString());
    }
  }

  @Override
  public String getName() {
    return "Show Members In RKI";
  }
}
