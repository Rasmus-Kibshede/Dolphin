package system.commands.menus;

import system.MemberManager;
import system.commands.*;

public class EditMemberMenu extends MenuCommand {
  private MemberManager memberManager;

  public EditMemberMenu(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public String getName() {
    return "Edit Member Menu";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[] {
            new EditMemberName(memberManager),
            new EditMemberEmail(memberManager),
            new EditMemberPhoneNumber(memberManager),
            new EditMemberActive(memberManager)
    };
  }
}
