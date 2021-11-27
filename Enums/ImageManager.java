package Enums;

import javax.swing.*;

public enum ImageManager {
    //MainPage
    GO_SEARCH("icon_game.png"),
    GO_GAME("icon_search.png"),
    BACK_MAIN("icon_home.jpg"),
    MAIN_TITLE("title.png"),

    //SetupPage
    TOGGLE_SETUP("icon_setup.png"),

    //SearchPage
    OPEN_FILTER("search_filter.png"),
    OPEN_MAP("search_map.png");


    public final String PATH_TO_DIR = "./src/View/images/";
    public final String PATH_TO_IMG;
    public final String PATH;


    private ImageManager(String path) {
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
