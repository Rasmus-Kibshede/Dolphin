package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;

public class RemoveMember implements Command {
    private Manager manager;

    public RemoveMember(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        manager.getShowMembers().execute(ui); //Skal måske flyttes ned mellem removing member og which member?
        ui.displayLn("Removing Member");

        int memberNumber = manager.getMenuNumber("Which member is to be removed? Please enter Member number: ", ui);

        //Vi skal have smidt et loop ind

        for (int i = 0; i < manager.getMembers().size(); i++) {
            if (memberNumber == manager.getMembers().get(i).getMemberNumber()) {
                manager.getMembers().remove(manager.getMembers().get(i));
            }
        }
        manager.getFileHandler().saveFile(manager.getMembers());
    }

    @Override
    public String getName() {
        return "Remove Member";
    }
}
