package View.Searchpage;

import Enums.BtnLst;
import Enums.ImageManager;
import Enums.ModernColor;
import View.ControlListeners;
import View.Searchpage.FilterComp.FilterManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SimpleSearch extends JPanel {

    private FilterManager filter_component;
    private ResultTable search_result;
    private JButton search_execute_button;

    public SimpleSearch() {
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

        search_execute_button = new JButton("검색");
        search_execute_button.setBounds(350, 10, 60, 30);
        search_execute_button.setActionCommand(BtnLst.EXECUTE_SEARCH.toString());
        ControlListeners.addButtonHandler(search_execute_button);
        add(search_execute_button);

        JPanel result = new JPanel();
        result.setBounds(350, 50, 320, 320);
        result.setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        result.setLayout(new GridLayout(10, 0, 0, 0));
        JButton[] b = {new JButton() , new JButton(), new JButton()};
        for (JButton btn : b) {
            btn.setBounds(0, 0, 320, 350);
            result.add(btn);
        }
        add(result);
    }

    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImageManager.RUN_SEARCH.getIcon());
        return enter_button;
    }

    public FilterManager getFilterManager() {
        return filter_component;
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
//				pnSearch_result.setVisible(true);
//				simple_search.setVisible(false);
//				btSrch.setVisible(false);
//				btMap.setVisible(false);
//			}
//		});
}
