package system.commands.menus;

import system.Application;
import system.commands.Command;
import system.commands.CreateMember;
import system.commands.RemoveMember;

//Rasmus
public class MemberAdministration extends MenuCommand {

  private Application application;

  public MemberAdministration(Application application) {
    this.application = application;
  }

  @Override
  public String getName() {
    return "Member Administration";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new RemoveMember(this.application.getMemberManager()),
        new CreateMember(this.application.getMemberManager()),
        new EditMemberMenu(this.application.getMemberManager()),
    };
  }
}
