package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;

public class MoveMemberToRKI implements Command {

  private Manager manager;

  public MoveMemberToRKI(Manager manager){
    this.manager = manager;
  }


  @Override
  public void execute(UI ui) {
    manager.getShowMembers().execute(ui);

    ui.displayLn("Which member is to be moved to RKI? Please enter Member number:");
    int memberNumber = ui.getInt("Please enter an existing member number");

    for(int i = 0; i < manager.getMembers().size(); i++){
      if(memberNumber == manager.getMembers().get(i).getMemberNumber()){
        manager.getMembersInRKI().add(manager.getMembers().get(i));
        manager.getMembers().remove(manager.getMembers().get(i));
      }
    }
    manager.getFileHandler().saveToRKI(manager.getMembersInRKI());

  }

  @Override
  public String getName() {
    return "Move Member To RKI";
  }
}
