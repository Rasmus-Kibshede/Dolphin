package system.commands;

import system.MemberManager;
import system.ui.UI;

public class RegisterTrainingScore implements Command{
  private MemberManager memberManager;

  public RegisterTrainingScore(MemberManager memberManager) {
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {

  }

  @Override
  public String getName() {
    return "Register Training Score";
  }
}
