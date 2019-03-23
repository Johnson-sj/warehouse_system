package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDeliver {
    private final int orderno;
    private final int express;

    public UpdateDeliver(int orderno, int express){
        this.orderno=orderno;
        this.express=express;
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql="insert into deliver(orderno,expressno)values('"+orderno+"','"+express+"')";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
