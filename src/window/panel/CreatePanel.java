package window.panel;


import javax.swing.*;
import java.awt.*;

public class CreatePanel extends BasicPanel {

    JPanel BasicPanel,InputPanel,ButtonPanel;
    Box VBox;

    public CreatePanel() {


        BasicPanel = new JPanel();
        InputPanel = new JPanel();
        ButtonPanel = new JPanel();

        BasicPanel.setLayout(new BorderLayout());
        BasicPanel.setBorder(BorderFactory.createTitledBorder("Create product"));


        VBox = Box.createVerticalBox();
        VBox.add(BoxProduct);
        VBox.add(Box.createVerticalStrut(20));
        VBox.add(BoxName);
        VBox.add(Box.createVerticalStrut(20));
        VBox.add(BoxPrice);


        BasicPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.NORTH);


        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(Box.createRigidArea(new Dimension(0,30)),BorderLayout.NORTH);
        ButtonPanel.add(BoxButton,BorderLayout.EAST);

        InputPanel.setLayout(new BorderLayout());


        InputPanel.add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        InputPanel.add(VBox);
        InputPanel.add(ButtonPanel,BorderLayout.SOUTH);




        BasicPanel.add(InputPanel);


        BasicPanel.add(Box.createRigidArea(new Dimension(0,50)),BorderLayout.NORTH);
        BasicPanel.add(Box.createRigidArea(new Dimension(0,50)),BorderLayout.SOUTH);
        BasicPanel.add(Box.createRigidArea(new Dimension(50,0)),BorderLayout.WEST);
        BasicPanel.add(Box.createRigidArea(new Dimension(50,0)),BorderLayout.EAST);

        add(BasicPanel);


        add(Box.createRigidArea(new Dimension(0,50)),BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0,50)),BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(50,0)),BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(50,0)),BorderLayout.EAST);

    }


}
