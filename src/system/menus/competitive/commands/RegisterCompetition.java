package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.manager.ui.UI;
import system.member.Member;
import system.member.competitor.Competition;
import system.member.competitor.Competitor;

import java.time.Duration;

/**
 This class (implements command) lets the user give information about a competition and then creates this
 competition so the user can add this competition to a competitors arrayList of competitions.
 */
public class RegisterCompetition implements Command {
    //Skal være final
    private Manager manager;

    public RegisterCompetition(Manager manager) {
        this.manager = manager;
    }


    @Override
    public void execute(UI ui) {

        //Brug en metode istedet for linje de næste 3 linjer??
        manager.getShowCompetitors().execute(ui);
        ui.display("Enter member number for member you want to get: ");
        int memberNumber = ui.getInt("This is not what we are looking for.");

        ui.display("Enter competition name: ");
        String competitionName = ui.getString();
        ui.display("Enter placement: ");
        int placement = ui.getInt("This is not a number");
        ui.display("Enter time - ");
        Duration time = ui.getTime();

        addCompetition(memberNumber, competitionName, placement, time);
    }

    public void addCompetition(int memberNumber, String competitionName, int placement, Duration time){
        for (Member member : manager.getMembers()) {
            if (member.getMemberNumber() == memberNumber) {
                if (member instanceof Competitor) {
                    ((Competitor) member).getCompetitions().add(new Competition(competitionName, placement, time));
                }
            }
        }
        manager.getFileHandler().saveFile(manager.getMembers());
    }

    @Override
    public String getName() {
        return "Register Competition";
    }
}
