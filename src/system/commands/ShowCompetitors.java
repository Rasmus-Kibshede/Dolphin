package system.commands;

import system.MemberManager;
import system.member.Member;
import system.member.competition.Competitor;
import system.ui.UI;

public class ShowCompetitors implements Command {

  private MemberManager memberManager;

  public ShowCompetitors(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {

    for (Member member : memberManager.getMembers()) {
      if (member instanceof Competitor) {
        ui.displayLn(member.toString());
      }
    }

  }

  @Override
  public String getName() {
    return "Show Competitors";
  }
}
