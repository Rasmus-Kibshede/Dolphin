package system.commands.menus;

import system.CompetitorManager;
import system.MemberManager;
import system.commands.*;

public class EditMemberMenu extends MenuCommand {
  private MemberManager memberManager;
  private CompetitorManager competitorManager;

  public EditMemberMenu(MemberManager memberManager, CompetitorManager competitorManager) {
    this.memberManager = memberManager;
    this.competitorManager = competitorManager;
  }

  @Override
  public String getName() {
    return "Edit Member Menu";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[] {
            new EditMemberName(memberManager, competitorManager),
            new EditMemberEmail(memberManager, competitorManager),
            new EditMemberPhoneNumber(memberManager, competitorManager),
            new EditMemberActive(memberManager, competitorManager)
    };
  }
}
