package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

public class ShowMembersInRKI implements Command {

  private Manager manager;

  public ShowMembersInRKI(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    for (Member member : manager.getMembersInRKI()) {
      ui.displayLn(member.toString());
    }
  }

  @Override
  public String getName() {
    return "Show Members In RKI";
  }
}
