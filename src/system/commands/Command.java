package system.commands;

import system.ui.UI;

public interface Command {
    void execute(UI ui);

    String getName();
}