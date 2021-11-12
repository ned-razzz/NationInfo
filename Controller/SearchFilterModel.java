package Controller;

import java.util.*;

public class SearchFilterModel{
	//private List<SearchFilter> filter_list;
	private ArrayList<SearchFilter> filter_list;
	private int filter_num;
	
	public SearchFilterModel() {
		filter_list = new ArrayList<SearchFilter>();
		filter_num = 0;
	}
	
	//temporary method
	public String getSql() {
		return "This is SQL sentence";
	}
	
	//get filter(temporary Method)
	public List<SearchFilter> getFilter() {
		return filter_list;
	}
	public SearchFilter getFilter(int index) {
		return filter_list.get(index);
	}
	
	//add
	public void add(SearchFilter sf) {
		String type;
		for(int i = 0; i<filter_num; i++) {
			type = filter_list.get(i).getType();
			if(type.equals(sf.getType()))
					return;
		}
		filter_list.add(sf);
		filter_num++;
		System.out.print(filter_num + "\n");
	}
	
	//delete
	public void delete(SearchFilter sf) {
		String type;
		for(int i = 0; i<filter_num; i++) {
			type = filter_list.get(i).getType();
			if(type.equals(sf.getType())) {
				filter_list.remove(i);
				filter_num--;
				
				System.out.print(filter_num + "\n");
				return;
			}
		}
	}
}
