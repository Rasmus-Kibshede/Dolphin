package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;
import java.util.ArrayList;

public class EditMemberActive implements Command {
    private Manager manager;

    public EditMemberActive(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        manager.getShowMembers().execute(ui);
        ArrayList<Member> members = manager.getMembers();
        ui.displayLn("Enter the Member Number of the member you want to edit: ");
        int memberNumber = ui.getInt("Not a valid number");
        for(Member m : members){
            if(m.getMemberNumber() == memberNumber){
                ui.displayLn("Enter A for Active or P for Passive: ");
                char active = ui.getChar('a','p');
                if(active == 'a'){
                    m.setActive(true);
                } else
                    m.setActive(false);
            }
        }
        manager.getFileHandler().saveFile(members);
    }

    @Override
    public String getName() {
        return "Edit Member Active";
    }
}