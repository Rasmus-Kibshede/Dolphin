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
  private UI ui;
  private Command command;

  public Application() {
    MANAGER = new Manager();
    ui = new UI();
    command = new MainMenu(this);
  }

  public void start() {
    this.command.execute(this.ui);
  }

  public Manager getMANAGER() {
    return MANAGER;
  }
}
