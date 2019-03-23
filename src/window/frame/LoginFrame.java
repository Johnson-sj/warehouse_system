package window.frame;

import acvitiyListener.CancelListener;
import acvitiyListener.LoginListener;


import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {


    private JLabel username = new JLabel("username:");
    private JLabel password = new JLabel("password:");
    private JLabel userType = new JLabel("user's type");
    public JTextField inputUsername = new JTextField();
    public JPasswordField inputPassword = new JPasswordField();
    public JComboBox type = new JComboBox();
    private JButton submit = new JButton("submit"),
                cancel = new JButton("cancel");
    private Box HboxUsername,HboxPassword,HBoxUserType,HboxButton,Vbox;

    public LoginFrame(){

        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Vbox = Box.createVerticalBox();

        inputUsername.setMaximumSize(new Dimension(200,20));
        HboxUsername = Box.createHorizontalBox();
        HboxUsername.add(username);
        HboxUsername.add(Box.createHorizontalStrut(20));
        HboxUsername.add(inputUsername);

        Vbox.add(HboxUsername);
        Vbox.add(Box.createVerticalStrut(20));

        inputPassword.setMaximumSize(new Dimension(200,20));
        HboxPassword = Box.createHorizontalBox();
        HboxPassword.add(password);
        HboxPassword.add(Box.createHorizontalStrut(20));
        HboxPassword.add(inputPassword);

        Vbox.add(HboxPassword);
        Vbox.add(Box.createVerticalStrut(20));

        type.addItem("user");
        type.addItem("administrator");

        type.setMaximumSize(new Dimension(200,20));
        HBoxUserType = Box.createHorizontalBox();
        HBoxUserType.add(userType);
        HBoxUserType.add(Box.createHorizontalStrut(20));
        HBoxUserType.add(type);

        Vbox.add(HBoxUserType);
        Vbox.add(Box.createVerticalStrut(20));

        HboxButton = Box.createHorizontalBox();
        HboxButton.add(submit);
        HboxButton.add(Box.createHorizontalStrut(50));
        HboxButton.add(cancel);

        Vbox.add(HboxButton);

        //panel.add(Vbox,BorderLayout.CENTER);
        add(Box.createRigidArea(new Dimension(0,40)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,40)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(30,100)),BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(30,100)),BorderLayout.EAST);
        add(Vbox,BorderLayout.CENTER);


        cancel.addActionListener(new CancelListener(this));
        submit.addActionListener(new LoginListener(this));



        setVisible(true);
        setResizable(false);
        setSize(400,300);
        setLocationRelativeTo(null);
    }



}
