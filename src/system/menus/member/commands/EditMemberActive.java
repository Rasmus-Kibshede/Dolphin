package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

import java.util.ArrayList;

public class EditMemberActive implements Command {
  private Manager manager;

  public EditMemberActive(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    ArrayList<Member> members = manager.getMembers();
    //manager.getShowMembers().execute(ui);

    displayMembers(members, ui);


    int memberNumber = manager.getMenuNumber("Enter the Member Number of the member you want to edit: ", ui);

    manager.getFileHandler().saveFile(editActivityOfMember(members, memberNumber, ui));
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
