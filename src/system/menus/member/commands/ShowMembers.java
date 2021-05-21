package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;
import java.util.Collections;

public class ShowMembers implements Command {
    private Manager manager;

    public ShowMembers(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn("");
        for (int i = 0; i < manager.getMembers().size(); i++) {
            Collections.sort(manager.getMembers());
            ui.displayLn(manager.getMembers().get(i).toString());
        }
    }

    @Override
    public String getName() {
        return "Show Members";
    }
}
