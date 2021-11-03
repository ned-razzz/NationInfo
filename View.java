import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame main_frame;
    private JPanel search_panel;

    private final int MAIN_WIDTH = 960;
    private final int MAIN_HEIGHT = 720;

    public View() {
        main_frame = new JFrame();
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setSize(MAIN_WIDTH, MAIN_HEIGHT);
    }

    public void run() {
        main_frame.setVisible(true);
    }

    public void setSearchView() {
        search_panel = new JPanel();
        search_panel.setBackground(Color.gray);

        search_panel.setBounds(0, 0, MAIN_WIDTH * 3/4, MAIN_HEIGHT);
        main_frame.add(search_panel);
    }
}
