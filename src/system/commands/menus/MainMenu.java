package system.commands.menus;

public class MainMenu extends MenuCommand {

    private String logInType;

    public MainMenu(String logInType) {
        this.logInType = logInType;
    }

    public void startMenu(){
        switch (logInType){
            case "chairman":
                //call chairman menu
                break;
            case "cashier":
                //call cashier menu
                break;
            case "coach":
                //call coach menu
                break;
        }
    }

}
