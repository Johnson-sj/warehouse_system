package window.panel;

import acvitiyListener.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;


public class BasicPanel extends JPanel {
    public JTable table;
    public JButton submit = new JButton("submit"),
            cancel = new JButton("cancel");
    public JLabel productId = new JLabel("product id:"),
                orderNumber = new JLabel("the order number:"),
                count = new JLabel("count:"),
                expressNumber = new JLabel("express number:"),
                address = new JLabel("address:"),
                productName = new JLabel("product name:"),
                productPrice = new JLabel("product price:");
    public JTextField inputProductId = new JTextField(),
                    inputOrderNumber = new JTextField(),
                    inputCount = new JTextField(),
                    inputExpressNumber = new JTextField(),
                    inputAddress = new JTextField(),
                    inputName = new JTextField(),
                    inputPrice = new JTextField();
    public Box BoxProduct,BoxOrder,BoxCount,BoxExpress,BoxAddress,BoxButton,BoxName,BoxPrice;

    public List<String> TITLES;
    public Vector<Vector<String>> dataModel ;


    public BasicPanel() {
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(600,400));
//        setMaximumSize(new Dimension(600,400));
        setLayout(new BorderLayout());

        inputProductId.setPreferredSize(new Dimension(300,20));
        BoxProduct = Box.createHorizontalBox();
        BoxProduct.add(productId);
        BoxProduct.add(Box.createHorizontalStrut(20));
        BoxProduct.add(inputProductId);

        inputOrderNumber.setPreferredSize(new Dimension(300,20));
        BoxOrder = Box.createHorizontalBox();
        BoxOrder.add(orderNumber);
        BoxOrder.add(Box.createHorizontalStrut(20));
        BoxOrder.add(inputOrderNumber);

        inputCount.setPreferredSize(new Dimension(300,20));
        BoxCount = Box.createHorizontalBox();
        BoxCount.add(count);
        BoxCount.add(Box.createHorizontalStrut(20));
        BoxCount.add(inputCount);

        inputExpressNumber.setPreferredSize(new Dimension(300,20));
        BoxExpress = Box.createHorizontalBox();
        BoxExpress.add(expressNumber);
        BoxExpress.add(Box.createHorizontalStrut(20));
        BoxExpress.add(inputExpressNumber);

        inputAddress.setPreferredSize(new Dimension(300,20));
        BoxAddress = Box.createHorizontalBox();
        BoxAddress.add(address);
        BoxAddress.add(Box.createHorizontalStrut(20));
        BoxAddress.add(inputAddress);

        BoxButton = Box.createHorizontalBox();
        BoxButton.add(submit);
        BoxButton.add(Box.createHorizontalStrut(20));
        BoxButton.add(cancel);



        inputName.setPreferredSize(new Dimension(300,20));
        BoxName = Box.createHorizontalBox();
        BoxName.add(productName);
        BoxName.add(Box.createHorizontalStrut(20));
        BoxName.add(inputName);

        inputPrice.setPreferredSize(new Dimension(300,20));
        BoxPrice = Box.createHorizontalBox();
        BoxPrice.add(productPrice);
        BoxPrice.add(Box.createHorizontalStrut(20));
        BoxPrice.add(inputPrice);


        inputProductId.addKeyListener(new NumberVerificationKeyAdapter(this));
        inputOrderNumber.addKeyListener(new NumberVerificationKeyAdapter(this));
        inputExpressNumber.addKeyListener(new NumberVerificationKeyAdapter(this));
        inputCount.addKeyListener(new NumberVerificationKeyAdapter(this));
        inputPrice.addKeyListener(new NumberVerificationKeyAdapter(this));

        inputProductId.addCaretListener(new SearchCaretListener(this));
        inputOrderNumber.addCaretListener(new SearchCaretListener(this));
        inputExpressNumber.addCaretListener(new SearchCaretListener(this));

        submit.addActionListener(new SubmitListener(this));
        cancel.addActionListener(new CancelListener(this));
    }

    public JTable getAccountTable() {
        Vector<String> titles = new Vector<String>(TITLES);
        table = new JTable(dataModel, titles){
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                else return true;
            }};
        table.addMouseListener(new TableMouseAdapter(this));
        return table;
    }

    public JTable getNotEditTable(){
        Vector<String> titles = new Vector<String>(TITLES);
        table = new JTable(dataModel, titles){ public boolean isCellEditable(int row, int column) { return false; }};
        table.addMouseListener(new TableMouseAdapter(this));
        return table;
    }

}
