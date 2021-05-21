package system.menus.member;

import system.manager.Application;
import system.Command;
import system.menus.member.commands.CreateMember;
import system.menus.member.commands.RemoveMember;
import system.menus.member.commands.ShowMembers;
import system.menus.MenuCommand;

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
        new CreateMember(this.application.getMemberManager()),
        new EditMemberMenu(this.application.getMemberManager()),
        new RemoveMember(this.application.getMemberManager()),
    };
  }
}
