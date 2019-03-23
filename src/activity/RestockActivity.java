package activity;

import DB.SqlManagement;
import DB.subActivity.UpdateAddWarehouse;
import window.panel.RestockPanel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RestockActivity {
    public RestockActivity(RestockPanel restockPanel){
        int id= Integer.parseInt(restockPanel.inputProductId.getText());
        int number= Integer.parseInt(restockPanel.inputCount.getText());
        String name = restockPanel.dataModel.get(0).get(1);
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql1 = "insert into restock(id,name,quantity) values('"+id+"','"+name+"','"+number+"')";
        try {
            PreparedStatement statement = conn.prepareStatement(sql1);
            int set = statement.executeUpdate();


            new UpdateAddWarehouse(id,number,0);
            new RefreshActivity(restockPanel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

}
    }
