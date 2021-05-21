package system.menus;

import system.manager.Application;
import system.Command;
import system.menus.competitive.CompetitiveAdministration;
import system.menus.economy.EconomyAdministration;
import system.menus.member.MemberAdministration;

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
