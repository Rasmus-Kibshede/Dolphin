package system.menus.member;

import system.manager.Application;
import system.Command;
import system.menus.member.commands.CreateMember;
import system.menus.member.commands.RemoveMember;
import system.menus.member.commands.ShowMembers;
import system.menus.MenuCommand;

public class MemberAdministration extends MenuCommand {
  private final Application APPLICATION;

  public MemberAdministration(Application application) {
    this.APPLICATION = application;
  }

  @Override
  public String getName() {
    return "Member Administration";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new ShowMembers(this.APPLICATION.getMANAGER()),
        new CreateMember(this.APPLICATION.getMANAGER()),
        new EditMemberMenu(this.APPLICATION.getMANAGER()),
        new RemoveMember(this.APPLICATION.getMANAGER()),
    };
  }
}
