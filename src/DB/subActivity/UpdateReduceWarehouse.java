package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateReduceWarehouse {
    public static  int Qos;
        public final int id;
        public  int stocks;

    public UpdateReduceWarehouse(int id, int stocks, int Qos){
            this.id=id;
            this.stocks=stocks;
            this.Qos=Qos;
            Connection conn = SqlManagement.newInstance().getConnection();
            String sql1="update warehouse set stocks= warehouse.stocks - '"+stocks+"' ,Qos= warehouse.Qos + '"+Qos+"' where id='"+id+"' ";
            try{
                try (PreparedStatement statement = conn.prepareStatement(sql1)) {
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
}
}
