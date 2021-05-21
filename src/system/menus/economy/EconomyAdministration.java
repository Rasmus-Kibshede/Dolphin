package system.menus.economy;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
import system.menus.economy.commands.*;

public class EconomyAdministration extends MenuCommand {
  private Application application;

  public EconomyAdministration(Application application) {
    this.application = application;
  }

  @Override
  public String getName() {
    return "Economy Administration";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new ExpectedIncome(this.application.getManager()),
        new ShowMembersInRKI(this.application.getManager()),
        new EditMemberInDebt(this.application.getManager()),
        new MoveMemberToRKI(this.application.getManager()),
        new RemoveFromRKI(this.application.getManager())
    };
  }
}
