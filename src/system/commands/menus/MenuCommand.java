package system.commands.menus;

import system.commands.Command;
import system.ui.UI;

public class MenuCommand implements Command {
  private String name;
  private Command[] commands;

  private void printMenu(UI ui, Command[] commands) {

  }

  private int chooseMenuNumber(UI ui, Command[] commands) {
    return 0;
  }

  @Override
  public void execute(UI ui) {

  }

  @Override
  public String getName() {
    return null;
  }

  protected Command[] getCommands() {
    return commands;
  }
}
