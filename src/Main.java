import window.frame.AdministratorFrame;
import window.frame.LoginFrame;
import DB.*;

public class Main {
    public static SqlManagement sqlManagement;
    public static void main(String[] args) {
        sqlManagement = SqlManagement.newInstance();
        LoginFrame loginWindow = new LoginFrame();
//        AdministratorFrame administratorFrame = new AdministratorFrame();
//        UserFrame userFrame = new UserFrame();
//        TextFrame textFrame = new TextFrame();
    }
}
