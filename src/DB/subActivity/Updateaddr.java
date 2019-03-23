package DB.subActivity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updateaddr {
    private final int express;
    private final String addr;

    public Updateaddr(int express, String addr){
        this.express=express;
        this.addr=addr;
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql="insert into address(express,addr)values('"+express+"','"+addr+"')";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

