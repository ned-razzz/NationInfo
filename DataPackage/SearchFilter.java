package DataPackage;

//this filter have just type : condition
public class SearchFilter {
	private String filter_type;
	//private String filter_operation;
	private String filtering_text;
	
	public SearchFilter(String type, String text) {
		filter_type = type;
		//filter_operation = op;
		filtering_text = text;
	}
	
	//return type
	public String getType() {
		return filter_type;
	}
	
	//return text
	public String getText()	{
		return filtering_text;
	}
}
