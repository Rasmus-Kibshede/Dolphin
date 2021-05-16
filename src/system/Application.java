package system;

import system.commands.Command;
import system.commands.menus.MainMenu;
import system.ui.UI;

public class Application {
  private MemberManager memberManager;
  private UI ui;
  private Command command;

  public Application() {
    memberManager = new MemberManager();
    ui = new UI();
    command = new MainMenu(this);
  }

  public void start() {
    this.command.execute(this.ui);
  }

  public MemberManager getMemberManager() {
    return memberManager;
  }
}
