package system.menus.competitive;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
import system.menus.competitive.commands.*;

public class CompetitiveAdministration extends MenuCommand {
  //Skal vi ikke bare lave den final??
  private Application application;

  public CompetitiveAdministration(Application application) {
  this.application = application;
  }

  @Override
  protected Command[] getCommands() {

    return new Command[]{
        new ShowTeams(this.application.getMANAGER()),
        new ShowCompetitors(this.application.getMANAGER()),
        new ShowTopFive(this.application.getMANAGER()),
        new RegisterTrainingScore(this.application.getMANAGER()),
        new RegisterCompetition(this.application.getMANAGER()),
        new RemoveDiscipline(this.application.getMANAGER()),
        new AddDiscipline(this.application.getMANAGER())
    };
  }

  @Override
  public String getName() {
    return "Competitive Administration";
  }
}
