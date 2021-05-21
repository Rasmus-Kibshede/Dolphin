package system.menus.competitive.commands;

import system.Command;
import system.member.competitor.Team;
import system.manager.ui.UI;

public class ShowTeam implements Command {
    private Team team;

    public ShowTeam(Team team) {
        this.team = team;
    }

    @Override
    public void execute(UI ui) {
        team.toString();
    }

    @Override
    public String getName() {
        return "Show Team: "
                +team.getTeamName();
    }
}
