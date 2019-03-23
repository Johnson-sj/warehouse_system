package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOrderstatus {
    //private final String addr;
    private final int orderno;
    private final String state;

    public UpdateOrderstatus(int orderno, String state){
        this.orderno=orderno;
        this.state=state;
        Connection conn = SqlManagement.newInstance().getConnection();

        String sql = "update orderstatus set state = '"+state+"' where orderno = '"+orderno+"';";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

