package Control;

import Model.*;
import View.Searchpage.SimpleSearch;
import View.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class Controller {
	public NationDataModel data_model;
	private SearchFilterModel filter_model;
	private ViewFrame view_client;

	public Controller() {
		data_model = new NationDataModel();
		filter_model = new SearchFilterModel();
		view_client = new ViewFrame();
	}

	/**
	* main method: Run whole program
	 */
	public static void main(String args[]) {
		Controller con = new Controller();
		con.handler();
		con.run();
	}

	public void run() {
		view_client.launch();
	}

	public void handler() {
		SimpleSearch search_panel =  view_client.getMainPanel().getSearchPanel().getSimpleSearch();
		HashMap<String, ActionListener> button_handler = new HashMap<>();
		button_handler.put("execute", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> result_data = data_model.getColumn(search_panel.getSearchText());
				//테스트 메소드
				result_data.entrySet().stream().forEach(entry -> {
					System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
				});
				System.out.println("=================");
			}
		});
		search_panel.setBtnListener(button_handler);
	}

	/*
	public ArrayList<String> detail_search(String[] key, ArrayList<String> value){
		ArrayList<String> result = new ArrayList<>();
		SortModel sort = new SortModel();
		SearchFilterModel filter = new SearchFilterModel();
		NationDataModel nation = new NationDataModel();

		for(int i = 0; i < 5; i++) {
			if(!(value.get(i) == null)) {
				filter.add(new SearchFilter(key[i], SearchFilter.RIGHT_OPER, value.get(i)));
			}
		}
		result = nation.find(filter);
		result = sort.sort(result);
		return result;

	}
	 */

}