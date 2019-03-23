package window.panel;


import DB.GetDataModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RefundPanel extends BasicPanel {

    JPanel message,BasicPanel, EditPanel,ButtonPanel;

    public RefundPanel() {
        message = new JPanel();
        BasicPanel = new JPanel();
        EditPanel = new JPanel();
        ButtonPanel = new JPanel();
        message.setBorder(BorderFactory.createTitledBorder("Deliverable order"));

        message.setLayout(new BorderLayout());
        TITLES = Arrays.asList("order number","id","name","number");
        dataModel = GetDataModel.getDeliverableOrder(null);
        table = getNotEditTable();
        message.add(new JScrollPane(table));


        BasicPanel.setLayout(new BorderLayout());
        BasicPanel.add(message);


        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(BoxButton,BorderLayout.EAST);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.NORTH);



        EditPanel.setLayout(new BorderLayout());
        EditPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.NORTH);
        EditPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
        EditPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        EditPanel.add(BoxOrder,BorderLayout.CENTER);
        EditPanel.add(ButtonPanel,BorderLayout.SOUTH);



        BasicPanel.add(EditPanel,BorderLayout.SOUTH);
        add(BasicPanel);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.SOUTH);
    }
}
