package activity;

import DB.subActivity.UpdateAddWarehouse;
import DB.subActivity.UpdateOrderstatus;

import window.panel.RefundPanel;

public class RefundActivity {
    public RefundActivity(RefundPanel refundPanel){

        int order= Integer.parseInt(refundPanel.inputOrderNumber.getText());

      /*  Connection conn = SqlManagement.newInstance().getConnection();
        String sql="delete from sale where orderno='"+order+"'";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
      new UpdateOrderstatus(order,"withdraw");
      int number = Integer.parseInt(refundPanel.dataModel.get(0).get(3));
      int id = Integer.parseInt(refundPanel.dataModel.get(0).get(1));

      new UpdateAddWarehouse(id,number,number);
      new RefreshActivity(refundPanel);
    }
}
