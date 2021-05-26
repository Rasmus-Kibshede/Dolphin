package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

import java.util.ArrayList;

public class EditMemberActive implements Command {
  private final Manager MANAGER;

  public EditMemberActive(Manager manager) {
    this.MANAGER = manager;
  }

  @Override
  public void execute(UI ui) {
    ArrayList<Member> members = MANAGER.getMembers();

    displayMembers(members, ui);

    int memberNumber = MANAGER.getMenuNumber("Enter the Member Number of the member you want to edit: ", ui);

    MANAGER.getFileHandler().saveFile(editActivityOfMember(members, memberNumber, ui));
  }

  public void displayMembers(ArrayList<Member> members, UI ui){
    for (Member member: members) {
      ui.displayLn("");
      ui.display(member.getMemberNumber());
      ui.display(". ");
      ui.display(member.getName());
      ui.display(". ");
      ui.display(String.valueOf(member.getActive()));
      ui.displayLn("");
    }
  }

  public ArrayList<Member> editActivityOfMember(ArrayList<Member> members, int memberNumber, UI ui) {

    for (Member m : members) {
      if (m.getMemberNumber() == memberNumber) {
        ui.displayLn("Enter A for Active or P for Passive: ");

        char active = ui.getChar('a', 'p');

        if (isActive(active)) {
          m.setActive(true);
        } else {
          m.setActive(false);
        }
      }
    }

    return members;
  }

  public boolean isActive(char c) {
    if (c == 'a') {
      return true;
    }
    return false;
  }

  @Override
  public String getName() {
    return "Edit Member Active";
  }
}
