package system.menus;

import system.manager.Application;
import system.Command;
import system.menus.competitive.CompetitiveAdministration;
import system.menus.economy.EconomyAdministration;
import system.menus.member.MemberAdministration;

public class MainMenu extends MenuCommand {
  private final Application APPLICATION;

  public MainMenu(Application APPLICATION) {
    this.APPLICATION = APPLICATION;
  }

  @Override
  public String getName() {
    return "Administration";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new MemberAdministration(APPLICATION),
        new EconomyAdministration(APPLICATION),
        new CompetitiveAdministration(APPLICATION)
    };
  }
}
