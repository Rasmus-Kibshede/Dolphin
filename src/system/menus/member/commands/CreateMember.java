package system.menus.member.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.manager.ui.UI;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

//Kamille
public class CreateMember implements Command {
    private Manager manager;

    public CreateMember(Manager manager) {
        this.manager = manager;
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
                    //Show a list of disciplines
                    ui.displayLn("Enter the number of the discipline you want to add: ");
                    int disciplineChoice = ui.getInt("Not a valid number");
                    disciplines = setDisciplines(disciplineChoice, disciplines);

                    ui.displayLn("Do you want to add another discipline? Y for Yes, N for No: ");
                    moreDiscipline = setMoreDiscipline(Character.toLowerCase(ui.getChar('y','n')));
                } while (moreDiscipline);

                manager.getMembers().add(new Competitor(memberName, dateOfBirth, email, phoneNumber, active, memberNumber, null, disciplines));
            } else {
                manager.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
            }
        }
        manager.getFileHandler().saveFile(manager.getMembers());
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
        File file = new File("MemberNumber");

        int memberNumber = manager.getFileHandler().loadMemberNumber(file);
        manager.getFileHandler().saveMemberNumber(file, memberNumber);
        return memberNumber;
    }

    public Boolean setType(Character c) {
        if (c == 'e') {
            return false;
        }
        return true;
    }

    public ArrayList<Discipline> setDisciplines(int disciplineChoice, ArrayList<Discipline> disciplines){
        //ArrayList<Discipline> disciplines = new ArrayList<>();
            if (disciplineChoice == 1) {
                disciplines.add(Discipline.Crawl);
            } else if (disciplineChoice == 2) {
                disciplines.add(Discipline.Backcrawl);
            } else if (disciplineChoice == 3) {
                disciplines.add(Discipline.Butterfly);
            } else if (disciplineChoice == 4) {
                disciplines.add(Discipline.Breaststroke);
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
