package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.manager.ui.UI;

import java.util.ArrayList;

public class RemoveDiscipline implements Command {
    //Skal være final
    private Manager manager;

    public RemoveDiscipline(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        manager.getShowCompetitors().execute(ui);

        ArrayList<Member> members = manager.getMembers();
        boolean removeMore;

        do {
            ui.displayLn("Enter the Member Number of the Competitor who you want to remove disciplines from: ");
            int choice = ui.getInt("Whoops, you must have fucked up... We need a competitors member number");

            removeDiscipline(members, choice, ui);
            ui.displayLn("Do you want to remove more? Enter Y for Yes and N for No: ");
            removeMore = setRemoveDiscipline(Character.toLowerCase(ui.getChar('y', 'n')));
        } while (removeMore);
      manager.getFileHandler().saveFile(members);
    }

    public void removeDiscipline(ArrayList<Member> members, int choice, UI ui){
        for (Member member : members) {
            if (member instanceof Competitor && choice == member.getMemberNumber()) {
                ArrayList<Discipline> disciplines = ((Competitor) member).getDisciplines();
                for (int i = 0; i < disciplines.size(); i++) {
                    ui.displayLn(((i) + 1) + ". " + disciplines.get(i).toString());
                }
                ui.displayLn("Enter the number of the discipline you want to remove: ");
                //Kan man ikke genbruge den første choice??
                int choice1 = ui.getInt("Not a valid number");
                manager.removeFromTeam((Competitor) member, disciplines.get(choice1 - 1));
                disciplines.remove(choice1 - 1);
            }
        }
    }

    private boolean setRemoveDiscipline(Character c) {
        if (c == 'y') {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Remove Discipline";
    }
}
