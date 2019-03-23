package window.frame;



import acvitiyListener.MainButtonListener;

import javax.swing.*;
import java.awt.*;


public class AdministratorFrame extends JFrame {

    public JPanel blankPanel;
    public JButton sell = new JButton("sell"),
                    checkOrder = new JButton("check order"),
                    deliver = new JButton("deliver"),
                    refund = new JButton("refund"),
                    create = new JButton("create"),
                    checkQos = new JButton("Check Qos"),
                    accountMag = new JButton("account"),
                    restock = new JButton("restock");
    public Box VboxButton,HBox;
    public JPanel ButtonPanel;
    public AdministratorFrame(){




        setTitle("Administrator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome to our warehouse system");
        welcome.setFont(new Font("宋体",Font.PLAIN,20));
        blankPanel = new JPanel();
        blankPanel.setBorder(BorderFactory.createEtchedBorder());
        blankPanel.setPreferredSize(new Dimension(600,400));
        blankPanel.setLayout(new BorderLayout());
        blankPanel.add(Box.createRigidArea(new Dimension(0,150)),BorderLayout.NORTH);
        blankPanel.add(Box.createRigidArea(new Dimension(0,150)),BorderLayout.SOUTH);
        blankPanel.add(Box.createRigidArea(new Dimension(130,0)),BorderLayout.WEST);
        blankPanel.add(welcome,BorderLayout.CENTER);
//        VboxButton = Box.createVerticalBox();
//
//        VboxButton.add(sell);
//        VboxButton.add(Box.createVerticalStrut(20));
//        VboxButton.add(deliver);
//        VboxButton.add(Box.createVerticalStrut(20));
//        VboxButton.add(checkOrder);
//        VboxButton.add(Box.createVerticalStrut(20));
//        VboxButton.add(refund);
//        VboxButton.add(Box.createVerticalStrut(20));
//        VboxButton.add(create);
//        VboxButton.add(Box.createVerticalStrut(20));
//        VboxButton.add(checkQos);
//        VboxButton.add(Box.createVerticalStrut(20));
//        VboxButton.add(accountMag);

        ButtonPanel = new JPanel();

        ButtonPanel.setLayout(new GridLayout(15,0));
        ButtonPanel.setMaximumSize(new Dimension(30,400));
        ButtonPanel.add(sell);
        ButtonPanel.add(new JPanel());
        ButtonPanel.add(deliver);
        ButtonPanel.add(new JPanel());
        ButtonPanel.add(checkOrder);
        ButtonPanel.add(new JPanel());
        ButtonPanel.add(refund);
        ButtonPanel.add(new JLabel());
        ButtonPanel.add(restock);
        ButtonPanel.add(new JPanel());
        ButtonPanel.add(create);
        ButtonPanel.add(new JPanel());
        ButtonPanel.add(checkQos);
        ButtonPanel.add(new JPanel());
        ButtonPanel.add(accountMag);


        sell.addActionListener(new MainButtonListener(this));
        deliver.addActionListener(new MainButtonListener(this));
        checkOrder.addActionListener(new MainButtonListener(this));
        refund.addActionListener(new MainButtonListener(this));
        restock.addActionListener(new MainButtonListener(this));
        create.addActionListener(new MainButtonListener(this));
        checkQos.addActionListener(new MainButtonListener(this));
        accountMag.addActionListener(new MainButtonListener(this));

        HBox = Box.createHorizontalBox();
//        HBox.add(VboxButton);
        HBox.add(ButtonPanel);
        HBox.add(Box.createHorizontalStrut(20));
        HBox.add(blankPanel);


        add(HBox,BorderLayout.CENTER);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(20,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(20,0)),BorderLayout.WEST);


        setVisible(true);
        setMinimumSize(new Dimension(750,500));
        setResizable(false);
        setLocationRelativeTo(null);
        validate();
    }
}
