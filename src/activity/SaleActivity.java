package activity;

import DB.SqlManagement;
import DB.subActivity.InsertOrderstatus;
import DB.subActivity.UpdateReduceWarehouse;

import window.panel.SellPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SaleActivity {

    public SaleActivity(SellPanel sellPanel)  throws  Exception{

    int id = Integer.parseInt(sellPanel.inputProductId.getText());


//        System.out.println("输入数量");
        int number= Integer.parseInt(sellPanel.inputCount.getText());
        int stocks = Integer.parseInt(sellPanel.dataModel.get(0).get(3));
        if(number> stocks) {

            JOptionPane.showMessageDialog(null,"There's not that much inventory","Error",JOptionPane.ERROR_MESSAGE);
            return;
//            System.out.println("库存没那么多啦");
        }
//            System.out.println("输入订单号");
            int order= Integer.parseInt(sellPanel.inputOrderNumber.getText());
            float price= Float.parseFloat((sellPanel.dataModel.get(0).get(2)));
            String name = sellPanel.dataModel.get(0).get(1);
            float total=price*number;

        Connection conn = SqlManagement.newInstance().getConnection();
        String sql2="insert into sale(id,name,price,number,orderno,totalprice)values('"+id+"','"+name+"','"+price+"','"+number+"','"+order+"','"+total+"')";
            try{
                try (PreparedStatement statement = conn.prepareStatement(sql2)) {
                    statement.executeUpdate();

                }
                new InsertOrderstatus(order,"waiting for deliver");


                new UpdateReduceWarehouse(id,number,number);


                new RefreshActivity(sellPanel);
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

            }



    }

    }



