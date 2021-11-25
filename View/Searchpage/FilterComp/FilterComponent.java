package View.Searchpage.FilterComp;

import Enums.ModernColor;
import Model.SearchFilter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FilterComponent extends JPanel {

    private JLabel type;
    private JLabel oper;
    private JLabel content;

    public FilterComponent() {
        setFrame();
    }

    public FilterComponent(SearchFilter filter) {
        setFrame();
        setComps(filter);
    }

    private void setFrame() {
        setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        setBackground(ModernColor.BEIGE.COLOR);
        setBounds(0, 0, 80, 40);
        setLayout(null);
    }

    private void setComps(SearchFilter filter) {

        type = new JLabel(filter.getType().KOR_NAME);
        type.setBounds(5, 3, 35, 17);
        type.setFont(new Font("맑은 고딕",  Font.PLAIN, 10));

        oper = new JLabel(filter.getOper());
        oper.setBounds(60, -3, 20, 20);
        oper.setFont(new Font("맑은 고딕",  Font.PLAIN, 15));

        content = new JLabel(filter.getContent());
        content.setBounds(5, 20, 70, 17);
        content.setFont(new Font("맑은 고딕",  Font.PLAIN, 12));
        content.setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        content.setBackground(ModernColor.WHITE.COLOR);
        content.setOpaque(true);

        add(type);
        add(oper);
        add(content);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getWidth(), getHeight());
    }
}
