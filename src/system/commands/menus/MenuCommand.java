package system.commands.menus;

import system.commands.Command;
import system.ui.UI;

public abstract class MenuCommand implements Command {
  protected abstract Command[] getCommands();
  private UI ui;

  @Override
  public void execute(UI ui) {
    this.ui = ui;
    Command[] commands = this.getCommands();

    //Displays the current menu
    ui.displayLn(this.getName());

    //Displays the current command options
    printMenu(commands);
    ui.display("Choose your option: ");

    int chosenMenuOption = this.chooseMenuNumber(commands);

    //Gets the actual index, so it matches the command array indexing
    final int MENU_OPTION_INDEX = chosenMenuOption-1;

    Command commandOption = commands[MENU_OPTION_INDEX];
    commandOption.execute(ui);
  }

  private void printMenu(Command[] commands) {
    for (int i = 0; i < commands.length; i++) {
      int menuOptionIndex = ((i)+1);
      ui.displayLn(menuOptionIndex + ". " + commands[i].getName());
    }
  }

  private int chooseMenuNumber(Command[] commands) {
    return ui.validateRange(commands.length);
  }
}
