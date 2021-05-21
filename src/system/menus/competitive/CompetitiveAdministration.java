package system.menus.competitive;

import system.Command;
import system.manager.Application;
import system.menus.MenuCommand;
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
        new ShowTopFive(),/*
        new ShowCompetitors(this.application.getMemberManager()),
        new ShowTeams(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new RegisterTrainingScore(this.application.getMemberManager()),
        new RegisterCompetition(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditTeam(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditMemberType()// Eller havde vi droppet den?
        */
    };
  }
}
