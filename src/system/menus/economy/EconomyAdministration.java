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
        new ExpectedIncome(this.application.getMemberManager()),
        new ShowMembersInRKI(this.application.getMemberManager()),
        new EditMemberInDebt(this.application.getMemberManager()),
        new MoveMemberToRKI(this.application.getMemberManager()),
        new RemoveFromRKI(this.application.getMemberManager())
    };
  }
}
