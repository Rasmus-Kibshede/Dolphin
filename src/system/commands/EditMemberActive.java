package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

// Kamille
public class EditMemberActive implements Command{
    private MemberManager memberManager;

    public EditMemberActive(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        memberManager.getShowMembers().execute(ui);
        ArrayList<Member> members = memberManager.getMembers();
        ui.displayLn("Enter the Member Number of the member you want to edit: ");
        int memberNumber = ui.getInt("Not a valid number");
        for(Member m : members){
            if(m.getMemberNumber() == memberNumber){
                ui.displayLn("Enter A for Active or P for Passive: ");
                char active = ui.getChar();
                if(active == 'a'){
                    m.setActive(true);
                } else
                    m.setActive(false);
            }
        }
    }

    @Override
    public String getName() {
        return "Edit Member Active";
    }
}
