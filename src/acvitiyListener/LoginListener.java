package acvitiyListener;

import activity.LoginActivity;
import window.frame.AdministratorFrame;
import window.frame.LoginFrame;
import window.frame.UserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private LoginFrame loginWindow;
    private String username,password;
    int type;

    private boolean verify;

    public LoginListener(LoginFrame loginWindow) {
        this.loginWindow = loginWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = loginWindow.inputUsername.getText();
        password = String.valueOf(loginWindow.inputPassword.getPassword());
        type = loginWindow.type.getSelectedIndex();
//        System.out.println("username:"+username+"\npassword:"+password+"\ntype:"+type);
        LoginActivity login = new LoginActivity(username,password,type);
        verify = login.getVerify();
        if (username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null, " username or password not empty ", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            if (verify){
                if (type == 0){
                    new UserFrame();
                }else {
                    new AdministratorFrame();
                }
                loginWindow.dispose();
            }else {
                JOptionPane.showMessageDialog(null, " login failed ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
