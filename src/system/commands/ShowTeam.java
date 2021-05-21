package system.commands;

import system.CompetitorManager;
import system.member.competition.Team;
import system.ui.UI;

public class ShowTeam implements Command {
    private CompetitorManager competitorManager;

    public ShowTeam(CompetitorManager competitorManager){
        this.competitorManager = competitorManager;
    }

    @Override
    public void execute(UI ui) {
        for (Team team: competitorManager.getTeams()) {
            ui.displayLn(team.toString());
        }
    }

    @Override
    public String getName() {
        return "Show Team";
    }
}
