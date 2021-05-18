package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

// Michala
public class ShowMembersInRKI implements Command{

  private MemberManager memberManager;

  public ShowMembersInRKI(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {
    for (Member member : memberManager.getMembersInRKI()) {
      ui.displayLn(member.toString());
    }
  }

  @Override
  public String getName() {
    return null;
  }
}
