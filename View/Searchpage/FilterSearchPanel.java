package View.Searchpage;

import Enums.BtnAction;
import Enums.ImageManager;
import Enums.ModernColor;
import View.ControlHandler;
import View.Searchpage.FilterSearch.FilterManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * 필터를 설정하고 검색을 실행하는 UI
 */
public class FilterSearchPanel extends SearchPanel {

    private FilterManager filter_component;
    private JButton search_execute_button;

    public FilterSearchPanel() {
        super();
    }

    @Override
    protected void setFrame() {
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setBounds(10, 10, 704, 400);
        setBackground(ModernColor.WHITE.COLOR);
        setLayout(null);
    }

    //일반 검색 패널
    @Override
    protected void defineComponents() {
        super.defineComponents();
        filter_component = new FilterManager();
        add(filter_component);
        search_execute_button = new JButton("검색");
        search_execute_button.setBounds(350, 10, 60, 30);
        search_execute_button.setActionCommand(BtnAction.EXECUTE_SEARCH.toString());
        ControlHandler.addButtonHandler(search_execute_button);
        add(search_execute_button);
    }

    @Override
    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImageManager.OPEN_FILTER.getIcon());
        return enter_button;
    }

    public FilterManager getFilterManager() {
        return filter_component;
    }
}
