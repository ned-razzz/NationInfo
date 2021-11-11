package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class for test controller
public class Controller {
	//variable
	static private NationDataModel data_model;
	static private SearchFilterModel filter_model;
	static private View view_client;
	
	//run project
	public static void main(String[] args) {
		data_model = new NationDataModel();
		filter_model = new SearchFilterModel();
        view_client = new View();
        
        view_client.setSearchView();
        //view_client.run();
        
        //test code
        Controller controll = new Controller();
        controll.addFilter("기후", "?", "온난");
        controll.deleteFilter("기후", "?", "온난");
        System.out.print("성공\n");
	}
	
	//find data
	public void search() {	
	}
	
	//add filter
	public void addFilter(String type, String oper, String text) {
		SearchFilter filter = new SearchFilter(type, oper, text);
		filter_model.add(filter);
		
		//System.out.print(filter_model.getFilter(0).getType() + "\n");
	}
	
	//delete filter
	public void deleteFilter(String type, String oper, String text) {
		SearchFilter filter = new SearchFilter(type, oper, text);
		filter_model.delete(filter);
	}
	
	//set event Listener - ?
	public void setEventListener() {
	}
}
