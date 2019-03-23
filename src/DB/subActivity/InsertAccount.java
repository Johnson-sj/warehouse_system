package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAccount {


    public InsertAccount(String account,String password,int type) throws SQLException{

        Connection conn = SqlManagement.newInstance().getConnection();
        String sql1=" insert into users values ('"+account+"','"+password+"','"+type+"');";
        try{
            try (PreparedStatement statement = conn.prepareStatement(sql1)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;

        }
    }
}
