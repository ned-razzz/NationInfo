import java.util.ArrayList;


import java.util.*;


public class Sort {
	//private NationDataModel data_model
	//private SearchFilterModel filter_model
	//private View view-client
	public String[] sorted = new String[100];
	
	public void basic_search(String nation_name) {}	// 기본 검색(상세 x)
	public void detail_search(String cty_code, String religion, String climate, String location) {} // 상세 검색
	
	public void addFilter(String type, String oper, String text) {}
	public void deleteFilter(String type, String oper, String text) {} //
	public void setEventListener() {} 	// 버튼리스너
	
	public void mergesort(String array[], int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergesort(array,low,mid);
			mergesort(array,mid+1,high);
			merge(array,low,mid,high);
		}
	}
	
	public void merge(String list[], int left, int mid, int right) {    //list 타입만 바꿔주면 모든 타입 정렬가능

		int i, j, k, l;
		
		i = left; j = mid+1; k = left;
		
		// 분할 정렬된 list의 합병
		while(i<=mid && j<=right){
			if(list[i].charAt(0) <= list[j].charAt(0)) {
				if(list[i].charAt(0) == list[j].charAt(0)) {
					for (int temp = 1; temp < list[i].length() && temp < list[j].length(); temp++) {
						if(list[i].charAt(temp) < list[j].charAt(temp)) {
							sorted[k++] = list[i++];
						} else {
							sorted[k++] = list[j++];
						}
					}
				}
				sorted[k++] = list[i++];
			}
			else {
				sorted[k++] = list[j++];
			}
		}
		
		if(i>mid) { // 남아 있는 레코드의 일괄 복사
			for(l=j; l<=right; l++) {
				sorted[k++] = list[l];
			}
		}
		else { // 남아 있는 레코드의 일괄 복사
			for(l=i; l<=mid; l++) {
				sorted[k++] = list[l];
			}
		}
		
		// 배열 sorted[]의 리스트를 배열 list[]로 복사
		for(l=left; l<=right; l++) {
			list[l] = sorted[l];
		}
	}
		
	
	public static void main(String arg[]) {
		Controller con = new Controller();
		
		String[] temp = {"뷁", "궳쉗", "답섭궨", "뷁가"};	//합병정렬 후 => 궳쉗 답섭궨 뷁 뷁가      ㄱㄴㄷ, ㅏㅑㅓㅕ순 
		con.mergesort(temp, 0, 3);
		
		
		for(int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}

		
    }
}
