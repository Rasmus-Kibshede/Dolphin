package system.commands;

import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

public class ShowMembers implements Command{
    private ArrayList<Member> members;

    public ShowMembers(ArrayList<Member> members) {
        this.members = members;
    }

    @Override
    public void execute(UI ui) {
        for (int i = 0; i < members.size(); i++) {
            ui.displayLn(members.get(i).toString());
        }
    }

    @Override
    public String getName() {
        return "showMembers";
    }
}
