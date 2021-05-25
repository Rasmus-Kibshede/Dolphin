package system.menus.competitive;

import system.manager.Manager;
import system.Command;
import system.menus.competitive.commands.ShowTeam;
import system.menus.MenuCommand;

public class ShowTeams extends MenuCommand implements Command {
    private final Manager MANAGER;

    public ShowTeams(Manager MANAGER) {
        this.MANAGER = MANAGER;
    }

    @Override
    public String getName() {
        return "Show Teams";
    }

    @Override
    protected Command[] getCommands() {
        return new Command[]{
                new ShowTeam(this.MANAGER.getTeams()[0]),
                new ShowTeam(this.MANAGER.getTeams()[1]),
                new ShowTeam(this.MANAGER.getTeams()[2]),
                new ShowTeam(this.MANAGER.getTeams()[3]),
                new ShowTeam(this.MANAGER.getTeams()[4]),
                new ShowTeam(this.MANAGER.getTeams()[5]),
                new ShowTeam(this.MANAGER.getTeams()[6]),
                new ShowTeam(this.MANAGER.getTeams()[7])
        };
    }
}
