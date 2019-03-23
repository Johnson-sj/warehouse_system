package activity;

import DB.SqlManagement;
import DB.subActivity.InsertWarehouse;
import window.panel.CreatePanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProduceActivity {
    public CreateProduceActivity(CreatePanel createPanel){
        int id = Integer.parseInt(createPanel.inputProductId.getText());
        String name = createPanel.inputName.getText();
        float price = Float.parseFloat(createPanel.inputPrice.getText());
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql1 = "insert into produce(id,name,price) values('"+id+"','"+name+"','"+price+"')";
        try {
            PreparedStatement statement = conn.prepareStatement(sql1);
            int set = statement.executeUpdate();
            new RefreshActivity(createPanel);
            new InsertWarehouse(id);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }

}

