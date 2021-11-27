package View.Searchpage;

import Enums.BtnAction;
import Enums.ModernColor;
import View.ControlHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SearchPanel extends JPanel {

    protected ResultTable result_table;
    protected ResultInfo result_info;

    public SearchPanel() {
        setFrame();
        defineComponents();
    }

    protected void setFrame() {
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setBounds(10, 10, 704, 400);
        setBackground(ModernColor.WHITE.COLOR);
        setLayout(null);
    }

    protected void defineComponents() {
        result_table = new ResultTable();
        JScrollPane srcoll_container = result_table.getScrollPanel();
        srcoll_container.setBounds(330, 50, 350, 340);
        add(srcoll_container);
    }

    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton();
        return enter_button;
    }

    public void show(ResultInfo obj) {
        result_info = obj;
    }

    public ResultTable getResultTable() {
        return result_table;
    }

    public ResultInfo getResultInfo() {
        return result_info;
    }
}
