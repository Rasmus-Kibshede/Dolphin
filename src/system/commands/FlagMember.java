package system.commands;

import system.MemberManager;
import system.ui.UI;

public class FlagMember implements Command{

  private MemberManager memberManager;

  public FlagMember(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {

  }

  @Override
  public String getName() {
    return "Flag Member";
  }
}
