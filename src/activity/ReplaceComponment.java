package activity;

import window.frame.AdministratorFrame;
import window.frame.UserFrame;

import javax.swing.*;
import java.awt.*;

public class ReplaceComponment {

    public static void replace(AdministratorFrame frame, JPanel panel){


        frame.HBox.removeAll();
        frame.HBox.add(frame.ButtonPanel);
        frame.HBox.add(Box.createHorizontalStrut(20));
        frame.HBox.add(panel);

        frame.add(frame.HBox, BorderLayout.CENTER);
        frame.add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
        frame.add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.SOUTH);
        frame.add(Box.createRigidArea(new Dimension(20,0)),BorderLayout.EAST);
        frame.add(Box.createRigidArea(new Dimension(20,0)),BorderLayout.WEST);

        if (frame instanceof UserFrame){
            frame.ButtonPanel.remove(frame.create);
            frame.ButtonPanel.remove(frame.accountMag);
            frame.ButtonPanel.remove(frame.checkQos);
        }
        frame.validate();
    }

}
