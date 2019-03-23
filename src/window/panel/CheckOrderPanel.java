package window.panel;


import DB.GetDataModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CheckOrderPanel extends BasicPanel {


    JPanel message, BasicPanel, EditPanel,ButtonPanel;
    Box VBox;

    public CheckOrderPanel() {


        message = new JPanel();
        BasicPanel = new JPanel();
        EditPanel = new JPanel();
        ButtonPanel = new JPanel();
        EditPanel.setLayout(new BorderLayout());

        VBox = Box.createVerticalBox();
        VBox.add(Box.createVerticalStrut(10));
        VBox.add(BoxOrder);
        VBox.add(Box.createVerticalStrut(7));
        VBox.add(BoxExpress);
        VBox.add(Box.createVerticalStrut(10));

        EditPanel.add(VBox,BorderLayout.CENTER);

        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(BoxButton,BorderLayout.EAST);

        EditPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
        EditPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);

        BasicPanel.setLayout(new BorderLayout());
        message.setBorder(BorderFactory.createTitledBorder("Deliverable order"));


        message.setLayout(new BorderLayout());
        TITLES = Arrays.asList("order number", "express number","address","status");
        dataModel = GetDataModel.getDeliverableOrder(null,null);
        table = getNotEditTable();
        message.add(new JScrollPane(table));

        BasicPanel.add(EditPanel,BorderLayout.SOUTH);
        BasicPanel.add(message);

//        EditPanel.add(ButtonPanel,BorderLayout.SOUTH);

        add(BasicPanel,BorderLayout.CENTER);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);

    }
}
