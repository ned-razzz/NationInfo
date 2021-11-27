package View.Searchpage.FilterComp;

import Enums.BtnAction;
import Enums.ModernColor;
import Model.SearchFilter;
import View.ControlHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FilterComponent extends JPanel {

    private JLabel type;
    private JLabel oper;
    private JLabel content;
    private JButton delete_button;
    private SearchFilter filter;

    public FilterComponent() {
        setFrame();
    }

    public FilterComponent(SearchFilter filter) {
        this.filter = filter;
        setFrame();
        setComps();
    }

    private void setFrame() {
        setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        setBackground(ModernColor.WHITE.COLOR);
        setBounds(0, 0, 80, 40);
        setLayout(null);
    }

    private void setComps() {

        type = new JLabel(filter.getType().KOR_NAME);
        type.setBounds(5, 3, 40, 17);
        type.setFont(new Font("맑은 고딕",  Font.PLAIN, 10));

        oper = new JLabel(filter.getOper());
        oper.setBounds(45, -1, 20, 20);
        oper.setFont(new Font("맑은 고딕",  Font.PLAIN, 15));

        content = new JLabel(filter.getContent());
        content.setBounds(5, 20, 70, 17);
        content.setFont(new Font("맑은 고딕",  Font.PLAIN, 12));
        content.setBorder(new LineBorder(ModernColor.BLACK.COLOR, 1));
        content.setBackground(ModernColor.WHITE.COLOR);
        content.setOpaque(true);

        delete_button = new JButton("X");
        delete_button.setToolTipText("필터 삭제하기");
        delete_button.setBounds(60, -1, 20, 20);
        delete_button.setFont(new Font("Arial", Font.BOLD, 8));

        delete_button.setActionCommand(BtnAction.DELETE_FILTER.toString());
        ControlHandler.addButtonHandler(delete_button);

        add(type);
        add(oper);
        add(content);
        add(delete_button);
    }

    public SearchFilter getFilter() {
        return filter;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getWidth(), getHeight());
    }
}
