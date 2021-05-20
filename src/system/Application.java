package system;

import system.commands.Command;
import system.commands.menus.MainMenu;
import system.member.Member;
import system.ui.UI;

import java.util.ArrayList;

//Kamille
public class Application {
  private MemberManager memberManager;
  private CompetitorManager competitorManager;
  private UI ui;
  private Command command;

  public Application() {
    memberManager = new MemberManager();
    competitorManager = new CompetitorManager();
    ui = new UI();
    command = new MainMenu(this);
  }

  public void start() {
    this.command.execute(this.ui);
  }

  public MemberManager getMemberManager() {
    return memberManager;
  }

  public CompetitorManager getCompetitorManager(){
    return competitorManager;
  }
}
