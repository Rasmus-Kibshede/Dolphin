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
<<<<<<< HEAD
        new ShowTopFive(),/*
        new ShowCompetitors(this.application.getMemberManager()),
=======

        //new ShowTopFive(this.application.getMemberManager()),
        //new ShowCompetitors(this.application.getMemberManager()),
        //new ShowTeams(this.application.getMemberManager(), this.application.getCompetitorManager()),
        //new RegisterTrainingScore(this.application.getMemberManager()),
        //new RegisterCompetition(this.application.getMemberManager(), this.application.getCompetitorManager()),
        //new EditTeam(this.application.getMemberManager(), this.application.getCompetitorManager()),
        //new EditMemberType()// Eller havde vi droppet den?

        new ShowTopFive(),
        new ShowCompetitors(this.application.getMemberManager()),/*
>>>>>>> 3b3a6106d668a1c48064ee18a2430a8f5ebbba26
        new ShowTeams(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new RegisterTrainingScore(this.application.getMemberManager()),
        new RegisterCompetition(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditTeam(this.application.getMemberManager(), this.application.getCompetitorManager()),
        new EditMemberType()// Eller havde vi droppet den?
        */
<<<<<<< HEAD
=======

>>>>>>> 3b3a6106d668a1c48064ee18a2430a8f5ebbba26
    };
  }
}
