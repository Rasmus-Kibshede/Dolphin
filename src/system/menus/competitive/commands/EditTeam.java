package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;

public class EditTeam implements Command {

  private Manager manager;

  public EditTeam(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {

  }

  @Override
  public String getName() {
    return "Edit Team";
  }
}
