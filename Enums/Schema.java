package Enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Schema {
    NAME("contry", "국가명"),
    CODE("contry_code", "국가코드"),
    CAPITAL("capital", "수도"),
    CLIMATE("climate", "기후"),
    LOC("location", "위치"),
    CITIES("major_cities", "주요도시"),
    RELIGION("religion", "종교"),
    NATION("nation", "인종"),
    MEDIA("media", "주요매체"),
    SIZE("area", "면적"),
    SOURCE("area_source", "면적출처"),
    SIZE_COMP("area_inst", "비교면적"),
    LANG("lang", "언어");

    public final String TYPE;
    public final String KOR_NAME;

    private Schema(String type, String name) {
        this.TYPE = type;
        this.KOR_NAME = name;
    }

    @Override
    public String toString() {
        return TYPE;
    }

    public static Schema getSchema(String name) {
        return Arrays.stream(Schema.values())
                .filter(schema -> schema.KOR_NAME == name)
                .findFirst().get();
    }
}
