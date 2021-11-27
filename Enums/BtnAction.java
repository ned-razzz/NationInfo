package Enums;

/**
 * 컨트롤에서 제어하는 버튼 리스너들을 구분하는 이름들의 열거체
 */
public enum BtnAction {
    ADD_FILTER,
    DELETE_FILTER,
    EXECUTE_SEARCH,
    EXIT_MAP,

    //검색 결과 메뉴
    SEARCH_SPECIPIC,
    SEARCH_BRIEF,
    SEARCH_REGION,
    SEARCH_CULTURE,
    SEARCH_AREA,
    SEARCH_SOURE,

    //대륙 선택 메뉴
    AFRICA_MAP,
    ASIA_MAP,
    EUROPE_MAP,
    NORTH_AMERICA_MAP,
    SOUTH_AMERICA_MAP,
    OCEANIA_MAP;
}
