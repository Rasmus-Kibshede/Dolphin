package system.menus.member;

import system.Command;
import system.manager.Manager;
import system.menus.MenuCommand;
import system.menus.member.commands.EditMemberActive;
import system.menus.member.commands.EditMemberEmail;
import system.menus.member.commands.EditMemberName;
import system.menus.member.commands.EditMemberPhoneNumber;

public class EditMemberMenu extends MenuCommand {
  private Manager manager;

  public EditMemberMenu(Manager manager) {
    this.manager = manager;
  }

  @Override
  public String getName() {
    return "Edit Member Menu";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[] {
            new EditMemberName(manager),
            new EditMemberEmail(manager),
            new EditMemberPhoneNumber(manager),
            new EditMemberActive(manager)
    };
  }
}
