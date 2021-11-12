package Controller;

import java.util.*;

public class NationDataModel {
	private Database DB_server;
	
	//temporary Method
	public ArrayList<String> getData(String sq){
		ArrayList<String> al = new ArrayList<String>();
		//get Data use sq from database
		al.add("첫 번째");
		al.add("두 번째");
		al.add("세 번째");
		return al;
	}
}
