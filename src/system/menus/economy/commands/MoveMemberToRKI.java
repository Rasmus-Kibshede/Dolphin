package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;

/**
 This class implements the interface Command. This class lets the user shut down a members membership and
 move them to a file with people in RKI. These people are earlier members who have not paid their bills.
 */
public class MoveMemberToRKI implements Command {
  private final Manager MANAGER;

  public MoveMemberToRKI(Manager MANAGER){
    this.MANAGER = MANAGER;
  }

  @Override
  public void execute(UI ui) {
    MANAGER.getShowMembers().execute(ui);

    ui.displayLn("Which member is to be moved to RKI? Please enter Member number:");
    int memberNumber = ui.getInt("Please enter an existing member number");

    for(int i = 0; i < MANAGER.getMembers().size(); i++){
      if(memberNumber == MANAGER.getMembers().get(i).getMemberNumber()){
        MANAGER.getMembersInRKI().add(MANAGER.getMembers().get(i));
        MANAGER.getMembers().remove(MANAGER.getMembers().get(i));
      }
    }
    MANAGER.getFileHandler().saveToRKI(MANAGER.getMembersInRKI());
  }

  @Override
  public String getName() {
    return "Move Member To RKI";
  }
}
