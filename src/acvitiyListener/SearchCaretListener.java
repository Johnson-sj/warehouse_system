package acvitiyListener;

import DB.subActivity.UpdateTable;
import window.panel.*;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class SearchCaretListener implements CaretListener {
    private BasicPanel panel;

    public SearchCaretListener(BasicPanel panel) {
        this.panel = panel;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        new UpdateTable(panel);

    }
}
