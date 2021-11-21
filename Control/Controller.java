package Control;

import Model.NationDataModel;
import Model.SearchFilterModel;

import java.lang.reflect.Array;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Controller {
	private NationDataModel data_model;
	private SearchFilterModel filter_model;
//	private View view_client;
	public String[] sorted = new String[100];

}