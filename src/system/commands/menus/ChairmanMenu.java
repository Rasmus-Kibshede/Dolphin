package system.commands.menus;

import system.Application;
import system.commands.Command;
import system.commands.CreateMember;
import system.commands.RemoveMember;

public class ChairmanMenu extends MenuCommand {

  private Application application;

  public ChairmanMenu(Application application) {
    this.application = application;
  }

  @Override
  public String getName() {
    //TODO Find another name for it, mic hates it! xD
    return "Chairman menu";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[]{
        new RemoveMember(this.application.getMemberManager()),
        new CreateMember(this.application.getMemberManager()),
        new EditMemberMenu(),
    };
  }
}
