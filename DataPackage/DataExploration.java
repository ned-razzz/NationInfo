package DataPackage;

import java.util.*;

public class DataExploration {
	TestData data = new TestData();
	
	//String[] str = data.table_index_data[1];
	
	
	//return data's index!!! : before sort
	public ArrayList<Integer> searchTable(ArrayList<SearchFilter> filter) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<String> before_clean = new ArrayList<String>();
		
		int start = -1, end = -1;
		String type, text;
		
		for(SearchFilter f : filter) {
			type = f.getType();

			//get range : condition
			for(int i = 0; i < data.table_index_condition.length; i++) {
				if(type.equals(data.table_index_condition[i][0])) {
					start = Integer.parseInt(data.table_index_condition[i][1]);
					if(i == data.table_index_condition.length - 1) 
						end = data.table_index_data.length - 1;
					else
						end = Integer.parseInt(data.table_index_condition[i+1][1]) - 1;
					break;
				}
			}

			if(start == -1 || end == -1) // throw Exeption
				return null;
			
			text = f.getText();
			String[] str = null;
			//get data's index : according to condition(filter's text)
			for(int i = (start+end)/2; start<=end; i = (start+end)/2) {
				str = data.table_index_data[i];
				if(start == end) {
					if(!(text.equals(str[1])))
						break;
				}
				if(text.equals(str[0])) {
					for(String s : str[1].split(","))
						before_clean.add(s);
					break;
				}else if(text.compareTo(str[1]) > 0)
					end = i;
				else if(text.compareTo(str[1]) < 0)
					start = i;
			}
			
			start = end = -1;
		}
		
		for(String i : before_clean) {
			result.add(Integer.parseInt(i));
		}
		return result;
	}
	
	//return origin data 	: only one in details
	public String[] getData(int index) {
		String[] result = data.table_data[index];
		return result;
	}
	
	//						: only one in simple
	public String[] getData(String name) {
		char s = name.charAt(0);
		String c = data.consonant[(char)((s-0xAC00)/28/21)];
		//System.out.print(c);
		int start = -1, end = -1;

		String[] str;
		//get range
		for(int i = 0; i < data.table_index_cons.length; i++) {
			str = data.table_index_cons[i];
			if(str[0].equals(c)) {
				start = Integer.parseInt(str[1]);
				if(i == data.table_index_cons.length - 1)
					end = data.table_data.length - 1;
				else
					end = Integer.parseInt(data.table_index_cons[i+1][1]) - 1;
			}
		}
		
		if(start == -1)
			return null;
		
		str = null;
		//binary search in table_data
		for(int i = (start+end)/2; start<=end; i = (start+end)/2) {
			str = data.table_data[i];
			if(start == end) {
				if(!(str[0].equals(name)))
					return null;
			}
			
			if(str[0].equals(name))
				return str;
			else if(name.compareTo(str[0]) > 0) 
				end = i;
			else if(name.compareTo(str[0]) < 0)
				start = i;
		}
		return null;
	}
	
	//return origin data 	: several data's name
	public ArrayList<String> getNames(ArrayList<Integer> index){
		ArrayList<String> names = new ArrayList<String>();
		for(int  i : index)
			names.add(data.table_data[i][0]);
		return names;
	}
	
	//						: all data's name
	public ArrayList<String> getNames(){
		ArrayList<String> names = new ArrayList<String>();
		for(String[]  i : data.table_data)
			names.add(i[0]);
		return names;
	}
}
