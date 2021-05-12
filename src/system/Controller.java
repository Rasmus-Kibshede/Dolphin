package system;

import system.member.Member;
import system.member.Payment;

import java.time.LocalDate;

public class Controller {
    public void run() {
        //AdminMenu adminMenu = new AdminMenu(logIn());

        //Creates a menu that can display choices
        //String[] menuChoices = {};
        //Menu menu = new Menu("Menu", "Choose", menuChoices);

        //adminMenu.startMenu();
        Payment payment = new Payment();
        LocalDate birth = LocalDate.parse("1997-06-18");
        Member member = new Member("Michala",
                birth,
                "michalanim2gmail.com",
                "50932812",
                true,
                payment.getPrice(birth, true));
        System.out.println(member.getMembershipPrice());
    }

    public String logIn() {
        //Checks the logIn file for a match
        return "";
    }
}
