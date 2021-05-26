package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.manager.ui.UI;

import java.util.ArrayList;

public class RemoveDiscipline implements Command {
    private final Manager MANAGER;

    public RemoveDiscipline(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {
        MANAGER.getShowCompetitors().execute(ui);

        ArrayList<Member> members = MANAGER.getMembers();
        boolean removeMore;

        do {
            ui.displayLn("Enter the Member Number of the Competitor who you want to remove disciplines from: ");
            int choice = ui.getInt();

            removeDiscipline(members, choice, ui);
            ui.displayLn("Do you want to remove more? Enter Y for Yes and N for No: ");
            removeMore = setRemoveDiscipline(Character.toLowerCase(ui.getChar('y', 'n')));
        } while (removeMore);
      MANAGER.getFileHandler().saveFile(members);
    }

    public void removeDiscipline(ArrayList<Member> members, int choice, UI ui){
        for (Member member : members) {
            if (member instanceof Competitor && choice == member.getMemberNumber()) {
                ArrayList<Discipline> disciplines = ((Competitor) member).getDisciplines();
                for (int i = 0; i < disciplines.size(); i++) {
                    ui.displayLn(((i) + 1) + ". " + disciplines.get(i).toString());
                }
                ui.displayLn("Enter the number of the discipline you want to remove: ");
                int userChoice = ui.getInt();
                MANAGER.removeFromTeam((Competitor) member, disciplines.get(userChoice - 1));
                disciplines.remove(userChoice - 1);
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
