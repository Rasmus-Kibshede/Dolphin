package system.manager;

import system.Command;
import system.menus.MainMenu;
import system.manager.ui.UI;

/**
 This is the middleman between the programs main class and the rest of our program. It is the application that
 starts the whole program via instances of MainMenu, UI and Manager.
 */
public class Application {
  private final Manager MANAGER;
  private final UI UI;
  private final Command COMMAND;

  public Application() {
    MANAGER = new Manager();
    UI = new UI();
    COMMAND = new MainMenu(this);
  }

  public void start() {
    this.COMMAND.execute(this.UI);
  }

  public Manager getMANAGER() {
    return MANAGER;
  }
}
