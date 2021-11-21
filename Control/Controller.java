package Control;

import Model.NationDataModel;
import Model.SearchFilterModel;
import View.ViewFrame;

import javax.swing.text.View;



public class Controller {
	private NationDataModel data_model;
	private SearchFilterModel filter_model;
	private ViewFrame view_client;

	public Controller() {
		data_model = new NationDataModel();
		filter_model = new SearchFilterModel();
		view_client = new ViewFrame();
		view_client.run();
	}

	public static void main(String args[]) {
		Controller con = new Controller();

	}

}