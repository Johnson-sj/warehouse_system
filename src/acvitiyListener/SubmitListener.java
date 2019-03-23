package acvitiyListener;

import DB.subActivity.InsertAccount;
import activity.*;
import window.dialog.AddAccountDialog;
import window.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SubmitListener implements ActionListener {

    BasicPanel panel;
    AddAccountDialog dialog;



    int productId,orderNumber,expressNumber,count;
    String name,address,account,password;
    float price;

    public SubmitListener(AddAccountDialog dialog) {
        this.dialog = dialog;
    }

    public SubmitListener(BasicPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panel != null){
            if (panel instanceof SellPanel || panel instanceof CreatePanel || panel instanceof RestockPanel){
                try{
                    productId = Integer.parseInt(panel.inputProductId.getText());
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Product id must be number and Not Empty","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (panel instanceof SellPanel || panel instanceof RestockPanel){
                try{
                    count = Integer.parseInt(panel.inputCount.getText());
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Count must be number Not Empty","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (panel instanceof SellPanel || panel instanceof DeliverPanel || panel instanceof RefundPanel){
                try{
                    orderNumber = Integer.parseInt(panel.inputOrderNumber.getText());
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"The order number must be number Not Empty","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (panel instanceof DeliverPanel){
                try{
                    expressNumber = Integer.parseInt(panel.inputExpressNumber.getText());
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Express number must be number Not Empty","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (panel instanceof CreatePanel){
                try{
                    price = Float.parseFloat(panel.inputPrice.getText());
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Price must be number Not Empty","Error",JOptionPane.ERROR_MESSAGE);
//                verify = false;
                    return;
                }
            }
            if (panel instanceof CreatePanel){
                name = panel.inputName.getText();
                if (name.equals("")){
                    JOptionPane.showMessageDialog(null,"Product name not Empty","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (panel instanceof DeliverPanel){
                address = panel.inputAddress.getText();
                if (address.equals("")){
                    JOptionPane.showMessageDialog(null,"Address not Empty","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (panel instanceof SellPanel){
                try {
                    new SaleActivity((SellPanel) panel);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            if (panel instanceof RestockPanel){
                new RestockActivity((RestockPanel)panel);
            }
            if (panel instanceof DeliverPanel){
                new DeliverActivity((DeliverPanel)panel);
            }
            if (panel instanceof RefundPanel){
                new RefundActivity((RefundPanel)panel);
            }
            if (panel instanceof CreatePanel){
                new CreateProduceActivity((CreatePanel)panel);
            }




        }

        if (dialog != null){

           account = dialog.inputAccount.getText();
           password = dialog.inputPassword.getText();
           if (account.equals("") && password.equals("")){
               JOptionPane.showMessageDialog(null,"Account or Password not Empty","Error",JOptionPane.ERROR_MESSAGE);
               return;
           }

            try {
                new InsertAccount(account,password,0);
                dialog.dispose();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
