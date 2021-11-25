package Enums;

import java.awt.*;

public enum ModernColor {
    BLACK(new Color(13, 13, 13)),
    WHITE(new Color(250, 250, 250)),
    BEIGE(new Color(240, 240, 153)),
    GRAY_BLACK(new Color(64, 64, 63)),
    GRAY_BLUE(new Color(99, 109, 115));


    public Color COLOR;

    private ModernColor(Color color) {
        this.COLOR = color;
    }
}
