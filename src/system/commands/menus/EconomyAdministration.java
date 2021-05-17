package system.commands.menus;

import system.Application;
import system.commands.Command;

public class EconomyAdministration extends MenuCommand {
  private Application application;

  public EconomyAdministration(Application application) {
    this.application = application;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  protected Command[] getCommands() {
    return new Command[0];
  }
}
