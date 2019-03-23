package acvitiyListener;

import DB.SqlManagement;
import window.dialog.AddAccountDialog;
import window.panel.AccountMagPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountMagListener implements ActionListener {

    private AccountMagPanel accountMagPanel;
    private static Connection conn = SqlManagement.newInstance().getConnection();


    public AccountMagListener(AccountMagPanel accountMagPanel) {
        this.accountMagPanel = accountMagPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accountMagPanel.addAccount){
            new AddAccountDialog();
        }
        if (e.getSource() == accountMagPanel.alterAccount){
            try {
                accountMagPanel.table.getCellEditor().stopCellEditing();
            }catch (Exception e1){

            }
            int row = accountMagPanel.table.getSelectedRow();
            if (row == -1) return;;
            String val = accountMagPanel.dataModel.get(row).get(1);
            String account = accountMagPanel.dataModel.get(row).get(0);
            String sql = "update users set pwd = '"+val+"' where account = '" + account + "';";
            Statement  stmt;
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == accountMagPanel.deleteAccount){
            int row = accountMagPanel.table.getSelectedRow();
            if (row == -1) return;
            String account = accountMagPanel.dataModel.get(row).get(0);
            String sql = "delete from users where account = '" + account + "';";
            Statement stmt;
            try {
                stmt = conn.createStatement();
                if (stmt.executeUpdate(sql) == 0) return;
                accountMagPanel.dataModel.remove(row);

                //更新表格
                accountMagPanel.table.validate();
                accountMagPanel.table.updateUI();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
