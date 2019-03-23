package activity;

import DB.subActivity.UpdateTable;
import window.panel.BasicPanel;
import window.panel.CreatePanel;

public class RefreshActivity {
    private BasicPanel basicPanel;

    public RefreshActivity(BasicPanel basicPanel) {
        this.basicPanel = basicPanel;
        basicPanel.inputProductId.setText("");
        basicPanel.inputAddress.setText("");
        basicPanel.inputExpressNumber.setText("");
        basicPanel.inputCount.setText("");
        basicPanel.inputOrderNumber.setText("");
        basicPanel.inputName.setText("");
        basicPanel.inputPrice.setText("");

        new UpdateTable(basicPanel);
        if (basicPanel instanceof CreatePanel){

        }else {
            basicPanel.table.updateUI();
        }

    }

}
