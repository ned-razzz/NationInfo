package View.Searchpage;

import Enums.BtnAction;
import Enums.ImgData;
import View.ControlHandler;
import View.Searchpage.FilterSearch.FilterManager;

import javax.swing.*;

/**
 * 필터를 설정하고 검색을 실행하는 UI
 */
public class FilterSearchPanel extends SearchPanel {

    private FilterManager filter_comp;
    private JButton search_execute_button;
    private ResultInfo result_info;

    public FilterSearchPanel() {
        super();
    }

    //일반 검색 패널
    @Override
    protected void defineComponents() {
        super.defineComponents();
        filter_comp = new FilterManager();
        add(filter_comp);
        search_execute_button = new JButton("검색");
        search_execute_button.setBounds(350, 10, 60, 30);
        search_execute_button.setActionCommand(BtnAction.EXECUTE_SEARCH.toString());
        ControlHandler.addButton(search_execute_button);
        add(search_execute_button);
    }

    @Override
    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImgData.OPEN_FILTER.getIcon());
        return enter_button;
    }

    public void show(ResultInfo obj) {
        result_info = obj;
    }

    public FilterManager getFilterManager() {
        return filter_comp;
    }

    public ResultInfo getResultInfo() {
        return result_info;
    }
}
