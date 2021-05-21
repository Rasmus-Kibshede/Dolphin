package system.menus.competitive.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;

public class ShowTopFive implements Command {

  private Manager manager;

  public ShowTopFive(Manager manager) {
    this.manager = manager;
  }


  @Override
  public void execute(UI ui) {



  }

  @Override
  public String getName() {
    return "Show top 5";
  }
}
