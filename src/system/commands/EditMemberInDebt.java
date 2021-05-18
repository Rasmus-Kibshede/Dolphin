package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

// Michala
public class EditMemberInDebt implements Command {
    private MemberManager memberManager;

    public EditMemberInDebt(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        memberManager.getShowMembers().execute(ui);

        ArrayList<Member> members = memberManager.getMembers(); // Den kender ikke member nu, vel?
        ui.display("Please enter member number of member to be editted.");
        int memberNumber = ui.getInt("Please enter a valid membernumber");

        for (int i = 0; i < members.size(); i++) {
            if (memberNumber == members.get(i).getMemberNumber()) {
                ui.display("Shall member be marked as in debt(y) or not(n)");
                char choice = ui.getChar();
                if (choice == 'y') {
                    members.get(i).setInDebt(true);
                } else if (choice == 'n') {
                    members.get(i).setInDebt(false);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Edit Member In Debt";
    }
}
