package View.Searchpage;

import Enums.ImageManager;
import Enums.ModernColor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MapSearchPanel extends SearchPanel {


    public MapSearchPanel() {
        super();
    }

    @Override
    protected void setFrame() {
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setBounds(10, 10, 704, 400);
        setBackground(ModernColor.WHITE.COLOR);
        setLayout(null);
    }

    @Override
    protected void defineComponents() {    }

    @Override
    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImageManager.OPEN_MAP.getIcon());
        return enter_button;
    }
}
