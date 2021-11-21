package highClassProject;

import java.util.*;

public class ControllerForFilter {
	DataExploration data_ex = new DataExploration();
	ArrayList<SearchFilter> filter_list = new ArrayList<SearchFilter>();
	int filter_num = 0;
	
	public void addFilter(String type, String text) {
		SearchFilter filter = new SearchFilter(type, text);
		String t;
		for(int i = 0; i<filter_num; i++) {
			t = filter_list.get(i).getText();
			if(t.equals(filter.getText()))
					return;
		}
		filter_list.add(filter);
		filter_num++;
		//System.out.print(filter_num + "\n");
		//System.out.print(filter_model.getFilter(0).getType() + "\n");
	}
	
	//delete filter
	public void deleteFilter(String type, String text) {
		SearchFilter filter = new SearchFilter(type, text);
		String t;
		for(int i = 0; i<filter_num; i++) {
			t = filter_list.get(i).getText();
			if(t.equals(filter.getText())) {
				filter_list.remove(i);
				filter_num--;
				
				//System.out.print(filter_num + "\n");
				return;
			}
		}
	}
	
	public ArrayList<Integer> search() {
		return data_ex.searchTable(filter_list);
	}
}
