package window.frame;

public class UserFrame extends AdministratorFrame {
    public UserFrame() {
        super();
        ButtonPanel.remove(create);
        ButtonPanel.remove(accountMag);
        ButtonPanel.remove(checkQos);
        ButtonPanel.remove(restock);
    }
}
