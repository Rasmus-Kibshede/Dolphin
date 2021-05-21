package system.menus.competitive;

import system.manager.Manager;
import system.Command;
import system.menus.competitive.commands.ShowTeam;
import system.menus.MenuCommand;

public class ShowTeams extends MenuCommand implements Command {
    private Manager manager;

    public ShowTeams(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "Show Teams";
    }

    @Override
    protected Command[] getCommands() {
        return new Command[]{
                new ShowTeam(this.manager.getTeams()[0]),
                new ShowTeam(this.manager.getTeams()[1]),
                new ShowTeam(this.manager.getTeams()[2]),
                new ShowTeam(this.manager.getTeams()[3]),
                new ShowTeam(this.manager.getTeams()[4]),
                new ShowTeam(this.manager.getTeams()[5]),
                new ShowTeam(this.manager.getTeams()[6]),
                new ShowTeam(this.manager.getTeams()[7])
        };
    }
}
