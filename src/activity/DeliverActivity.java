package activity;

import DB.subActivity.UpdateDeliver;
import DB.subActivity.UpdateOrderstatus;
import DB.subActivity.Updateaddr;
import window.panel.DeliverPanel;

public class DeliverActivity {
  public DeliverActivity(DeliverPanel deliverPanel){
    //  int order=getsale.order;
      int  order= Integer.parseInt(deliverPanel.inputOrderNumber.getText());

     int express= Integer.parseInt(deliverPanel.inputExpressNumber.getText());

     String  addr= deliverPanel.inputAddress.getText();


    new UpdateDeliver(order,express);
    new Updateaddr(express,addr);
    new UpdateOrderstatus(order,"delivered");
    new RefreshActivity(deliverPanel);



  }
}
