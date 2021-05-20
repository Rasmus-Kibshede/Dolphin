package system.commands.menus;

import system.Application;
import system.commands.Command;
import system.commands.CreateMember;
import system.commands.RemoveMember;
import system.commands.ShowMembers;

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
        new ShowMembers(this.application.getMemberManager()),
        new CreateMember(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditMemberMenu(this.application.getMemberManager()),
        new RemoveMember(this.application.getMemberManager(), this.application.getCompetitorManager()),
    };
  }
}
