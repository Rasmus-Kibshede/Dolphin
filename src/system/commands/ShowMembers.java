package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

public class ShowMembers implements Command{
    private MemberManager memberManager;

    public ShowMembers(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        for (int i = 0; i < memberManager.getMembers().size(); i++) {
            ui.displayLn(memberManager.getMembers().get(i).toString());
        }
    }

    @Override
    public String getName() {
        return "Show Members";
    }
}
