package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

public class ExpectedIncome implements Command {

  private Manager manager;

  public ExpectedIncome(Manager manager) {
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    double totalIncome = 0.0;
    for (Member member: manager.getMembers()) {
      totalIncome += member.getMembershipPrice();
    }
    //Readable?
    ui.displayLn("Expected Income: " + String.valueOf(totalIncome) + " kr");
  }

  @Override
  public String getName() {
    return "Expected Income";
  }
}
