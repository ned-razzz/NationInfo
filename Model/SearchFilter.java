package Model;

public class SearchFilter {
	public final static String RIGHT_OPER = "+";
	public final static String NOT_OPER = "-";

	private Schema type;
	private String operation;
	private String content;

	public SearchFilter(Schema ty, String op, String con) {
		type = ty;
		operation = op;
		content = con;
	}

	public Schema getType() {
		return type;
	}

	public String getOper() {
		return operation;
	}

	public String getContent() {
		return content;
	}

	public String getSql() {
		String where_sql = String.format("%s {op} '%%%s%%'", type, content);

		if (operation.equals(SearchFilter.RIGHT_OPER)) {
			where_sql = where_sql.replace("{op}", "like");
		}
		else if (operation.equals(SearchFilter.NOT_OPER)) {
			where_sql = where_sql.replace("{op}", "not like");
		}

		return where_sql;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SearchFilter && obj != null) {
			return type == ((SearchFilter) obj).getType() && operation == ((SearchFilter) obj).getOper() && content == ((SearchFilter) obj).getContent();
		}
		else {
			return false;
		}
	}
}
