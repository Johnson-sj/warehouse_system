package DB;

import window.panel.BasicPanel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class GetDataModel {
    private static Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private static Connection conn = SqlManagement.newInstance().getConnection();
    private static String sql = null;
    private static int orderNo,expressNo,id;

    public static Vector<Vector<String>> getAccountDetail(){
        dataModel.clear();
        sql = "SELECT account,pwd FROM users;";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 2; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return dataModel;
    }
    public static Vector<Vector<String>> getDeliverableOrder(String order,String express){

        dataModel.clear();
        sql = "select deliver.orderno,deliver.expressno,addr,orderstatus.state "+
                "from deliver,orderstatus,address where " ;
        if (order == null || order.equals("")){
        }else {
            orderNo = Integer.parseInt(order);
            sql += "deliver.orderno like '"+orderNo+"%' and ";
        }
        if(express == null || express.equals("")){
        }else {
            expressNo = Integer.parseInt(express);
            sql += "deliver.expressno like '"+expressNo+"%' and ";
        }
            sql += "address.express=deliver.expressno and deliver.orderno=orderstatus.orderno;";
//        System.out.println(sql);


        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 4; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }







        return dataModel;
    }
    public static Vector<Vector<String>> getDeliverableOrder(String order){
        dataModel.clear();
        sql = "select sale.orderno,id,name,number,state from sale ,orderstatus  where sale.orderno=orderstatus.orderno  and state!='withdraw'";
        if (order == null || order.equals("")){
        }else {
            orderNo = Integer.parseInt(order);

            sql += " and sale.orderno like '"+orderNo+"%' ";
        }
        //sql += "and sale.orderno not in(select orderno from orderstatus where state ='withdraw' );";
//        System.out.println(sql);


        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 4; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return dataModel;
    }
    public static Vector<Vector<String>> getExistingReservation(String order){
        dataModel.clear();

        sql = " select sale.orderno,produce.name,sale.number,orderstatus.state "+
                "from produce,sale,orderstatus where ";

        if (order == null || order.equals("")){
        }else {
            orderNo = Integer.parseInt(order);
            sql += "sale.orderno like '"+orderNo+"%' and ";
        }

        sql += "sale.orderno=orderstatus.orderno and produce.id = sale.id and orderstatus.state = 'waiting for deliver'";
//                + " and sale.orderno not like (SELECT orderno FROM deliver);";

//        System.out.println(sql);

        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 4; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        return dataModel;
    }
    public static Vector<Vector<String>> getStockOfSale(String ID){
        dataModel.clear();
        sql = "select produce.id,name,price,stocks from produce,warehouse where ";
        if (ID == null || ID.equals("")){
        }else {
            id = Integer.parseInt(ID);
            sql += "produce.id like '"+id+"%'and ";
        }
        sql += "produce.id=warehouse.id;";
//        System.out.println(sql);


        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 4; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        return dataModel;
    }


    public static Vector<Vector<String>> getStockOfRestock(String ID){
        dataModel.clear();

        sql = "select produce.id,produce.name,warehouse.stocks,warehouse.Qos from produce,warehouse where produce.id=warehouse.id ";
        if (ID == null || ID.equals("")){
        }else {
            id = Integer.parseInt(ID);
            sql += "and produce.id like '"+id+"%' ";
        }
        sql += ";";
//        System.out.println(sql);


        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 4; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        return dataModel;
    }

    public static Vector<Vector<String>> getSaleStatistics(){
        dataModel.clear();

        sql = "select produce.id,produce.name,Qos from produce,warehouse where produce.id=warehouse.id ;";

//        System.out.println(sql);

        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vector<String> record;
            while (rs.next()) {
                record = new Vector<String>();
                for (int i = 0; i < 3; i++) {
                    record.add(rs.getString(i + 1));
                }
                dataModel.add(record);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return dataModel;
    }
}
