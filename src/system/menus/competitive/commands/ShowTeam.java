package system.menus.competitive.commands;

import system.Command;
import system.member.competitor.Team;
import system.manager.ui.UI;

public class ShowTeam implements Command {
    private final Team TEAM;

    public ShowTeam(Team team) {
        this.TEAM = team;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn(TEAM.toString());
    }

    @Override
    public String getName() {
        return "Show Team: "
                + TEAM.getTeamName();
    }
}
