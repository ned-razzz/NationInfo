package View.Searchpage;

import Enums.BtnAction;
import Enums.ModernColor;
import View.ControlHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 검색 결과를 테이블 형태로 사용자에게 보여주는 SearchPanel의 부분 UI
 */
public class ResultTable extends JPanel {

    private ActionListener button_listener;

    public ResultTable() {
        setFrame();
    }

    private void setFrame() {
        setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        setLayout(new GridLayout(0, 1, 0, 3));
    }

    private JButton createButton(String name) {
        JButton res_item = new JButton(name) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getWidth(), getHeight());
            }
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(getWidth(), getHeight());
            }
        };
        res_item.setBounds(0 ,0, 350, 34);
        res_item.setBackground(ModernColor.WHITE.COLOR);
        res_item.setVisible(true);
        res_item.setActionCommand(BtnAction.SEARCH_SPECIPIC.toString());
        ControlHandler.addButtonHandler(res_item);
        return res_item;
    }

    private void resetTable() {
        removeAll();
    }

    private void showTable(ArrayList<String> search_result) {
        resetTable();
        search_result.stream()
                .map(res -> createButton(res))
                .forEach(b -> {
                    add(b);
                });
        revalidate();
        repaint();
    }

    public void executeSearch(ArrayList<String> search_result) {
        showTable(search_result);
    }

    public JScrollPane getScrollPanel() {
        JScrollPane scroll = new JScrollPane(this);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }
}
