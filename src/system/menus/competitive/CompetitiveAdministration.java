package system.menus.competitive;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
import system.menus.competitive.commands.*;

public class CompetitiveAdministration extends MenuCommand {
  private final Application APPLICATION;

  public CompetitiveAdministration(Application application) {
  this.APPLICATION = application;
  }

  @Override
  protected Command[] getCommands() {

    return new Command[]{
        new ShowTeams(this.APPLICATION.getMANAGER()),
        new ShowCompetitors(this.APPLICATION.getMANAGER()),
        new ShowTopFive(this.APPLICATION.getMANAGER()),
        new RegisterTrainingScore(this.APPLICATION.getMANAGER()),
        new RegisterCompetition(this.APPLICATION.getMANAGER()),
        new RemoveDiscipline(this.APPLICATION.getMANAGER()),
        new AddDiscipline(this.APPLICATION.getMANAGER())
    };
  }

  @Override
  public String getName() {
    return "Competitive Administration";
  }
}
