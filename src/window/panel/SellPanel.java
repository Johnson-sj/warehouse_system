package window.panel;


import DB.GetDataModel;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SellPanel extends BasicPanel {

    JPanel NorthPanel,SouthPanel,ButtonPanel,message;
    Box Vbox;

    public SellPanel() {

        NorthPanel = new JPanel();
//        NorthPanel.setBorder(BorderFactory.createEtchedBorder());
        NorthPanel.setLayout(new BorderLayout());
        NorthPanel.setPreferredSize(new Dimension(400,40));
        NorthPanel.add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        NorthPanel.add(Box.createRigidArea(new Dimension(60,0)),BorderLayout.WEST);
        NorthPanel.add(Box.createRigidArea(new Dimension(60,0)),BorderLayout.EAST);
        NorthPanel.add(BoxProduct,BorderLayout.CENTER);
        add(NorthPanel, BorderLayout.NORTH);

        SouthPanel = new JPanel();
//        SouthPanel.setBorder(BorderFactory.createEtchedBorder());
        SouthPanel.setPreferredSize(new Dimension(400,110));
        SouthPanel.setLayout(new BorderLayout());


        Vbox = Box.createVerticalBox();
        Vbox.add(BoxCount);
        Vbox.add(Box.createVerticalStrut(10));
        Vbox.add(BoxOrder);
        Vbox.add(Box.createVerticalStrut(15));
        SouthPanel.add(Vbox);

        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(Box.createRigidArea(new Dimension(382,0)),BorderLayout.WEST);
        ButtonPanel.add(BoxButton,BorderLayout.CENTER);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.SOUTH);

        SouthPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.NORTH);
        SouthPanel.add(Box.createRigidArea(new Dimension(60,0)),BorderLayout.WEST);
        SouthPanel.add(Box.createRigidArea(new Dimension(60,0)),BorderLayout.EAST);
        SouthPanel.add(ButtonPanel,BorderLayout.SOUTH);


        message = new JPanel();
        message.setBorder(BorderFactory.createTitledBorder("Stock"));
        message.setLayout(new BorderLayout());


        TITLES = Arrays.asList("id","name","price","stocks");
        dataModel = GetDataModel.getStockOfSale(null);
        table = getNotEditTable();
        message.add(new JScrollPane(table));


        add(message);
        add(SouthPanel,BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        validate();

    }
}
