package system.menus;

import system.Command;
import system.manager.ui.UI;

public abstract class MenuCommand implements Command {
    protected abstract Command[] getCommands();
    private UI ui;

    @Override
    public void execute(UI ui) {
        this.ui = ui;
        Command[] commands = this.getCommands();

        int menuOptionIndex;
        do {
            //Displays the current menu
            ui.displayLn("");
            ui.displayLn(this.getName());
            printMenu(commands);
            ui.displayLn("");
            ui.display("Choose your option: ");

            //Displays the current command options
            int chosenMenuOption = this.chooseMenuNumber(commands);

            //Gets the actual index, so it matches the command array indexing
            menuOptionIndex = chosenMenuOption - 1;
            if (menuOptionIndex != -1) {
                Command commandOption = commands[menuOptionIndex];
                commandOption.execute(ui);
            }
        } while (menuOptionIndex != -1);
    }

    private void printMenu(Command[] commands) {
        for (int i = 0; i < commands.length; i++) {
            int menuOptionIndex = ((i) + 1);
            ui.displayLn(menuOptionIndex + ". " + commands[i].getName());
        }
        ui.displayLn("Write 0 if you want to exit.");
    }

    private int chooseMenuNumber(Command[] commands) {
        return ui.getValidRange(commands.length);
    }
}
