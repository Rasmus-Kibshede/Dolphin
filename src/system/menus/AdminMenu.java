package system.menus;

public class AdminMenu {

    private String logInType;

    public AdminMenu(String logInType) {
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
