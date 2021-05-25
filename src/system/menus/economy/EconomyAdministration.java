package system.menus.economy;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
import system.menus.economy.commands.*;

public class EconomyAdministration extends MenuCommand {
  private final Application APPLICATION;

  public EconomyAdministration(Application APPLICATION) {
    this.APPLICATION = APPLICATION;
  }

  @Override
  public String getName() {
    return "Economy Administration";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new ShowExpectedIncome(this.APPLICATION.getManager()),
        new ShowPeopleInRKI(this.APPLICATION.getManager()),
        new EditMemberDebt(this.APPLICATION.getManager()),
        new MoveMemberToRKI(this.APPLICATION.getManager()),
        new RemovePersonFromRKI(this.APPLICATION.getManager())
    };
  }
}
