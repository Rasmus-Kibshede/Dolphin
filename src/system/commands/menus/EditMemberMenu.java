package system.commands.menus;

import system.MemberManager;
import system.commands.Command;

public class EditMemberMenu extends MenuCommand {
  private MemberManager memberManager;

  public EditMemberMenu(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  protected Command[] getCommands() {
    return new Command[0];
  }
}