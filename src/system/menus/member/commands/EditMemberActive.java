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
    manager.getShowMembers().execute(ui);

    int memberNumber = manager.getMenuNumber("Enter the Member Number of the member you want to edit: ", ui);

    manager.getFileHandler().saveFile(editActivityOfMember(memberNumber, ui));
  }

  public ArrayList<Member> editActivityOfMember(int memberNumber, UI ui) {
    ArrayList<Member> members = manager.getMembers();

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
