package Control;

import Enums.BtnAction;
import Model.*;
import View.ControlListeners;
import View.Searchpage.FilterManager;
import View.Searchpage.ResultInfo;
import View.Searchpage.ResultTable;
import View.Searchpage.SearchPanel;
import View.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * View와 Model을 결합 및 지시하여 프로그램 동작시킴
 */
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
							BtnAction command = BtnAction.valueOf(e.getActionCommand());
							switch (command) {
								case ADD_FILTER:
									addFilter();
									break;
								case EXECUTE_SEARCH:
									executeSearch();
									break;
								case LOOKFOR_BRIEF:
									break;
								case LOOKFOR_REGION:
									break;
								case LOOKFOR_CULTURE:
									break;
								case LOOKFOR_AREA:
									break;
								case LOOKFOR_SOURE:
									break;
								default:
							}
						}
					});
				});
	}

	public void addFilter() {
		FilterManager fiter_panel = view_client.getSearchPanel().getSearchPanel().getFilterManager();
		SearchFilter new_f = fiter_panel.getGenerater().getFilter();
		filter_model.add(new_f);
		fiter_panel.getTable().reload(filter_model);
	}

	public void executeSearch() {
		SearchPanel search_panel = view_client.getSearchPanel().getSearchPanel();
		ResultTable result_panel = search_panel.getResultTable();

		ArrayList<String> search_result = data_model.find(filter_model);
		ActionListener table_btn_event = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String key = e.getActionCommand();
				HashMap<String, String> get_data = data_model.getColumn(key);
				ResultInfo info_panel = new ResultInfo(view_client, get_data);
				search_panel.setResultInfo(info_panel);
			}
		};
		result_panel.executeSearch(search_result, table_btn_event);
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