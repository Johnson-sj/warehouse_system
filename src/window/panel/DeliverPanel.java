package window.panel;


import DB.GetDataModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class DeliverPanel extends BasicPanel {
    JPanel message,BasicPanel, EditPanel,ButtonPanel;
    Box VBox;
    public DeliverPanel() {
        message = new JPanel();
        BasicPanel = new JPanel();
        EditPanel = new JPanel();
        ButtonPanel = new JPanel();

        message.setBorder(BorderFactory.createTitledBorder("Existing reservations"));
        BasicPanel.setLayout(new BorderLayout());


        message.setLayout(new BorderLayout());
        TITLES = Arrays.asList("order number", "name","number","status");
        dataModel = GetDataModel.getExistingReservation(null);
        table = getNotEditTable();
        message.add(new JScrollPane(table));


        BasicPanel.add(message);

        VBox = Box.createVerticalBox();
        VBox.add(BoxOrder);
        VBox.add(Box.createVerticalStrut(7));
        VBox.add(BoxExpress);
        VBox.add(Box.createVerticalStrut(7));
        VBox.add(BoxAddress);
        VBox.add(Box.createVerticalStrut(10));


        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(BoxButton,BorderLayout.EAST);

        EditPanel.setLayout(new BorderLayout());
        EditPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.NORTH);
        EditPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
        EditPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        EditPanel.add(VBox,BorderLayout.CENTER);
        EditPanel.add(ButtonPanel,BorderLayout.SOUTH);



        BasicPanel.add(EditPanel,BorderLayout.SOUTH);
        add(BasicPanel);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.SOUTH);

    }
}
