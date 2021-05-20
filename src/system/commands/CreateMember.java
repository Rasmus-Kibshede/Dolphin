package system.commands;

import system.CompetitorManager;
import system.MemberManager;
import system.member.Member;
import system.member.competition.Competitor;
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
                memberManager.getMembers().add(new Competitor(memberName, dateOfBirth, email, phoneNumber, active, memberNumber, null));
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
}
