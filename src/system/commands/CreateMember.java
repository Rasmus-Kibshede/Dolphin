package system.commands;

import system.CompetitorManager;
import system.MemberManager;
import system.member.Member;
import system.member.competition.Competitor;
import system.member.competition.Discipline;
import system.ui.UI;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

//Kamille
public class CreateMember implements Command {
    private MemberManager memberManager;
    private CompetitorManager competitorManager;

    public CreateMember(MemberManager memberManager, CompetitorManager competitorManager) {
        this.memberManager = memberManager;
        this.competitorManager = competitorManager;
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
                ArrayList<Discipline> disciplines;
                boolean moreDiscipline;
                do{
                    //Show a list of disciplines
                    ui.displayLn("Enter the number of the discipline you want to add: ");
                    int disciplineChoice = ui.getInt("Not a valid number");
                    disciplines = setDisciplines(disciplineChoice);

                    ui.displayLn("Do you want to add another discipline? Y for Yes, N fro No: ");
                    moreDiscipline = setMoreDiscipline(Character.toLowerCase(ui.getChar('y','n')));
                } while (moreDiscipline);

                memberManager.getMembers().add(new Competitor(memberName, dateOfBirth, email, phoneNumber, active, memberNumber, null, disciplines));
            } else {
                memberManager.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
            }
        }
        memberManager.getFileHandler().saveFile(memberManager.getMembers());
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

        int memberNumber = memberManager.getFileHandler().loadMemberNumber(file);
        memberManager.getFileHandler().saveMemberNumber(file, memberNumber);
        return memberNumber;
    }

    public Boolean setType(Character c) {
        if (c == 'e') {
            return false;
        }
        return true;
    }

    public ArrayList<Discipline> setDisciplines(int disciplineChoice){
        ArrayList<Discipline> disciplines = new ArrayList<>();
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
