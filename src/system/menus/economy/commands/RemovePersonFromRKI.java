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

    // er det her ikke teknisk set showmember in rki? altså det i for each loop?
    for (Member member: members) {
      ui.displayLn(member.toString());
    }

    ui.displayLn("Removal of person from RKI");

    ui.display("Which person is to be removed? Please enter their member number:");
    int number = ui.getInt();

    // for each??
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
