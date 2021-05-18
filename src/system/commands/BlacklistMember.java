package system.commands;

import system.MemberManager;
import system.ui.UI;

public class BlacklistMember implements Command{

  private MemberManager memberManager;

  public BlacklistMember(MemberManager memberManager) {
    this.memberManager = memberManager;
  }


  @Override
  public void execute(UI ui) {

  }

  @Override
  public String getName() {
    return null;
  }
}
