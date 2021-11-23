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
        test.testGetColumnList();
    }

    public void testGetColumn() {
        HashMap<String, String> res = data_model.getColumn("불가리아");
        res.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        });
        System.out.println("====================");
    }

    public void testGetColumnList() {
        SearchFilterModel filter_model = new SearchFilterModel();
        filter_model.add(new SearchFilter(Schema.LOC, SearchFilter.RIGHT_OPER, "유럽"));
        ArrayList<String> data_map = data_model.find(filter_model);

        HashMap<String, HashMap<String, String>> res_datas = data_model.getColumnList(data_map); //SearchFilter find 메소드
        res_datas.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue().get(Schema.CLIMATE.toString()));
        });
    }

    public void testFilter() {
        SearchFilterModel filter_model = new SearchFilterModel();
        filter_model.add(new SearchFilter(Schema.LOC, SearchFilter.RIGHT_OPER, "유럽"));
        filter_model.add(new SearchFilter(Schema.RELIGION, SearchFilter.NOT_OPER, "가톨릭"));
        System.out.println(filter_model.getSql());
        ArrayList<String> data_map = data_model.find(filter_model);
        data_map.stream().forEach(name -> {
            System.out.printf("%s\n", name);
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
