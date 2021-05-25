package system.menus.economy.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.manager.ui.UI;

/**
 This class implements the Command Interface. This class displays the clubs expected income from all members.
 */
public class ShowExpectedIncome implements Command {

  private final Manager MANAGER;

  public ShowExpectedIncome(Manager MANAGER) {
    this.MANAGER = MANAGER;
  }

  @Override
  public void execute(UI ui) {
    double totalIncome = 0.0;
    for (Member member: MANAGER.getMembers()) {
      totalIncome += member.getMembershipPrice();
    }

    ui.displayLn("Expected Income: " + totalIncome + " kr");
  }

  @Override
  public String getName() {
    return "Expected Income";
  }
}
