package Controller;

public class SearchFilter {
	private String filter_type;
	private String filter_operation;
	private String filtering_text;
	
	public SearchFilter(String type, String op, String text) {
		filter_type = type;
		filter_operation = op;
		filtering_text = text;
	}
	
	//return type
	public String getType() {
		return filter_type;
	}
}
