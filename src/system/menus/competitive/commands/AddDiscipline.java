package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.manager.ui.UI;

import java.util.ArrayList;

public class AddDiscipline implements Command {
  private Manager manager;

  public AddDiscipline(Manager manager){
    this.manager = manager;
  }

  @Override
  public void execute(UI ui) {
    manager.getShowCompetitors().execute(ui);
    ArrayList<Member> members = manager.getMembers();
    boolean addMore;

      ui.displayLn("Enter the Member Number of the Competitor who you want to add disciplines to: ");
      int choice = ui.getInt("Not a valid number");

      for(Member m : members){
          if (m instanceof Competitor && m.getMemberNumber() == choice) {
            do {
              ui.displayLn(manager.getDisciplines());
              ui.displayLn("Enter the number of the discipline you want to add: Write 0 when done");
              int choice2;
              do {
                choice2 = ui.getInt("Not a valid number");
                if (choice2 > 0 && choice2 <5) {
                  if (choice2 == 1) {
                    ((Competitor) m).getDisciplines().add(Discipline.BUTTERFLY);
                  } else if (choice2 == 2) {
                    ((Competitor) m).getDisciplines().add(Discipline.CRAWL);
                  } else if (choice2 == 3) {
                    ((Competitor) m).getDisciplines().add(Discipline.BACKCRAWL);
                  } else {
                    ((Competitor) m).getDisciplines().add(Discipline.BREASTSTROKE);
                  }
                }
              } while (!(choice2 == 0));

              ui.displayLn("Enter the number of the discipline you want to add: ");
              addMore = setMoreDiscipline(Character.toLowerCase(ui.getChar('y', 'n')));
            } while (addMore);
            manager.addToTeam((Competitor) m);
          }
      }
  }

  public Discipline disciplines(int disciplineChoice){

    switch (disciplineChoice){
      case 1:
        return Discipline.CRAWL;
      case 2:
        return Discipline.BACKCRAWL;
      case 3:
        return Discipline.BUTTERFLY;
      case 4:
        return Discipline.BREASTSTROKE;
    }
    return null;
  }

  private boolean setMoreDiscipline(Character c) {
    if(c == 'y'){
      return true;
    }
    return false;
  }

  @Override
  public String getName() {
    return "Add Discipline";
  }
}
