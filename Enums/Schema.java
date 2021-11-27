package Enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    LANG("lang", "언어"),
    STD_YEAR("std_year", "조사일자");

    public final String ENG_NAME;
    public final String KOR_NAME;
    public final static HashMap<String, Schema> search_list = new HashMap<String, Schema>(Arrays.stream(Schema.values())
            .collect(Collectors.toMap(k -> k.ENG_NAME, v -> v)));

    private Schema(String eng_name, String kor_name) {
        this.ENG_NAME = eng_name;
        this.KOR_NAME = kor_name;
    }

    public static Schema getFromKor(String kor_name) {
        return Arrays.stream(Schema.values())
                .filter(schema -> schema.KOR_NAME.equals(kor_name))
                .findFirst().get();
    }

    public static Schema getFromEng(String eng_name) {
        return search_list.get(eng_name);
    }

    @Override
    public String toString() {
        return ENG_NAME;
    }
}
