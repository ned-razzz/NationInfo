package Control;

import Enums.BtnLst;
import Model.*;
import View.ControlListeners;
import View.Searchpage.FilterComp.FilterManager;
import View.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
		ControlListeners.getButtons().stream()
				.forEach(b -> {
					b.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							BtnLst command = BtnLst.valueOf(e.getActionCommand());
							switch (command) {
								case ADD_FILTER:
									addFilter();
									break;
								case EXECUTE_SEARCH:
									executeSearch();
									break;
								default:
							}
						}
					});
				});
	}

	public void addFilter() {
		FilterManager fiter_panel =  view_client.getSearchPanel().getSimpleSearch().getFilterManager();
		SearchFilter new_f = fiter_panel.getGenerater().getFilter();
		filter_model.add(new_f);
		fiter_panel.getTable().reload(filter_model);
	}

	public void executeSearch() {
		//미구현
	}

//		button_handler.put("execute", new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				HashMap<String, String> result_data = data_model.getColumn(search_panel.getSearchText());
//				result_data.entrySet().stream().forEach(entry -> {
//					System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
//				});
//				System.out.println("=================");
//			}
//		});
//		search_panel.setBtnListener(button_handler);


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