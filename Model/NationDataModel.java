package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class NationDataModel {
    public final static Schema PRIMARY_KEY = Schema.NAME;
	public final static String SQL_ALL = "select * from nation";

	//특정 열 정보 전달
	public ArrayList<String> getList() {
		return null;
	}

	//특정 행 정보 전달
	public HashMap<String, String> getColumn(String content) {


		ResultSet sql_res = null; //sql 작업 리턴값
		HashMap<String, String> res_data = new HashMap<>(); //최종 결과값
		String sql = String.format(SQL_ALL + " where %s='%s'", PRIMARY_KEY, content);

		try {
			//sql 작업
			sql_res = Database.getInstance().executeSql(sql);
			sql_res.next();
			ResultSetMetaData sql_meta = sql_res.getMetaData();

			//sql한 결과를 Map 리스트에 저장
			for (int i = 1; i <= sql_meta.getColumnCount(); i++) {
				res_data.put(sql_meta.getColumnName(i), sql_res.getString(i));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return res_data;
	}
	
	//특정 조건의 column들만을 추출
	//추출된 table에서 나라 이름과 원하는 res_type 값만을 key-value화 시켜, hashmap 형태로 반환
	public HashMap<String, String> find(SearchFilter filter, Schema res_type) {
		HashMap<String, String> finded = new HashMap<>();
		String sql = String.format("select %s, %s from nation where %s", PRIMARY_KEY, res_type, filter.getSql());
		System.out.println(sql);

		try {
			ResultSet sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.put(sql_res.getString(PRIMARY_KEY.toString()), sql_res.getString(res_type.toString()));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}
	
	public HashMap<String, String> find(SearchFilterModel filter, Schema target) {
		HashMap<String, String> finded = new HashMap<>();
		String sql = String.format("select %s, %s from nation where %s", PRIMARY_KEY, target, filter.getSql());
		System.out.println(sql);

		try {
			ResultSet sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.put(sql_res.getString(PRIMARY_KEY.toString()), sql_res.getString(target.toString()));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}

	public ResultSet sql(String sql) {
		ResultSet sql_result = null;
		try {
			sql_result = Database.getInstance().executeSql(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sql_result;
	}
}
