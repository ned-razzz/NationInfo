package Enums;

import javax.swing.*;

public enum ImgData {
    //MainPage
    GO_SEARCH("icon_game.png"),
    GO_GAME("icon_search.png"),
    BACK_MAIN("icon_home.jpg"),
    MAIN_TITLE("title.png"),

    //SetupPage
    TOGGLE_SETUP("icon_setup.png"),

    //SearchPage
    OPEN_FILTER("search_filter.png"),
    OPEN_MAP("search_map.png"),

    //MapPage
    WORLD_MAP("worldmap.png"),
    AFRICA_MAP("africa.png"),
    ASIA_MAP("asia.png"),
    EUROPE_MAP("europe.png"),
    NORTH_AMERICA_MAP("north_america.png"),
    SOUTH_AMERICA_MAP("south_america.png"),
    OCEANIA_MAP("oceania.png"),

    //Game Page
    START_GAME("start_button.png"),
    LABEL_GAME("game_text.png"),
    GO_RESULT_GAME("game_result_text1.png"),
    RESULT_GAME("game_result_text.png"),
    RESTART_GAME("game_restart_button.png");

    public final String PATH_TO_DIR = "./src/View/images/";
    public final String PATH_TO_IMG;
    public final String PATH;


    private ImgData(String path) {
        PATH_TO_IMG = path;
        PATH = PATH_TO_DIR + PATH_TO_IMG;
    }

    @Override
    public String toString() {
        return PATH;
    }

    public ImageIcon getIcon() {
        return new ImageIcon(PATH);
    }
}
