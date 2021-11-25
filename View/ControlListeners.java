package View;

import javax.swing.*;
import java.util.ArrayList;

public class ControlListeners {
    private static ArrayList<JButton> buttons = new ArrayList<>();

    public static void addButtonHandler(JButton btn) {
        buttons.add(btn);
    }
    public static ArrayList<JButton> getButtons() {
        return buttons;
    }
}
