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

    public AddDiscipline(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        manager.getShowCompetitors().execute(ui);
        ArrayList<Member> members = manager.getMembers();
        boolean addMore;

        ui.displayLn("Enter the Member Number of the Competitor who you want to add disciplines to: ");
        int choice = ui.getInt("Not a valid number");

        for (Member m : members) {
            if (m instanceof Competitor && m.getMemberNumber() == choice) {
                do {
                    ui.displayLn(manager.getDisciplines());
                    ui.displayLn("Enter the number of the discipline you want to add: Write 0 when done");
                    int choice2;

                    Discipline discipline;
                    do {
                        discipline = ui.getDiscipline();
                    } while (discipline == null);

                    ((Competitor) m).getDisciplines().add(discipline);

                    ui.displayLn("Do you want to add more? Enter Y for Yes and N for No: ");
                    addMore = setMoreDiscipline(Character.toLowerCase(ui.getChar('y', 'n')));
                } while (addMore);
                manager.addToTeam();
            }
        }
    }

    private boolean setMoreDiscipline(Character c) {
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
