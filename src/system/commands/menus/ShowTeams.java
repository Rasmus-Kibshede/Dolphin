package system.commands.menus;

import system.CompetitorManager;
import system.commands.Command;
import system.commands.ShowTeam;

public class ShowTeams extends MenuCommand implements Command {

  private CompetitorManager competitorManager;

  public ShowTeams(CompetitorManager competitorManager){
    this.competitorManager = competitorManager;
  }

  @Override
  public String getName() {
    return "Show Teams";
  }

  @Override
  protected Command[] getCommands() {
    return new Command[] {
            new ShowTeam(this.competitorManager.getTeams()[0]),
            new ShowTeam(this.competitorManager.getTeams()[1]),
            new ShowTeam(this.competitorManager.getTeams()[2]),
            new ShowTeam(this.competitorManager.getTeams()[3]),
            new ShowTeam(this.competitorManager.getTeams()[4]),
            new ShowTeam(this.competitorManager.getTeams()[5]),
            new ShowTeam(this.competitorManager.getTeams()[6]),
            new ShowTeam(this.competitorManager.getTeams()[7])
    };
  }
}
