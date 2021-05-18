package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

public class ExpectedIncome implements Command {

  private MemberManager memberManager;

  public ExpectedIncome(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {
    double totalIncome = 0.0;
    for (Member member: memberManager.getMembers()) {
      totalIncome += member.getMembershipPrice();
    }
    //Readable?
    ui.displayLn("Expected Income: " + String.valueOf(totalIncome) + " kr");
  }

  @Override
  public String getName() {
    return "Expected Income";
  }
}
