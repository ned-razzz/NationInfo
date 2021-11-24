package Model;

public enum Schema {
    NAME("contry"),
    CODE("contry_code"),
    CAPITAL("capital"),
    CLIMATE("climate"),
    LOC("location"),
    CITIES("major_cities"),
    RELIGION("religion"),
    NATION("nation"),
    MEDIA("media"),
    SIZE("area"),
    SOURCE("area_source"),
    SIZE_COMP("area_inst"),
    LANG("lang");

    private final String type;

    private Schema(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
