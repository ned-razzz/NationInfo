package View.Searchpage;

import Enums.BtnAction;
import Enums.ImageManager;
import Enums.ModernColor;
import View.ControlHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * 필터를 설정하고 검색을 실행하는 UI
 */
public class SearchPanel extends JPanel {

    private FilterManager filter_component;
    private ResultTable result_table;
    private ResultInfo result_info;

    private JButton search_execute_button;

    public SearchPanel() {
        setFrame();
        defineComponents();
    }

    private void setFrame() {
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setBounds(10, 10, 704, 400);
        setBackground(ModernColor.WHITE.COLOR);
        setLayout(null);
    }

    //일반 검색 패널
    private void defineComponents() {
        filter_component = new FilterManager();
        add(filter_component);

        result_table = new ResultTable();
        JScrollPane srcoll_container = result_table.getScrollPanel();
        srcoll_container.setBounds(330, 50, 350, 340);
        add(srcoll_container);

        search_execute_button = new JButton("검색");
        search_execute_button.setBounds(350, 10, 60, 30);
        search_execute_button.setActionCommand(BtnAction.EXECUTE_SEARCH.toString());
        ControlHandler.addButtonHandler(search_execute_button);
        add(search_execute_button);


    }

    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImageManager.RUN_SEARCH.getIcon());
        return enter_button;
    }

    public void show(ResultInfo obj) {
        result_info = obj;
    }

    public FilterManager getFilterManager() {
        return filter_component;
    }

    public ResultTable getResultTable() {
        return result_table;
    }

    public ResultInfo getResultInfo() {
        return result_info;
    }
}
