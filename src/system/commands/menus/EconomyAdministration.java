package system.commands.menus;

import system.Application;
import system.commands.*;

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
        new ExpectedIncome(this.application.getMemberManager()),
        new ShowMembersInRKI(this.application.getMemberManager()),
        new EditMemberInDebt(this.application.getMemberManager()),
        new MoveMemberToRKI(this.application.getMemberManager()),
        new RemoveFromRKI(this.application.getMemberManager())
    };

<<<<<<< HEAD
        };
    }
=======
  }
>>>>>>> 818dae52eddff256e48ebf8d7f169bb9b4a13656
}
