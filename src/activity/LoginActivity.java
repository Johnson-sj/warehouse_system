package activity;

import DB.SqlManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginActivity {
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        new Login();
//    }


    private boolean verify = false;


    /**
     * Create the frame.
     */
    public LoginActivity(String account, String pwd, int type) {
//        System.out.println("请输入账号：");
//        Scanner sc = new Scanner(System.in);
//        String account = sc.next();
//        System.out.println("请输入密码：");
//        String pwd = sc.next();
//        System.out.println("请输入用户类型：");
//        int type=sc.nextInt();
        Connection conn = SqlManagement.newInstance().getConnection();
        String sql = "select * from users where account= ? and pwd=? and type=? ";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, account);
            statement.setString(2, pwd);
            statement.setInt(3,type);

            ResultSet set = statement.executeQuery();
           //set.last();//移动到最后一行。
            set.next();
            int num = set.getRow();
            if (num >0) {
//                System.out.println(num);
                verify = true;

            } else {
//                System.out.println(num);
                verify = false;

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public boolean getVerify(){
        return verify;
    }

}