package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;
import java.util.ArrayList;

public class RemoveFromRKI implements Command{

  private MemberManager memberManager;

  public RemoveFromRKI(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {

    ArrayList<Member> members = memberManager.getMembersInRKI();

    for (Member member: members) {
      ui.displayLn(member.toString());
    }

    ui.displayLn("Removing person from RKI");

    ui.display("Which person is to be removed? Please enter a number:");
    int number = ui.getInt("Please enter an existing number");

    for (int i = 0; i < members.size(); i++) {
      Member member = members.get(i);
      if (number == member.getMemberNumber()) {
        members.remove(member);
      }
    }

    memberManager.getFileHandler().saveToRKI(memberManager.getMembersInRKI());
  }

  @Override
  public String getName() {
    return "Remove from RKI";
  }
}
