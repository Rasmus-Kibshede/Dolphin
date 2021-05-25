package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;
import system.member.Member;

import java.util.ArrayList;

public class RemoveMember implements Command {
    private Manager manager;

    public RemoveMember(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        ArrayList<Member> members = manager.getMembers();
        //manager.getShowMembers().execute(ui);
        ui.displayLn("Removing Member");

        displayMembers(members, ui);

        int memberNumber = manager.getMenuNumber("Which member is to be removed? Please enter Member number: ", ui);

        for (int i = 0; i < manager.getMembers().size(); i++) {
            if (memberNumber == manager.getMembers().get(i).getMemberNumber()) {
                manager.getMembers().remove(manager.getMembers().get(i));
            }
        }


        manager.getFileHandler().saveFile(members);
    }

    public void displayMembers(ArrayList<Member> members, UI ui){
        for (Member member: members) {
            ui.displayLn("");
            ui.display(member.getMemberNumber());
            ui.display(". ");
            ui.displayLn(member.getName());
            ui.displayLn("");
        }
    }



    @Override
    public String getName() {
        return "Remove Member";
    }
}
