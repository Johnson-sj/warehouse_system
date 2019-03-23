package acvitiyListener;

import activity.ReplaceComponment;
import window.frame.AdministratorFrame;
import window.panel.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainButtonListener implements ActionListener {

    private AdministratorFrame frame ;

    public MainButtonListener(AdministratorFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.sell){
            ReplaceComponment.replace(frame,new SellPanel());
        }
        if (e.getSource() == frame.deliver){
            ReplaceComponment.replace(frame,new DeliverPanel());
        }
        if (e.getSource() == frame.checkOrder){
            ReplaceComponment.replace(frame,new CheckOrderPanel());
        }
        if (e.getSource() == frame.refund){
            ReplaceComponment.replace(frame,new RefundPanel());
        }
        if (frame instanceof AdministratorFrame){
            if (e.getSource() == frame.restock){
                ReplaceComponment.replace(frame,new RestockPanel());
            }
            if (e.getSource() == frame.create){
                ReplaceComponment.replace(frame,new CreatePanel());
            }
            if (e.getSource() == frame.checkQos){
                ReplaceComponment.replace(frame,new CheckQos());
            }
            if (e.getSource() == frame.accountMag){
                ReplaceComponment.replace(frame,new AccountMagPanel());
            }
        }
    }
}
