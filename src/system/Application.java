package system;

import system.commands.Command;
import system.member.Member;
import system.member.Payment;
import system.commands.menus.MainMenu;
import system.ui.UI;

import java.time.LocalDate;

public class Application {
    private MemberManager memberManager = new MemberManager();
    private MainMenu mainMenu = new MainMenu();
    private UI ui;
    //private Command command;

    public Application(MemberManager memberManager, UI ui){
       this.memberManager = memberManager;
       this.ui = ui;

    }


    public void start() {
        mainMenu.startMenu();

        /*
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

         */
    }

    public String logIn() {
        //Checks the logIn file for a match
        return "";
    }
}
