package acvitiyListener;

import activity.RefreshActivity;
import window.dialog.AddAccountDialog;
import window.frame.LoginFrame;
import window.panel.BasicPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {

    private JFrame frame = null;
    private BasicPanel basicPanel = null;
    private AddAccountDialog dialog;

    public CancelListener(AddAccountDialog dialog) {
        this.dialog = dialog;
    }

    public CancelListener(JFrame frame) {
        this.frame = frame;
    }

    public CancelListener(BasicPanel basicPanel) {
        this.basicPanel = basicPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame !=null){
            frame.dispose();
            if (frame instanceof LoginFrame)
                System.exit(0);
        }
        if (basicPanel != null){
            new RefreshActivity(basicPanel);
        }
        if (dialog != null){
            dialog.dispose();
        }
    }
}
