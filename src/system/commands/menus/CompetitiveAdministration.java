package system.commands.menus;

import system.Application;
import system.commands.*;

public class CompetitiveAdministration extends MenuCommand{
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

        //new ShowTopFive(this.application.getMemberManager()),
        //new ShowCompetitors(this.application.getMemberManager()),
        //new ShowTeams(this.application.getMemberManager(), this.application.getCompetitorManager()),
        //new RegisterTrainingScore(this.application.getMemberManager()),
        //new RegisterCompetition(this.application.getMemberManager(), this.application.getCompetitorManager()),
        //new EditTeam(this.application.getMemberManager(), this.application.getCompetitorManager()),
        //new EditMemberType()// Eller havde vi droppet den?

        new ShowTopFive(),
        new ShowCompetitors(this.application.getMemberManager()),/*
        new ShowTeams(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new RegisterTrainingScore(this.application.getMemberManager()),
        new RegisterCompetition(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditTeam(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditMemberType()// Eller havde vi droppet den?
        */

    };
  }
}
