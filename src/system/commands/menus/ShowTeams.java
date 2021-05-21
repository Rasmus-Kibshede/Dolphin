package system.commands.menus;

import system.CompetitorManager;
import system.commands.Command;
import system.commands.ShowTeam;
import system.member.competition.Team;
import system.ui.UI;

public class ShowTeams extends MenuCommand implements Command {

  private CompetitorManager competitorManager;

  public ShowTeams(CompetitorManager competitorManager){
    this.competitorManager = competitorManager;
  }

  @Override
  public void execute(UI ui) {

  }

  @Override
  public String getName() {
    return "Show Teams";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[] {
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager),
            new ShowTeam(this.competitorManager)
    };
  }
}
