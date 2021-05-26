package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;
import system.member.Member;
import java.util.ArrayList;

public class RemoveMember implements Command {
    private final Manager MANAGER;

    public RemoveMember(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {
        ArrayList<Member> members = MANAGER.getMembers();

        ui.displayLn("Removing Member");
        displayMembers(members, ui);

        int memberNumber = MANAGER.getMenuNumber("Which member is to be removed? Please enter Member number: ", ui);

        for (int i = 0; i < MANAGER.getMembers().size(); i++) {
            if (memberNumber == MANAGER.getMembers().get(i).getMemberNumber()) {
                MANAGER.getMembers().remove(MANAGER.getMembers().get(i));
            }
        }
        MANAGER.getFileHandler().saveFile(members);
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
