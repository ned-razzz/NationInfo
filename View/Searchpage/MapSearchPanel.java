package View.Searchpage;

import Enums.BtnAction;
import Enums.ImgData;
import View.ControlHandler;
import View.Searchpage.MapSearch.ContinentMap;
import View.Searchpage.MapSearch.WorldMap;

import javax.swing.*;
import java.util.Arrays;

public class MapSearchPanel extends SearchPanel {

    private WorldMap worldmap;
    private ContinentMap continent_map;
    private JButton conti_exit_button;

    public MapSearchPanel() {
        super();
    }

    @Override
    protected void defineComponents() {
        super.defineComponents();
        
        worldmap = new WorldMap();
        continent_map = new ContinentMap();

        conti_exit_button = new JButton("나가기");
        conti_exit_button.setBounds(350, 10, 80, 30);
        conti_exit_button.setActionCommand(BtnAction.EXIT_MAP.toString());
        ControlHandler.addButton(conti_exit_button);

        setButtons();

        add(worldmap);
        add(continent_map);
        add(conti_exit_button);
        toggleCont(false);
    }

    @Override
    public JButton getEnterButton() {
        //해당 검색 패널로 이동하는 버튼
        JButton enter_button = new JButton(ImgData.OPEN_MAP.getIcon());
        return enter_button;
    }

    private void setButtons() {
        JButton btNthAmerica = new JButton("N.America");
        btNthAmerica.setBounds(103, 165, 100, 25);
        btNthAmerica.setActionCommand(BtnAction.NORTH_AMERICA_MAP.toString());

        JButton btSthAmerica = new JButton("S.America");
        btSthAmerica.setBounds(188, 283, 100, 25);
        btSthAmerica.setActionCommand(BtnAction.SOUTH_AMERICA_MAP.toString());

        JButton btAfrica = new JButton("Africa");
        btAfrica.setBounds(331, 220, 80, 25);
        btAfrica.setActionCommand(BtnAction.AFRICA_MAP.toString());

        JButton btEurope = new JButton("Europe");
        btEurope.setBounds(346, 142, 80, 25);
        btEurope.setActionCommand(BtnAction.EUROPE_MAP.toString());

        JButton btAsia = new JButton("Asia");
        btAsia.setBounds(479, 182, 70, 25);
        btAsia.setActionCommand(BtnAction.ASIA_MAP.toString());

        JButton btOceania = new JButton("Oceania");
        btOceania.setBounds(545, 320, 90, 25);
        btOceania.setActionCommand(BtnAction.OCEANIA_MAP.toString());

        JButton[] btn_list = { btNthAmerica, btSthAmerica, btAfrica, btEurope, btAsia, btOceania};
        Arrays.stream(btn_list)
                .forEach(btn -> {
                    ControlHandler.addButton(btn);
                });

        worldmap.add(btNthAmerica);
        worldmap.add(btSthAmerica);
        worldmap.add(btAfrica);
        worldmap.add(btEurope);
        worldmap.add(btAsia);
        worldmap.add(btOceania);
    }

    public WorldMap getWorldmap() {
        return worldmap;
    }

    public ContinentMap getContinentMap() {
        return continent_map;
    }

    public void toggleCont(boolean b) {
        if (b) {
            scroll_container.setVisible(true);
            result_table.setVisible(true);
            conti_exit_button.setVisible(true);
            worldmap.setVisible(false);
        } else {
            scroll_container.setVisible(false);
            result_table.setVisible(false);
            conti_exit_button.setVisible(false);
            worldmap.setVisible(true);
        }
        revalidate();
        worldmap.repaint();
    }
}
