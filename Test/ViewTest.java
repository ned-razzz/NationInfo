package Test;

import Enums.Schema;
import Model.SearchFilter;
import Model.SearchFilterModel;
import View.Searchpage.FilterComp.FilterManager;

import javax.swing.*;

public class ViewTest {
    public static void main(String args[]) {
        JFrame test = new JFrame();
        test.setTitle("Test View");
        test.setBounds(0, 0, 840, 500);
        test.setLocationRelativeTo(null);
        test.setResizable(false);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.getContentPane().setLayout(null);
        test.setVisible(true);

        FilterManager test_panel = new FilterManager();
        test.getContentPane().add(test_panel);
        JLayeredPane jlp = test.getLayeredPane();
        jlp.add(test_panel, JLayeredPane.DEFAULT_LAYER);

        SearchFilterModel filter_model = new SearchFilterModel();
        filter_model.add(new SearchFilter(Schema.LOC, SearchFilter.RIGHT_OPER, "유럽"));
        filter_model.add(new SearchFilter(Schema.RELIGION, SearchFilter.NOT_OPER, "가톨릭"));
        test_panel.getTable().reload(filter_model);


        SearchFilterModel filter_modified = new SearchFilterModel();
        filter_modified.add(new SearchFilter(Schema.LOC, SearchFilter.RIGHT_OPER, "중동"));
        filter_modified.add(new SearchFilter(Schema.RELIGION, SearchFilter.NOT_OPER, "가톨릭"));
        filter_modified.add(new SearchFilter(Schema.RELIGION, SearchFilter.RIGHT_OPER, "가톨릭"));
        test_panel.getTable().reload(filter_modified);
    }
}
