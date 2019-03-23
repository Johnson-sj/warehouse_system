package DB.subActivity;

import DB.GetDataModel;
import window.panel.*;

public class UpdateTable {
    BasicPanel panel;

    public UpdateTable(BasicPanel panel) {
        this.panel = panel;
        if (panel instanceof SellPanel){
            panel.dataModel = GetDataModel.getStockOfSale(panel.inputProductId.getText());
            panel.table.validate();
            panel.table.updateUI();
            return;
        }
        if (panel instanceof DeliverPanel){
            panel.dataModel = GetDataModel.getExistingReservation(panel.inputOrderNumber.getText());
            panel.table.validate();
            panel.table.updateUI();
            return;
        }
        if (panel instanceof CheckOrderPanel){
            panel.dataModel = GetDataModel.getDeliverableOrder(panel.inputOrderNumber.getText(),panel.inputExpressNumber.getText());
            panel.table.validate();
            panel.table.updateUI();
            return;
        }
        if (panel instanceof RefundPanel){
            panel.dataModel = GetDataModel.getDeliverableOrder(panel.inputOrderNumber.getText());
            panel.table.validate();
            panel.table.updateUI();
            return;
        }
        if (panel instanceof RestockPanel){
            panel.dataModel = GetDataModel.getStockOfRestock(panel.inputProductId.getText());
            panel.table.validate();
            panel.table.updateUI();
            return;
        }
    }
}
