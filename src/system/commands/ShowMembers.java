package system.commands;

import system.MemberManager;
import system.ui.UI;

public class ShowMembers implements Command{
    private MemberManager memberManager;

    public ShowMembers(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn("");
        for (int i = 0; i < memberManager.getMembers().size(); i++) {
            ui.displayLn(memberManager.getMembers().get(i).toString());
        }
    }

    @Override
    public String getName() {
        return "Show Members";
    }
}
