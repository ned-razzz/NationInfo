package View.Searchpage.FilterSearch;

import Enums.ModernColor;

import javax.swing.*;
import javax.swing.border.LineBorder;


/**
 * 필터를 만들고 추가하는 SearchPanel의 부분 UI
 */
public class FilterManager extends JPanel {
    private FilterGenerater filter_generater;
    private FilterTable filter_table;

    public FilterManager() {
        setFrame();
        setComponents();
    }

    private void setFrame() {
        setBorder(new LineBorder(ModernColor.BLACK.COLOR, 2));
        setBounds(10, 10, 300, 390);
        setLayout(null);
        setVisible(true);
    }

    public void setComponents() {
        filter_generater = new FilterGenerater();
        filter_table = new FilterTable();
        add(filter_generater);
        add(filter_table);
    }

    public FilterGenerater getGenerater() {
        return filter_generater;
    }
    public FilterTable getTable() {
        return filter_table;
    }
}
