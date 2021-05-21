package system;

import system.manager.ui.UI;

public interface Command {
    void execute(UI ui);

    String getName();
}