package View.Searchpage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SimpleSearch extends JPanel {

    private JPanel search_contents;
    private JTextArea search_text;
    private JButton search_execute_button;
    private JLabel search_mode_label;

    public SimpleSearch() {
        setFrame();
        defineComponents();
    }

    private void setFrame() {
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setBounds(10, 10, 704, 400);
        setLayout(null);
    }

    //간편검색 패널
    private void defineComponents() {
        //창 내부 콘텐츠 컨테이너
        search_contents = new JPanel();
        search_contents.setBorder(new LineBorder(new Color(0, 0, 0)));
        search_contents.setBounds(39, 31, 530, 342);
        search_contents.setLayout(null);

        //간편 검색 텍스트 입력창
        search_text = new JTextArea();
        search_text.setBounds(127, 71, 270, 34);
        search_text.setText("* \uC774\uB984 \uAE30\uC785");

        //검색창 이름
        search_mode_label = new JLabel("텍스트 검색");
        search_mode_label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        search_mode_label.setBounds(155, 10, 232, 47);

        //검색 실행 버튼
        search_execute_button = new JButton("검색");
        search_execute_button.setBounds(396, 72, 57, 33);
        search_execute_button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //나라 검색 결과 버튼(임시)
        JButton show_result_button = new JButton("검색 결과");
        show_result_button.setBounds(0, 115, 530, 40);

        add(search_contents);
        search_contents.add(search_text);
        search_contents.add(search_mode_label);
        search_contents.add(search_execute_button);
        search_contents.add(show_result_button);
    }

    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(new ImageIcon("./Images/search_go.png"));
        return enter_button;
    }

    public String getSearchText() {
        return search_text.getText();
    }

    public void setBtnListener(HashMap<String, ActionListener> list_map) {
        if (list_map.containsKey("execute")) {
            search_execute_button.addActionListener(list_map.get("execute"));
        }
    }

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
