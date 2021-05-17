package system.commands;

import system.MemberManager;
import system.ui.UI;

public class RemoveMember implements Command {
    private MemberManager memberManager;

    public RemoveMember(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        // Display members before
        ui.displayLn("Removing Member");
        ui.display("Which member is to be removed? Please enter Membernumber.");
        int memberNumber = ui.getInt();
        for (int i = 0; i < memberManager.getMembers().size(); i++) {
            if (memberNumber == memberManager.getMembers().get(i).getMemberNumber()) {
                memberManager.getMembers().remove(memberManager.getMembers().get(i));
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
