package system.commands.menus;

import system.Application;
import system.commands.Command;

public class CompetitiveAdministration extends MenuCommand{
  private Application application;

  public CompetitiveAdministration(Application application) {
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
