package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;
import java.util.ArrayList;

/**
 This class implements the interface Command. This class lets the user remove a member from the RKI file.
 */
public class RemovePersonFromRKI implements Command {
  private final Manager MANAGER;

  public RemovePersonFromRKI(Manager MANAGER) {
    this.MANAGER = MANAGER;
  }

  @Override
  public void execute(UI ui) {
    ArrayList<Member> members = MANAGER.getPeopleInRKI();

    for (Member member: members) {
      ui.displayLn(member.toString());
    }

    ui.displayLn("Removal of person from RKI");

    for (Member RKI : MANAGER.getPeopleInRKI()) {
      ui.display(RKI.getMemberNumber() + ". ");
      ui.display(RKI.getName() + ". ");
      ui.displayLn(RKI.getEmail());
    }

    ui.display("Which person is to be removed? Please enter their member number:");
    int number = ui.getInt();

    for (int i = 0; i < members.size(); i++) {
      Member member = members.get(i);
      if (number == member.getMemberNumber()) {
        members.remove(member);
      }
    }
    MANAGER.getFileHandler().saveRKI(MANAGER.getPeopleInRKI());
  }

  @Override
  public String getName() {
    return "Removal from RKI";
  }
}
