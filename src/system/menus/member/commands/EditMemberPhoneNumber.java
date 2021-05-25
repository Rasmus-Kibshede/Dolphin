package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;
import java.util.ArrayList;

public class EditMemberPhoneNumber implements Command {
    private Manager manager;

    public EditMemberPhoneNumber(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        manager.getShowMembers().execute(ui);
        ArrayList<Member> members = manager.getMembers();

        int memberNumber = manager.getMenuNumber("Enter the Member Number of the member you want to edit: ", ui);

        for(Member m : members){
            if(m.getMemberNumber() == memberNumber){
                ui.displayLn("Enter the new phone number: ");
                String phoneNumber = ui.getString();
                m.setPhoneNumber(phoneNumber);
            }
        }
        manager.getFileHandler().saveFile(members);
    }

    @Override
    public String getName() {
        return "Edit Member Phone Number";
    }
}
