package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertWarehouse {
    public static  int Qos;
    public final int id;
    public  int stocks;

    public InsertWarehouse(int id){
        this.id=id;
        this.stocks=stocks;
        this.Qos=Qos;
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql1="insert into warehouse(id,stocks,Qos) values('"+id+"',0,0);";
        try{
            try (PreparedStatement statement = conn.prepareStatement(sql1)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
