package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;
import java.util.ArrayList;

/**
 This class implements Command interface. This class lets the user edit whether a member is in debt or not.
 */
public class EditMemberDebt implements Command {
    private final Manager MANAGER;

    public EditMemberDebt(Manager MANAGER) {
        this.MANAGER = MANAGER;
    }

    @Override
    public void execute(UI ui) {
        MANAGER.getShowMembers().execute(ui);

        ArrayList<Member> members = MANAGER.getMembers(); // Den kender ikke member nu, vel? What do u mean?
        ui.display("\nPlease enter member number of member to be edited: ");
        int memberNumber = ui.getInt();

        for (int i = 0; i < members.size(); i++) {
            if (memberNumber == members.get(i).getMemberNumber()) {
                ui.display("Shall member be marked as in debt(y) or not(n): ");
                char choice = ui.getChar('y','n');
                if (choice == 'y') {
                    members.get(i).setInDebt(true);
                } else if (choice == 'n') {
                    members.get(i).setInDebt(false);
                }
            }
        }
        MANAGER.getFileHandler().saveFile(members);
    }

    @Override
    public String getName() {
        return "Edit Member Debt";
    }
}
