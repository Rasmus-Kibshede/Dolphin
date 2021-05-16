package system.commands.menus;

import system.Application;
import system.commands.Command;

public class MainMenu extends MenuCommand {

  private Application application;

  public MainMenu(Application application) {
    this.application = application;
  }

  @Override
  public String getName() {
    //Todo Find a better name?
    return "Person select menu";
  }

  @Override
  protected Command[] getCommands() {
    //Todo make all classes take application
    return new Command[]{
        new ChairmanMenu(application),
        new CashierMenu(),
        new CoachMenu()
    };
  }
}
