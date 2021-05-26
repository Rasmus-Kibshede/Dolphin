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
    private final Manager MANAGER;

    public RegisterCompetition(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {

        MANAGER.getShowCompetitors().execute(ui);

        int memberNumber = MANAGER.getMenuNumber("Enter member number for member you want to get: ", ui);

        ui.display("Enter competition name: ");
        String competitionName = ui.getString();
        ui.display("Enter placement: ");
        int placement = ui.getInt();
        ui.display("Enter time - ");
        Duration time = ui.getTime();

        addCompetition(memberNumber, competitionName, placement, time);
    }

    public void addCompetition(int memberNumber, String competitionName, int placement, Duration time){
        for (Member member : MANAGER.getMembers()) {
            if (member.getMemberNumber() == memberNumber) {
                if (member instanceof Competitor) {
                    ((Competitor) member).getCompetitions().add(new Competition(competitionName, placement, time));
                }
            }
        }
        MANAGER.getFileHandler().saveFile(MANAGER.getMembers());
    }

    @Override
    public String getName() {
        return "Register Competition";
    }
}
