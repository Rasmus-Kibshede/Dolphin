package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.manager.ui.UI;

import java.util.ArrayList;

public class RemoveDiscipline implements Command {
  private Manager manager;

  public RemoveDiscipline(Manager manager){
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    //Maybe use ShowCompetitors??
    manager.getShowMembers().execute(ui);
    ArrayList<Member> members = manager.getMembers();
    boolean removeMore;
    do {
      ui.displayLn("Enter the Member Number of the Competitor who you want to remove disciplines from: ");
      int choice = ui.getInt("Not a valid number");
      for (Member m : members) {
        if (m instanceof Competitor && choice == m.getMemberNumber()) {
          ArrayList<Discipline> disciplines = ((Competitor) m).getDisciplines();
          //Show disciplines
          ui.displayLn("Enter the number of the discipline you want to remove");
          choice = ui.getInt("Not a valid number");
          for (int i = 0; i < disciplines.size(); i++) {
            if (disciplines.indexOf(disciplines.get(i)) == choice) {
              disciplines.remove(disciplines.get(i));
            }
          }
        }
      }
      removeMore = setRemoveDiscipline(Character.toLowerCase(ui.getChar('y','n')));
    }while (removeMore);
  }

  private boolean setRemoveDiscipline(Character c) {
    if(c == 'y'){
      return true;
    }
    return false;
  }

  @Override
  public String getName() {
    return "Remove Discipline";
  }
}
