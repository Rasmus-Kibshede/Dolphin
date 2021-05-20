package system.commands;

import system.MemberManager;
import system.member.Member;
import system.member.competition.Competitor;
import system.member.competition.Discipline;
import system.ui.UI;

import java.util.ArrayList;

public class AddDiscipline implements Command{
  private MemberManager memberManager;

  public AddDiscipline(MemberManager memberManager){
    this.memberManager = memberManager;
  }

  @Override
  public void execute(UI ui) {
    //Meybe use ShowCompetitors?
    memberManager.getShowMembers().execute(ui);
    ArrayList<Member> members = memberManager.getMembers();
    boolean addMore;

      ui.displayLn("Enter the Member Number of the Competitor who you want to add disciplines to: ");
      int choice = ui.getInt("Not a valid number");

      for(Member m : members){
          if (m instanceof Competitor && m.getMemberNumber() == choice) {
            do {
              ArrayList<Discipline> disciplines = ((Competitor) m).getDisciplines();
              //Show disciplines
              ui.displayLn("Enter the number of the discipline you want to add: ");
              choice = ui.getInt("Not a valid number");
              disciplines.add(disciplines(choice));

              ui.displayLn("Enter the number of the discipline you want to add: ");
              addMore = setMoreDiscipline(Character.toLowerCase(ui.getChar('y', 'n')));
            } while (addMore);
          }
      }

  }

  public Discipline disciplines(int disciplineChoice){

    switch (disciplineChoice){
      case 1:
        return Discipline.Crawl;
      case 2:
        return Discipline.Backcrawl;
      case 3:
        return Discipline.Butterfly;
      case 4:
        return Discipline.Breaststroke;
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
