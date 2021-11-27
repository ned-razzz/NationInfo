package Control;

import Enums.BtnAction;
import Enums.Schema;
import Model.*;
import View.Searchpage.FilterComp.FilterComponent;
import View.Searchpage.FilterManager;
import View.Searchpage.ResultInfo;
import View.Searchpage.ResultTable;
import View.Searchpage.SearchPanel;
import View.ViewFrame;

import javax.swing.*;
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
				default:
			}
		}

		public void addFilter() {
			FilterManager fiter_panel = view_client.getSearchPage().getSearchPanel().getFilterManager();
			SearchFilter new_f = fiter_panel.getGenerater().getFilter();
			filter_model.add(new_f);
			fiter_panel.getTable().reload(filter_model);
		}

		public void deleteilter(JButton btn) {
			FilterManager fiter_panel = view_client.getSearchPage().getSearchPanel().getFilterManager();
			FilterComponent compo = (FilterComponent)btn.getParent();
			filter_model.delete(compo.getFilter());
			fiter_panel.getTable().reload(filter_model);
		}

		public void executeSearch() {
			SearchPanel search_panel = view_client.getSearchPage().getSearchPanel();
			ResultTable result_panel = search_panel.getResultTable();
			ArrayList<String> search_result = data_model.find(filter_model);
			result_panel.executeSearch(search_result);
		}

		public void searchSpecific(JButton btn) {
			SearchPanel search_panel = view_client.getSearchPage().getSearchPanel();
			ResultTable result_panel = search_panel.getResultTable();
			HashMap<Schema, String> get_data = data_model.getColumn(btn.getText());
			ResultInfo info_panel = new ResultInfo(view_client, get_data);
			search_panel.show(info_panel);
		}

		public void showInfo(BtnAction cmd) {
			SearchPanel search_panel = view_client.getSearchPage().getSearchPanel();
			ResultInfo info_panel = search_panel.getResultInfo();

			HashMap<Schema, String> data_set = info_panel.getCountryData();
			StringBuilder instruction = new StringBuilder("");

			switch (cmd) {
				case SEARCH_BRIEF:
					data_set.keySet().stream()
							.sorted()
							.filter(key -> (key == Schema.NAME) || (key == Schema.CODE) || (key == Schema.CAPITAL))
							.forEach(key -> {
								instruction.append( "● " + key.KOR_NAME + ":\n" + data_set.get(key) + "\n\n");
							});
					break;
				case SEARCH_REGION:
					data_set.keySet().stream()
							.sorted()
							.filter(key -> (key == Schema.LOC) || (key == Schema.CLIMATE) || (key == Schema.CITIES))
							.forEach(key -> {
								instruction.append( "● " + key.KOR_NAME + ":\n" + data_set.get(key) + "\n\n");
							});
					break;
				case SEARCH_CULTURE:
					data_set.keySet().stream()
							.sorted()
							.filter(key -> (key == Schema.RELIGION) || (key == Schema.NATION) || (key == Schema.LANG) || (key == Schema.MEDIA))
							.forEach(key -> {
								instruction.append( "● " + key.KOR_NAME + ":\n" + data_set.get(key) + "\n\n");
							});
					break;
				case SEARCH_AREA:
					data_set.keySet().stream()
							.sorted()
							.filter(key -> (key == Schema.SIZE) || (key == Schema.SIZE_COMP))
							.forEach(key -> {
								instruction.append( "● " + key.KOR_NAME + ":\n" + data_set.get(key) + "\n\n");
							});
					break;
				case SEARCH_SOURE:
					data_set.keySet().stream()
							.sorted()
							.filter(key ->  (key == Schema.SOURCE) || (key == Schema.STD_YEAR))
							.forEach(key -> {
								instruction.append( "● " + key.KOR_NAME + ":\n" + data_set.get(key) + "\n\n");
							});
					break;
				default:
			}
			info_panel.setinstruction(instruction.toString());
		}
	}
}