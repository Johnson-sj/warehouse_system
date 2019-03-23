package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOrderstatus {
    private final int orderno;
    private final String state;
    public InsertOrderstatus(int orderno, String state) {
        this.orderno=orderno;
        this.state=state;
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql="insert into orderstatus(orderno,state)values('"+orderno+"','"+state+"')";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
