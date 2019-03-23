package window.dialog;

import acvitiyListener.CancelListener;
import acvitiyListener.SubmitListener;
import window.panel.BasicPanel;

import javax.swing.*;
import java.awt.*;

public class AddAccountDialog extends JDialog {
    public JTextField inputAccount = new JTextField(),
                        inputPassword = new JTextField();
    private JLabel account = new JLabel("Account:"),
                    password = new JLabel("Password");
    private JButton submit = new JButton("submit"),
                    cancel = new JButton("cancel");

    private Box BoxAccount,BoxPassword,BoxButton,VBox;




    public AddAccountDialog() {
        super((Dialog) null,"Add Account",true);

        BoxAccount = Box.createHorizontalBox();
        BoxAccount.add(account);
        BoxAccount.add(Box.createHorizontalStrut(20));
        BoxAccount.add(inputAccount);

        BoxPassword = Box.createHorizontalBox();
        BoxPassword.add(password);
        BoxPassword.add(Box.createHorizontalStrut(20));
        BoxPassword.add(inputPassword);

        BoxButton = Box.createHorizontalBox();
        BoxButton.add(submit);
        BoxButton.add(Box.createHorizontalStrut(30));
        BoxButton.add(cancel);

        VBox = Box.createVerticalBox();
        VBox.add(BoxAccount);
        VBox.add(Box.createVerticalStrut(10));
        VBox.add(BoxPassword);
        VBox.add(Box.createVerticalStrut(10));
        VBox.add(BoxButton);


        add(VBox);


        add(Box.createRigidArea(new Dimension(0,40)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,40)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(80,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(80,0)),BorderLayout.WEST);


        submit.addActionListener(new SubmitListener(this));
        cancel.addActionListener(new CancelListener(this));

        setResizable(false);
        setSize(500, 205);
        setLocationRelativeTo(null);
        setVisible(true);



        validate();

    }
}
