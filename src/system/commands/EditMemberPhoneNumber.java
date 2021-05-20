package system.commands;

import system.CompetitorManager;
import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

// Kamille
public class EditMemberPhoneNumber implements Command{
    private MemberManager memberManager;
    private CompetitorManager competitorManager;

    public EditMemberPhoneNumber(MemberManager memberManager, CompetitorManager competitorManager) {
        this.memberManager = memberManager;
        this.competitorManager = competitorManager;
    }

    @Override
    public void execute(UI ui) {
        memberManager.getShowMembers().execute(ui);
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
        memberManager.getFileHandler().saveFile(members);
    }

    @Override
    public String getName() {
        return "Edit Member Phone Number";
    }
}
