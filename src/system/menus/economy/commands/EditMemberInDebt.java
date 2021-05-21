package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;
import java.util.ArrayList;

public class EditMemberInDebt implements Command {
    private Manager manager;

    public EditMemberInDebt(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        manager.getShowMembers().execute(ui);

        ArrayList<Member> members = manager.getMembers(); // Den kender ikke member nu, vel?
        ui.display("Please enter member number of member to be editted.");
        int memberNumber = ui.getInt("Please enter a valid membernumber");

        for (int i = 0; i < members.size(); i++) {
            if (memberNumber == members.get(i).getMemberNumber()) {
                ui.display("Shall member be marked as in debt(y) or not(n)");
                char choice = ui.getChar('y','n');
                if (choice == 'y') {
                    members.get(i).setInDebt(true);
                } else if (choice == 'n') {
                    members.get(i).setInDebt(false);
                }
            }
        }
        manager.getFileHandler().saveFile(members);
    }

    @Override
    public String getName() {
        return "Edit Member In Debt";
    }
}
