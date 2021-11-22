package Test;

import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ModelTest {
    NationDataModel data_model = new NationDataModel();

    //test code
    public static void main(String[] arg) throws SQLException {
        ModelTest test = new ModelTest();
        test.testFilter();
    }

    public void testGetColumn() {
        HashMap<String, String> res = data_model.getColumn("불가리아");
        res.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        });
        System.out.println("====================");
    }

    public void testFind() {
        String test_content = "지중해";
        System.out.println("search climate: " + test_content);
        HashMap<String, String> data_map;
        data_map = data_model.find(new SearchFilter(Schema.CLIMATE, SearchFilter.RIGHT_OPER, test_content), Schema.CLIMATE); //SearchFilter find 메소드
        data_map.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        });
    }

    public void testFilter() {
        SearchFilterModel filter_model = new SearchFilterModel();
        filter_model.add(new SearchFilter(Schema.LOC, SearchFilter.RIGHT_OPER, "유럽"));
        filter_model.add(new SearchFilter(Schema.RELIGION, SearchFilter.NOT_OPER, "가톨릭"));
        System.out.println(filter_model.getSql());
        HashMap<String, String> data_map = data_model.find(filter_model, Schema.LANG);
        data_map.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        });
    }

    public void testSort() {
        String[] arr = {"뷁", "궳쉗", "답섭궨", "뷁가", "난동", "다람쥐", "라일락", "마즙", "바보", "사과", "아저씨", "자석", "차", "카레", "타조", "하마"};
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        System.out.println("===");
        list = SortModel.sort(list);
        System.out.println("===");
        list.stream().forEach(item -> {System.out.print(item + " ");});
    }

}
