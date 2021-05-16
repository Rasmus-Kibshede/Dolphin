package system.commands.menus;

import system.commands.Command;
import system.ui.UI;

public abstract class MenuCommand implements Command {
  protected abstract Command[] getCommands();
  private UI ui;

  @Override
  public void execute(UI ui) {
    this.ui = ui;
    ui.displayLn(this.getName());

    printMenu(this.getCommands());

    int menuOption = this.chooseMenuNumber(this.getCommands());




  }

  private void printMenu(Command[] commands) {
    for (int i = 0; i < commands.length; i++) {
      int menuOptionIndex = ((i)+1);
      ui.displayLn(menuOptionIndex + ". " + commands[i].getName());
    }
  }

  private int chooseMenuNumber(Command[] commands) {
    return ui.validateRange0ToMax(commands.length);
  }
}
