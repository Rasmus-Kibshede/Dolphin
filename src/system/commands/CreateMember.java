package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.time.LocalDate;

public class CreateMember implements Command {
    private String name;
    private MemberManager memberManager;

    public CreateMember(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn("Enter member name: ");
        String memberName = ui.getString();
        ui.displayLn("Enter members date of birth: ");
        LocalDate dateOfBirth = ui.getDate();
        ui.displayLn("Enter members email: ");
        String email = ui.getString();
        ui.displayLn("Enter members phone number: ");
        String phoneNumber = ui.getString();

        memberManager.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, membershipPrice));
    }

    @Override
    public String getName() {
        return null;
    }
}
