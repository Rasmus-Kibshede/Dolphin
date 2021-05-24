package system.menus.competitive;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
import system.menus.competitive.commands.*;

public class CompetitiveAdministration extends MenuCommand {
  private Application application;

  public CompetitiveAdministration(Application application) {
  this.application = application;
  }

  @Override
  protected Command[] getCommands() {

    return new Command[]{
        new ShowTeams(this.application.getManager()),
        new ShowCompetitors(this.application.getManager()),
        new ShowTopFive(this.application.getManager()),
        new RegisterTrainingScore(this.application.getManager()),
        new RegisterCompetition(this.application.getManager()),
        new RemoveDiscipline(this.application.getManager()),
        new AddDiscipline(this.application.getManager())
    };
  }

  @Override
  public String getName() {
    return "Competitive Administration";
  }
}
