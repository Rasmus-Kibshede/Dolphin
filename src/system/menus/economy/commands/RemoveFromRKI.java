package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;
import java.util.ArrayList;

public class RemoveFromRKI implements Command {

  private Manager manager;

  public RemoveFromRKI(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {

    ArrayList<Member> members = manager.getMembersInRKI();

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

    manager.getFileHandler().saveToRKI(manager.getMembersInRKI());
  }

  @Override
  public String getName() {
    return "Remove from RKI";
  }
}
