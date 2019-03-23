package window.frame;

import window.panel.SellPanel;

import javax.swing.*;
import java.awt.*;

public class TextFrame extends JFrame {
    public TextFrame() {

        add(new SellPanel(),BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        validate();
    }
}
