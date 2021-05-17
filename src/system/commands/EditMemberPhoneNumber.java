package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

public class EditMemberPhoneNumber implements Command{
    private MemberManager memberManager;

    public EditMemberPhoneNumber(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ArrayList<Member> members = memberManager.getMembers();
        ui.displayLn("Enter the Member Number of the member you want to edit: ");
        int memberNumber = ui.getInt("Not a valid number");
        for(Member m : members){
            if(m.getMemberNumber() == memberNumber){
                ui.displayLn("Enter the new phone number: ");
                String phoneNumber = ui.getString();
                m.setPhoneNumber(phoneNumber);
            }
        }
    }

    @Override
    public String getName() {
        return "Edit Member Phone Number";
    }
}
