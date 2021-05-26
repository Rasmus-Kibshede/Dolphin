package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;
import java.util.Collections;

public class ShowMembers implements Command {
    private final Manager MANAGER;

    public ShowMembers(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLine();
        for (int i = 0; i < MANAGER.getMembers().size(); i++) {
            Collections.sort(MANAGER.getMembers());
            ui.displayMember(MANAGER.getMembers().get(i));
        }
    }

    @Override
    public String getName() {
        return "Show Members";
    }
}
