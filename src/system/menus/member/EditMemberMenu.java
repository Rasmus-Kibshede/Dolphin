package system.menus.member;

import system.Command;
import system.manager.Manager;
import system.menus.MenuCommand;
import system.menus.member.commands.EditMemberActive;
import system.menus.member.commands.EditMemberEmail;
import system.menus.member.commands.EditMemberName;
import system.menus.member.commands.EditMemberPhoneNumber;

public class EditMemberMenu extends MenuCommand {
  private final Manager MANAGER;

  public EditMemberMenu(Manager manager) {
    this.MANAGER = manager;
  }

  @Override
  public String getName() {
    return "Edit Member Menu";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[] {
            new EditMemberName(MANAGER),
            new EditMemberEmail(MANAGER),
            new EditMemberPhoneNumber(MANAGER),
            new EditMemberActive(MANAGER)
    };
  }
}
