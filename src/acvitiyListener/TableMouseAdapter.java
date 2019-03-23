package acvitiyListener;

import window.panel.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableMouseAdapter extends MouseAdapter {
    BasicPanel panel;

    public TableMouseAdapter(BasicPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (panel instanceof AccountMagPanel) return;
        if (e.getClickCount() ==2){
            int row =((JTable)e.getSource()).rowAtPoint(e.getPoint());
            int column = panel.table.getColumnCount();
//                System.out.println(panel.TITLES.get(i)+" "+panel.dataModel.get(row).get(i));
                if (panel instanceof RestockPanel || panel instanceof SellPanel){
                    panel.inputProductId.setText(panel.dataModel.get(row).get(0));
                }
                if (panel instanceof DeliverPanel || panel instanceof RefundPanel){
                    panel.inputOrderNumber.setText(panel.dataModel.get(row).get(0));
                }

        }
    }
}
