package system.commands;

import system.CompetitorManager;
import system.MemberManager;
import system.member.Member;
import system.member.competition.Competitor;
import system.ui.UI;

import java.util.ArrayList;

public class ShowCompetitors implements Command {

  private CompetitorManager competitorManager;
  private MemberManager memberManager;

  public ShowCompetitors(CompetitorManager competitorManager, MemberManager memberManager) {
    this.competitorManager = competitorManager;
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
