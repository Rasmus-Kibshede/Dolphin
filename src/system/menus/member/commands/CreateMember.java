package system.menus.member.commands;

import system.Command;
import system.manager.Manager;
import system.manager.ui.UI;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateMember implements Command {
    private final Manager MANAGER;

    public CreateMember(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn("Enter member name: ");
        String memberName = ui.getString();
        ui.displayLn("Enter members date of birth: dd-mm-yyyy");
        LocalDate dateOfBirth = ui.getDate();
        ui.displayLn("Enter members email: ");
        String email = ui.getString();
        ui.displayLn("Enter members phone number: ");
        String phoneNumber = ui.getString();
        ui.displayLn("Enter A for active and P for passive");
        int memberNumber = setMemberNumber();
        boolean active = setActive(Character.toLowerCase(ui.getChar('a','p')));
        if (active) {
            ui.displayLn("Enter E for exerciser and C for competitor");
            char choice = ui.getChar('e','c');
            boolean competitor = setType(choice);
            if (competitor) {
                ArrayList<Discipline> disciplines = new ArrayList<>();
                boolean moreDiscipline;
                do{
                    ui.displayLn(MANAGER.getDisciplines());
                    ui.displayLn("Enter the number of the discipline you want to add: ");
                    int disciplineChoice = ui.getInt();
                    disciplines = setDisciplines(disciplineChoice, disciplines);

                    ui.displayLn("Do you want to add another discipline? Y for Yes, N for No: ");
                    moreDiscipline = setMoreDiscipline(Character.toLowerCase(ui.getChar('y','n')));
                } while (moreDiscipline);

                MANAGER.getMembers().add(new Competitor(memberName, dateOfBirth, email, phoneNumber, active, false, memberNumber, disciplines));
                for (int i = 0; i < MANAGER.getMembers().size(); i++) {
                    if (MANAGER.getMembers().get(i).getMemberNumber() == memberNumber) {
                        MANAGER.addToTeam();
                    }
                }
            } else {
                MANAGER.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
            }
        } else {
            MANAGER.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
        }
        MANAGER.getFileHandler().saveFile(MANAGER.getMembers());
    }

    @Override
    public String getName() {
        return "Create Member";
    }

    public Boolean setActive(Character c) {
        if (c == 'p') {
            return false;
        }
        return true;
    }

    public int setMemberNumber() {
        int memberNumber = MANAGER.getFileHandler().loadMemberNumber();
        MANAGER.getFileHandler().saveMemberNumber();
        return memberNumber;
    }

    public Boolean setType(Character c) {
        if (c == 'e') {
            return false;
        }
        return true;
    }

    public ArrayList<Discipline> setDisciplines(int disciplineChoice, ArrayList<Discipline> disciplines){
        if (disciplineChoice == 1) {
            disciplines.add(Discipline.BUTTERFLY);
        } else if (disciplineChoice == 2) {
            disciplines.add(Discipline.CRAWL);
        } else if (disciplineChoice == 3) {
            disciplines.add(Discipline.BACKCRAWL);
        } else if (disciplineChoice == 4) {
            disciplines.add(Discipline.BREASTSTROKE);
        }
        return disciplines;
    }

    private boolean setMoreDiscipline(Character c) {
        if(c == 'y'){
            return true;
        }
        return false;
    }
}
