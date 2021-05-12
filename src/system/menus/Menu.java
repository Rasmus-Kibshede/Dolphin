package system.menus;

public class Menu {
  private final String menuHeader;
  private final String menuLeadText;
  private final String[] menuItems;

  public Menu(String menuHeader, String menuLeadText, String[] menuItems) {
    this.menuHeader = menuHeader;
    this.menuLeadText = menuLeadText;
    this.menuItems = menuItems;
  }


  public String toString() {

    StringBuilder menuString = new StringBuilder();

    menuString.append(menuHeader).append("\n");

    for (int i = 0; i < menuItems.length; i++) {
      int menuItemNumber = (i) + 1;
      String item = menuItems[i];
      menuString.append(menuItemNumber).append(". ").append(item).append("\n");
    }
    menuString.append(menuLeadText);

    return menuString.toString();
  }


  public int readChoice() {


    return 1;
  }


}
