package system.commands;

import system.MemberManager;
import system.ui.UI;

public class CreateMember implements Command {
    private String name;
    private MemberManager memberManager;

    public CreateMember(MemberManager memberManager) {

    }

    @Override
    public void execute(UI ui) {

    }

    @Override
    public String getName() {
        return null;
    }
}
