package acvitiyListener;

import window.panel.BasicPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberVerificationKeyAdapter extends KeyAdapter {

    private BasicPanel panel;

    public NumberVerificationKeyAdapter(BasicPanel panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == panel.inputPrice){
            int keyChar = e.getKeyChar();
            if((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)|| keyChar == KeyEvent.VK_PERIOD||
                    (keyChar >= KeyEvent.VK_NUMPAD0 && keyChar <= KeyEvent.VK_NUMPAD9)){
            }else{
                e.consume(); //关键，屏蔽掉非法输入
            }
        }else {
            int keyChar = e.getKeyChar();
            if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

            }else{
                e.consume(); //关键，屏蔽掉非法输入
            }
        }
    }
}
