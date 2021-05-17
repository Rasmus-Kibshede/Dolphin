package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

//Kamille
public class EditMemberEmail implements Command{
    private MemberManager memberManager;

    public EditMemberEmail(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ArrayList<Member> members = memberManager.getMembers();
        ui.displayLn("Enter the Member Number of the member you want to edit: ");
        int memberNumber = ui.getInt("Not a valid number");
        for(Member m : members){
            if(m.getMemberNumber() == memberNumber){
                ui.displayLn("Enter the new email:");
                String newEmail = ui.getString();
                m.setEmail(newEmail);
            }
        }
    }

    @Override
    public String getName() {
        return "Edit Member Email";
    }
}
