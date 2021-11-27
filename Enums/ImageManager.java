package Enums;

import javax.swing.*;

public enum ImageManager {
    //MainPage
    GO_SEARCH("green_Earth.png"),
    GO_GAME("blue_Earth.png"),
    BACK_MAIN("home_icon.jpg"),
    MAIN_TITLE("Pnfirst_Title.PNG"),

    //SetupPage
    TOGGLE_SETUP("set_up_icon.png"),

    //SimpleSearch
    RUN_SEARCH("search_go.png");


    public final String PATH_TO_DIR = "./View/images/";
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
