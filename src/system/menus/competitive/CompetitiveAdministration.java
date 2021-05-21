package system.menus.competitive;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
import system.menus.competitive.commands.RegisterCompetition;
import system.menus.competitive.commands.RegisterTrainingScore;
import system.menus.competitive.commands.ShowCompetitors;
import system.menus.competitive.commands.ShowTopFive;

public class CompetitiveAdministration extends MenuCommand {
  private Application application;

  public CompetitiveAdministration(Application application) {
  this.application = application;
  }

  @Override
  public String getName() {
    return "Competitive Administration";
  }

  @Override
  protected Command[] getCommands() {

    return new Command[]{
        new ShowTopFive(),
        new ShowTeams(this.application.getManager()),

        new ShowCompetitors(this.application.getManager()),

        new RegisterTrainingScore(this.application.getManager()),

        new RegisterCompetition(this.application.getManager()),

        /*
        new EditTeam(this.application.getMemberManager()),
        new EditMemberType()// Eller havde vi droppet den?
         */

    };
  }
}
