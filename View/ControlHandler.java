package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Control에서 다룰 버튼 리스너 작업을 한꺼번에 처리하기 위한 클래스
 */
public class ControlHandler {
    //Control이 조작할 이벤트 버튼들을 저장
    private static ArrayList<JButton> buttons = new ArrayList<>();
    //Control의 작업 명령이 담긴 버튼에 넣을 이벤트 핸들러.
    private static ActionListener btn_listener;

    public static void addButtonHandler(JButton btn) {
        if (btn_listener == null) {
            System.err.println("addButtonHandler: ControlHandler Listener Error");
        }
        buttons.add(btn);
        btn.addActionListener(btn_listener);
    }
    public static ArrayList<JButton> getButtons() {
        return buttons;
    }
    public static void setActionHandler(ActionListener action) {
        btn_listener = action;
    }
}
