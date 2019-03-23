package DB;
import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.sql.Statement;

//采用单例设计模式
public class SqlManagement {
    private Connection connection;
    private Statement statement;
    //获得statement
    public Statement getStatement() {
        return statement;
    }
    //赋值statement
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    //获得Connection
    public Connection getConnection() {
        return connection;
    }
    //赋值Connection
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    private static SqlManagement manager;
    private SqlManagement() {
        //连接数据库的驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //指向数据库访问地址
        String url = "jdbc:mysql://localhost:3306/warehouse" +
                "?serverTimezone=GMT%2B8";
        //数据库的用户名
        String user = "root";
        //数据库用户密码
        String password = "1C9h9e6n@@";

        try {
            //加载驱动
            Class.forName(driver);
            //与数据库建立连接
            connection = DriverManager.getConnection(url,user, password);
            if(!connection.isClosed()){
                //创建数据库操作类
                statement = connection.createStatement();
            }else{
                System.out.println("请打开数据库！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建该类的对象
     * @return 返回SQLManager对象。
     */
    public static synchronized SqlManagement newInstance(){
        if(manager==null){
            manager = new SqlManagement();
        }
        return manager;
    }
}
