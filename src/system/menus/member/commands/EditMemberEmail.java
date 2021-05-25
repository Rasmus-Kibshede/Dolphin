package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

import java.util.ArrayList;

public class EditMemberEmail implements Command {
  private Manager manager;

  public EditMemberEmail(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {

    ArrayList<Member> members = manager.getMembers();


    //manager.getShowMembers().execute(ui);
    displayMembers(members, ui);


    int memberNumber = manager.getMenuNumber("Enter the Member Number of the member you want to edit: ", ui);

    for (Member m : members) {
      if (m.getMemberNumber() == memberNumber) {
        ui.displayLn("Enter the new email:");
        String newEmail = ui.getString();
        m.setEmail(newEmail);
      }
    }
    manager.getFileHandler().saveFile(members);
  }

  public void displayMembers(ArrayList<Member> members, UI ui) {
    for (Member member : members) {
      ui.display(member.getMemberNumber());
      ui.display(". ");
      ui.display(member.getName());
      ui.display(". ");
      ui.display(member.getEmail());
      ui.displayLn("");
    }
  }

  @Override
  public String getName() {
    return "Edit Member Email";
  }
}
