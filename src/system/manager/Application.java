package system.manager;

import system.Command;
import system.menus.MainMenu;
import system.manager.ui.UI;

public class Application {
  private Manager manager;
  private UI ui;
  private Command command;

  public Application() {
    manager = new Manager();
    ui = new UI();
    command = new MainMenu(this);
  }

  public void start() {
    this.command.execute(this.ui);
  }

  public Manager getMemberManager() {
    return manager;
  }
}
