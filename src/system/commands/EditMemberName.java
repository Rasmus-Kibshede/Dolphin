package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

public class EditMemberName implements Command{
    private MemberManager memberManager;

    public EditMemberName(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ArrayList<Member> members = memberManager.getMembers();
        ui.displayLn("Enter the name of the member you want to change: ");
        String name = ui.getString();
        for(Member m : members){
            if (m.getName() == name)
            ui.displayLn("Enter member name: ");
            String newName = ui.getString();
            m.setName(newName);
        }

    }

    @Override
    public String getName() {
        return "Edit Member Name";
    }
}
