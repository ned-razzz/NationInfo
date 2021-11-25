package View.Searchpage;

import Enums.BtnAction;
import Enums.ImageManager;
import Enums.ModernColor;
import View.ControlListeners;

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
        JScrollPane scroll_panel = result_table.getScrollPanel();
        scroll_panel.setBounds(330, 50, 350, 340);
        add(scroll_panel);

        search_execute_button = new JButton("검색");
        search_execute_button.setBounds(350, 10, 60, 30);
        search_execute_button.setActionCommand(BtnAction.EXECUTE_SEARCH.toString());
        ControlListeners.addButtonHandler(search_execute_button);
        add(search_execute_button);


    }

    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImageManager.RUN_SEARCH.getIcon());
        return enter_button;
    }

    public FilterManager getFilterManager() {
        return filter_component;
    }

    public ResultTable getResultTable() {
        return result_table;
    }

    public void setResultInfo(ResultInfo obj) {
        result_info = obj;
    }

    public ResultInfo getResultInfo() {
        return result_info;
    }


//    public String getSearchText() {
//        return search_text.getText();
//    }

//    public void setBtnListener(HashMap<String, ActionListener> list_map) {
//        if (list_map.containsKey("execute")) {
//            search_execute_button.addActionListener(list_map.get("execute"));
//        }
//    }

//		// 검색 결과 버튼(예시) -> 누르면 검색 결과(나라 정보)가 나옴
//		btCountry1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				pnSearch_setVisible(true);
//				simple_search.setVisible(false);
//				btSrch.setVisible(false);
//				btMap.setVisible(false);
//			}
//		});
}
