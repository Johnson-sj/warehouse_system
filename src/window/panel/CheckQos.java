package window.panel;


import DB.GetDataModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CheckQos extends BasicPanel {

    JPanel message;

    public CheckQos() {

        message = new JPanel();


        message.setBorder(BorderFactory.createTitledBorder("Sale statistics"));

        message.setLayout(new BorderLayout());
        TITLES = Arrays.asList("id", "name","qos");
        dataModel = GetDataModel.getSaleStatistics();
        table = getNotEditTable();
        message.add(new JScrollPane(table));


        add(message, BorderLayout.CENTER);


        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
    }
}
