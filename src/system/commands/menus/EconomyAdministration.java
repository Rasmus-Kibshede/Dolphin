package system.commands.menus;

import system.Application;
import system.commands.BlacklistMember;
import system.commands.Command;
import system.commands.EditMemberInDebt;
import system.commands.ExpectedIncome;

//Kamille
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
        //Find new names!!!! TODO edit the names!!!!
        new ExpectedIncome(this.application.getMemberManager()), //Shows expected income for the club
        new EditMemberInDebt(this.application.getMemberManager()), // shows and adds members in debt
        new BlacklistMember(this.application.getMemberManager()) // remove members from list and add as blacklisted
    };

  }
}
