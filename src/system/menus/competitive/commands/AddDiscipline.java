package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.manager.ui.UI;

import java.util.ArrayList;

public class AddDiscipline implements Command {
    private final Manager MANAGER;

    public AddDiscipline(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {
        ArrayList<Member> members = MANAGER.getMembers();

        //Brug en metode istedet for de næste 3 linjer??
        MANAGER.getShowCompetitors().execute(ui);
        ui.displayLn("Enter the Member Number of the Competitor who you want to add disciplines to: ");
        int choice = ui.getInt();

        addDiscipline(members, choice, ui);

        MANAGER.getFileHandler().saveFile(members);
    }

    public void addDiscipline(ArrayList<Member> members, int choice, UI ui){
        boolean addMore;

        for (Member m : members) {
            if (m instanceof Competitor && m.getMemberNumber() == choice) {
                do {
                    ui.displayLn(MANAGER.getDisciplines());
                    ui.displayLn("Enter the number of the discipline you want to add: Write 0 when done");

                    Discipline discipline;
                    do {
                        discipline = ui.getDiscipline();
                    } while (discipline == null);

                    ((Competitor) m).getDisciplines().add(discipline);

                    ui.displayLn("Do you want to add more? Enter Y for Yes and N for No: ");
                    addMore = checkAddMore(Character.toLowerCase(ui.getChar('y', 'n')));
                } while (addMore);
                MANAGER.addToTeam();
            }
        }
    }

    private boolean checkAddMore(Character c) {
        if (c == 'y') {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Add Discipline";
    }
}
