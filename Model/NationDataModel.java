package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import Enums.Schema;

public class NationDataModel {
    public final static Schema PRIMARY_KEY = Schema.NAME;
	public final static String SQL_ALL = "select * from nation";

	//특정 행 정보 전달
	//key 매개변수는 반드시 PRIMARY_KEY만 가능
	public HashMap<String, String> getColumn(String key) {
		ResultSet sql_res = null; //sql 작업 리턴값
		HashMap<String, String> res_data = new HashMap<>(); //최종 결과값
		String sql = String.format(SQL_ALL + " where %s='%s'", PRIMARY_KEY, key);

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

	//특정 열 정보 전달
	public HashMap<String, HashMap<String, String>> getColumnList(ArrayList<String> keys) {
		HashMap<String, HashMap<String, String>> res_dataset = new HashMap<>();

		//where절
		StringBuilder sql_where = new StringBuilder(String.format("%s in (", PRIMARY_KEY));
		keys.stream().forEach(key -> {
			sql_where.append("'" + key + "'" + ",");
		});
		sql_where.deleteCharAt(sql_where.length()-1); // 마지막 ',' 문자 제거
		sql_where.append(")");

		String sql = String.format(SQL_ALL + " where %s", sql_where);
		System.out.println(sql);

		try {
			ResultSet sql_res = Database.getInstance().executeSql(sql);
			ResultSetMetaData sql_meta = sql_res.getMetaData();
			while (sql_res.next()) {
				HashMap<String, String> res_data = new HashMap<>();
				for (int i = 1; i <= sql_meta.getColumnCount(); i++) {
					res_data.put(sql_meta.getColumnName(i), sql_res.getString(i));
				}
				res_dataset.put(sql_res.getString(PRIMARY_KEY.toString()), res_data);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res_dataset;
	}

	
	//특정 조건의 column들만을 추출
	//추출된 table에서 나라 이름과 원하는 res_type 값만을 key-value화 시켜, hashmap 형태로 반환
	public ArrayList<String> find(SearchFilter filter) {
		ArrayList<String> finded = new ArrayList<>();
		String sql = String.format("select %s from nation where %s", PRIMARY_KEY, filter.getSql());
		System.out.println(sql);

		try {
			ResultSet sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.add(sql_res.getString(PRIMARY_KEY.toString()));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}
	
	public ArrayList<String> find(SearchFilterModel filter) {
		ArrayList<String> finded = new ArrayList<>();
		String sql = String.format("select %s from nation", PRIMARY_KEY);

		if(!filter.getFilterList().isEmpty()) {
			sql += String.format(" where %s", filter.getSql());
		}
		System.out.println(sql);

		try {
			ResultSet sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.add(sql_res.getString(PRIMARY_KEY.toString()));
				System.out.println(sql_res.getString(PRIMARY_KEY.toString()));
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
	
	public ResultSet getGameSource() {
		String sql = "SELECT " + Schema.NAME.TYPE + ", " + Schema.CAPITAL.TYPE + " FROM nation";
		ResultSet sql_res = null;
		try {
			sql_res = Database.getInstance().executeSql(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sql_res;
	}
	
	public String gameName(int num) {
		ResultSet resultSet = getGameSource();
		if(resultSet != null) {
			int i = 0;
			try {
				while(resultSet.next()) {
					if(i == num) return resultSet.getString(Schema.NAME.TYPE);
					i++;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String gameCapital(int num) {
		ResultSet resultSet = getGameSource();
		if(resultSet != null) {
			int i = 0;
			try {
				while(resultSet.next()) {
					if(i == num) return resultSet.getString(Schema.CAPITAL.TYPE);
					i++;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
