package View.Searchpage.FilterComp;

import Enums.ModernColor;
import Model.SearchFilter;
import Model.SearchFilterModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FilterTable extends JPanel {

    private HashMap<SearchFilter, FilterComponent> filter_comps;

    public FilterTable() {
        setFrame();
        filter_comps = new HashMap<>();
    }

    private void setFrame() {
        setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        setBounds(10, 130, 280, 250);
        setBackground(ModernColor.WHITE.COLOR);
        setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
    }

    public void addFilter(SearchFilter filter) {
        FilterComponent comp = new FilterComponent(filter);
        filter_comps.put(filter, comp);
        add(comp);
    }

    public void deleteFilter(SearchFilter filter) {
        remove(filter_comps.get(filter));
        filter_comps.remove(filter);
    }

    public void reload(SearchFilterModel filter_model) {
        HashSet<SearchFilter> filters = filter_model.getFilterList();
        //model에서 추가된 필터 생성
        filters.stream()
                .filter(f -> !(filter_comps.containsKey(f)))
                .forEach(f -> {
                    addFilter(f);
                });
        //model에서 제거된 필터 삭제
        SearchFilter[] delete_list = filter_comps.entrySet().stream()
                .filter(e -> !(filters.contains(e.getKey())))
                .map(e -> e.getKey())
                .toArray(SearchFilter[]::new);
        Arrays.stream(delete_list).forEach(d -> {
            deleteFilter(d);
        });

        revalidate();
        repaint();
    }
}
