package View.Searchpage.FilterSearch;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

import Enums.BtnAction;
import Enums.ModernColor;
import Enums.Schema;
import Model.SearchFilter;
import View.ControlHandler;

/**
 * 필터를 생성시키는 UI 컴포넌트
 */
public class FilterGenerater extends JPanel {

    private JComboBox<String> type_setter; //검색 종류
    private ButtonGroup oper_setter; //검색 연산자
    private JRadioButton include_radio;
    private JRadioButton exept_radio;
    private JTextArea content_setter; //검색 내용

    private JButton add_filter; //필터 추가 버튼

    public FilterGenerater() {
        setFrame();
        setComponents();
        setPos();
    }

    private void setFrame() {
        setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        setBounds(10, 10, 280, 100);
        setBackground(ModernColor.WHITE.COLOR);
        setLayout(null);
    }

    private void setComponents() {
        //type_setter
        String[] schemas = Arrays.stream(Schema.values())
            .map(schema -> schema.KOR_NAME)
            .toArray(String[]::new);
        type_setter = new JComboBox<String>(schemas);
        type_setter.setEditable(true);
        type_setter.setBackground(ModernColor.WHITE.COLOR);
        type_setter.setRenderer(new DefaultListCellRenderer() {
                                    public Component getListCellRendererComponent(JList list,
                                                                                  Object value,
                                                                                  int index,
                                                                                  boolean isSelected,
                                                                                  boolean cellHasFocus) {
                                        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                                        if (isSelected)
                                            c.setBackground(ModernColor.WHITE.COLOR);
                                        else
                                            c.setBackground(Color.WHITE);

                                        return c;
                                    }
                                });

        //oper_setter
        oper_setter = new ButtonGroup();
        include_radio = new JRadioButton("포함", true);
        exept_radio = new JRadioButton("제외", false);
        include_radio.setBackground(ModernColor.WHITE.COLOR);
        exept_radio.setBackground(ModernColor.WHITE.COLOR);
        include_radio.setActionCommand("+");
        exept_radio.setActionCommand("-");
        oper_setter.add(include_radio);
        oper_setter.add(exept_radio);

        //content_setter
        content_setter = new JTextArea();
        content_setter.setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        content_setter.setText("입력");

        //add_filter
        add_filter = new JButton("+");
        add_filter.setToolTipText("필터 추가하기");
        add_filter.setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        add_filter.setBackground(ModernColor.WHITE.COLOR);
        add_filter.setForeground(ModernColor.BLACK.COLOR);
        add_filter.setFont(new Font("Arial", Font.BOLD, 16));
        add_filter.setFocusPainted(false);
        add_filter.setActionCommand(BtnAction.ADD_FILTER.toString());
        ControlHandler.addButton(add_filter);

        add(type_setter);
        add(include_radio);
        add(exept_radio);
        add(content_setter);
        add(add_filter);
    }

    private void setPos() {
        type_setter.setBounds(10, 10, 100, 20);
        include_radio.setBounds(10, 40, 50, 20);
        exept_radio.setBounds(60, 40, 50, 20);
        content_setter.setBounds(10, 70, 150, 20);
        add_filter.setBounds(getWidth()-40, getHeight()-40, 30,30);
    }

    public SearchFilter getFilter() {
        String type = String.valueOf(type_setter.getSelectedItem());
        String oper = oper_setter.getSelection().getActionCommand();
        String content = content_setter.getText();
        return new SearchFilter(Schema.getFromKor(type), oper, content);
    }
}
