package system.commands.menus;

import system.commands.Command;
import system.ui.UI;

public abstract class MenuCommand implements Command {
  protected abstract Command[] getCommands();

  @Override
  public void execute(UI ui) {
    ui.display(this.getName());



  }

  private int chooseMenuNumber(UI ui, Command[] commands) {
    return 0;
  }


  private void printMenu(UI ui, Command[] commands) {

  }
}
