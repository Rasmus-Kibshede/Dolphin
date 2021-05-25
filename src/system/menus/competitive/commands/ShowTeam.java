package system.menus.competitive.commands;

import system.Command;
import system.member.competitor.Team;
import system.manager.ui.UI;

public class ShowTeam implements Command {
    //Skal være final
    private Team team;

    public ShowTeam(Team team) {
        this.team = team;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn(team.toString());
    }

    @Override
    public String getName() {
        return "Show Team: "
                +team.getTeamName();
    }
}
