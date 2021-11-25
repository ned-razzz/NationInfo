package Model;

import Model.SearchFilter;

import java.util.*;

public class SearchFilterModel {

	private HashSet<SearchFilter> filter_list;
	
	public SearchFilterModel() {
		filter_list = new HashSet<>();
	}
	
	//filter list modification
	public boolean add(SearchFilter new_ft) {
		filter_list.add(new_ft);
		return true;
	}

	public boolean delete(SearchFilter target_ft) {
		filter_list.remove(target_ft);
		return true;
	}

	//filter_list 배열을 반환
	public HashSet<SearchFilter> getFilterList() {
		return filter_list;
	}

	//create sql
	public String getSql() {
		String sql = "";
		for (SearchFilter filter : filter_list) {
			sql += filter.getSql();
			sql += " AND ";
		}
		sql = sql.substring(0, sql.length()-5); // 마지막 AND 문 삭제
		return sql;
	}

}
