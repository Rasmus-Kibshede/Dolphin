package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

//Kamille
public class CreateMember implements Command {
    private MemberManager memberManager;

    public CreateMember(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn("Enter member name: ");
        String memberName = ui.getString();
        ui.displayLn("Enter members date of birth: day-month-year");
        LocalDate dateOfBirth = ui.getDate();
        ui.displayLn("Enter members email: ");
        String email = ui.getString();
        ui.displayLn("Enter members phone number: ");
        String phoneNumber = ui.getString();
        ui.displayLn("Enter A for active and P for passive");
        boolean active = setActive(Character.toLowerCase(ui.getChar('a','p')));
        int memberNumber = setMemberNumber();

        memberManager.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
        memberManager.getFileHandler().saveFile(memberManager.getMembers(), memberManager.getMEMBER_FILE());
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
        /*
        int lastMember = memberManager.getMembers().size();
        if (lastMember == 0) {
            return 1;
        }
        int memberNumber = memberManager.getMembers().get(lastMember - 1).getMemberNumber();

         */

        File file = new File("MemberNumber");

        int memberNumber = memberManager.getFileHandler().loadMemberNumber(file);
        memberManager.getFileHandler().saveMemberNumber(file, memberNumber);
        return memberNumber;
    }
}
