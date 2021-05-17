package system.commands.menus;

import system.Application;
import system.commands.Command;

//Rasmus
public class MainMenu extends MenuCommand {
  private Application application;

  public MainMenu(Application application) {
    this.application = application;
  }

  @Override
  public String getName() {
    return "Administration";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new MemberAdministration(application),
        new EconomyAdministration(application),
        new CompetitiveAdministration(application)
    };
  }
}
