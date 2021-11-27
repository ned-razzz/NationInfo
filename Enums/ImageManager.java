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
    RUN_SEARCH("search_go.png"),
	
	//game page
	START_GAME("start_button.png"),
	LABEL_GAME("game_text.png"),
	GO_RESULT_GAME("game_result_text1.png"),
	RESULT_GAME("game_result_text.png"),
	RESTART_GAME("game_restart_button.png");


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
