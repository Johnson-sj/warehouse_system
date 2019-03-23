package window.panel;


import DB.GetDataModel;
import acvitiyListener.AccountMagListener;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AccountMagPanel extends BasicPanel {

    JPanel message, BasicPanel,ButtonPanel;

    public JButton addAccount = new JButton("addition"),
            alterAccount = new JButton("alter"),
            deleteAccount  = new JButton("delete");

    public AccountMagPanel() {
        message = new JPanel();
        BasicPanel = new JPanel();
        ButtonPanel = new JPanel();
        BasicPanel.setLayout(new BorderLayout());
        message.setBorder(BorderFactory.createTitledBorder("Account details"));
        message.setLayout(new BorderLayout());

        TITLES = Arrays.asList("account","password");
        dataModel = GetDataModel.getAccountDetail();
        table = getAccountTable();
        message.add(new JScrollPane(table));


        BasicPanel.add(message);
        addAccount.setPreferredSize(new Dimension(80,25));
        alterAccount.setPreferredSize(new Dimension(80,25));
        deleteAccount.setPreferredSize(new Dimension(80,25));

        ButtonPanel.add(addAccount);
        ButtonPanel.add(alterAccount);
        ButtonPanel.add(deleteAccount);
        BasicPanel.add(ButtonPanel,BorderLayout.SOUTH);
        add(BasicPanel,BorderLayout.CENTER);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);

        addAccount.addActionListener(new AccountMagListener(this));
        alterAccount.addActionListener(new AccountMagListener(this));
        deleteAccount.addActionListener(new AccountMagListener(this));
    }
}
