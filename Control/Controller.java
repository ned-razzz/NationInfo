package Control;

import Enums.BtnAction;
import Enums.Schema;
import Model.*;
import View.Searchpage.*;
import View.Searchpage.FilterSearch.FilterItem;
import View.Searchpage.FilterSearch.FilterManager;
import View.Searchpage.MapSearch.ContinentMap;
import View.Searchpage.MapSearch.WorldMap;
import View.ViewFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * View�� Model�� ���� �� �����Ͽ� ���α׷� ���۽�Ŵ
 */
public class Controller {
	public NationDataModel data_model;
	private SearchFilterModel filter_model;
	private ViewFrame view_client;

	public Controller() {
		data_model = new NationDataModel();
		filter_model = new SearchFilterModel();
		view_client = new ViewFrame(new Handler());
	}

	/**
	 * main method: Run whole program
	 */
	public static void main(String args[]) {
		Controller con = new Controller();
		con.run();
	}

	public void run() {
		view_client.launch();
	}

	class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command_text = e.getActionCommand();
			System.out.println(command_text);
			BtnAction command = BtnAction.valueOf(command_text);
			if (!(e.getSource() instanceof JButton)) {
				System.err.println("Handler Class Error");
			}
			switch (command) {
				case ADD_FILTER:
					addFilter();
					break;
				case DELETE_FILTER:
					deleteilter((JButton)e.getSource());
					break;
				case EXECUTE_SEARCH:
					executeSearch();
					break;
				case SEARCH_SPECIPIC:
					searchSpecific((JButton)e.getSource());
					break;
				case SEARCH_BRIEF:
				case SEARCH_REGION:
				case SEARCH_CULTURE:
				case SEARCH_AREA:
				case SEARCH_SOURE:
					showInfo(command);
					break;
				case ASIA_MAP:
				case EUROPE_MAP:
				case AFRICA_MAP:
				case OCEANIA_MAP:
				case NORTH_AMERICA_MAP:
				case SOUTH_AMERICA_MAP:
					openMap(command);
					break;
				case EXIT_MAP:
					exitContiPage();
					break;
				default:
			}
		}

		public void addFilter() {
			FilterManager fiter_panel = view_client.getSearchPage().getFilterPanel().getFilterManager();
			SearchFilter new_f = fiter_panel.getGenerater().getFilter();
			filter_model.add(new_f);
			fiter_panel.getTable().reload(filter_model);
		}

		public void deleteilter(JButton btn) {
			FilterManager fiter_panel = view_client.getSearchPage().getFilterPanel().getFilterManager();
			FilterItem compo = (FilterItem)btn.getParent();
			filter_model.delete(compo.getFilter());
			fiter_panel.getTable().reload(filter_model);
		}

		public void executeSearch() {
			FilterSearchPanel filter_panel = view_client.getSearchPage().getFilterPanel();
			ResultTable result_panel = filter_panel.getResultTable();
			ArrayList<String> search_result = data_model.find(filter_model);
			result_panel.executeSearch(search_result);
		}

		public void searchSpecific(JButton btn) {
			FilterSearchPanel filter_panel = view_client.getSearchPage().getFilterPanel();
			HashMap<Schema, String> get_data = data_model.getColumn(btn.getText());
			ResultInfo info_panel = new ResultInfo(view_client, get_data);
			filter_panel.show(info_panel);
		}

		public void showInfo(BtnAction cmd) {
			FilterSearchPanel search_panel = view_client.getSearchPage().getFilterPanel();
			ResultInfo info_panel = search_panel.getResultInfo();

			HashMap<Schema, String> data_set = info_panel.getCountryData();
			SchemaFilter filter_func = key -> true;
			switch (cmd) {
				case SEARCH_BRIEF:
					filter_func = key -> (key == Schema.NAME) || (key == Schema.CODE) || (key == Schema.CAPITAL);
					break;
				case SEARCH_REGION:
					filter_func = key -> (key == Schema.LOC) || (key == Schema.CLIMATE) || (key == Schema.CITIES);
					break;
				case SEARCH_CULTURE:
					filter_func = key -> (key == Schema.RELIGION) || (key == Schema.NATION) || (key == Schema.LANG) || (key == Schema.MEDIA);
					break;
				case SEARCH_AREA:
					filter_func = key -> (key == Schema.SIZE) || (key == Schema.SIZE_COMP);
					break;
				case SEARCH_SOURE:
					filter_func = key -> (key == Schema.SOURCE) || (key == Schema.STD_YEAR);
					break;
				default:
			}
			String instruction = getInstruction(data_set, filter_func);
			info_panel.setinstruction(instruction);
		}

		public String getInstruction(HashMap<Schema, String> data_set, SchemaFilter func) {
			StringBuilder inst = new StringBuilder("");
			data_set.keySet().stream()
					.sorted()
					.filter(key -> func.filtering(key))
					.forEach(key -> {
						inst.append( "*" + key.KOR_NAME + ":\n" + data_set.get(key) + "\n\n");
					});
			return inst.toString();
		}

		public void openMap(BtnAction cmd) {
			MapSearchPanel map_panel = view_client.getSearchPage().getMapPanel();
			WorldMap world_panel = map_panel.getWorldmap();
			ContinentMap continent_panel = map_panel.getContinentMap();
			ResultTable result_panel = map_panel.getResultTable();

			String content = null;
			switch (cmd) {
				case AFRICA_MAP:
					continent_panel.select(0);
					content = "아프리카";
					break;
				case ASIA_MAP:
					continent_panel.select(1);
					content = "아시아";
					break;
				case EUROPE_MAP:
					continent_panel.select(2);
					content = "유럽";
					break;
				case NORTH_AMERICA_MAP:
					continent_panel.select(3);
					content = "북미";
					break;
				case SOUTH_AMERICA_MAP:
					continent_panel.select(4);
					content = "남미";
					break;
				case OCEANIA_MAP:
					continent_panel.select(5);
					content = "오세아니아";
					break;
			}

			if (content == null) {
				return;
			}
			ArrayList<String> search_result = data_model.find(new SearchFilter(Schema.LOC, SearchFilter.RIGHT_OPER, content));
			result_panel.executeSearch(search_result);
			map_panel.toggleCont(true);

		}

		public void exitContiPage() {
			MapSearchPanel map_panel = view_client.getSearchPage().getMapPanel();
			map_panel.toggleCont(false);
		}
	}
}