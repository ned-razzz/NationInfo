package DataPackage;

import java.util.*;

public class DataDriver {

	public static void main(String[] args) {
		//Data data = new Data();
		DataExploration data_ex = new DataExploration();
		ControllerForFilter cont = new ControllerForFilter();
		ArrayList<String> str_a;
		
		//for(String[] i : data.table_data)
		//	System.out.print(i[0] + " " + i[1] + " " + i[2] + "\n");
		//for(String i : data_ex.str)
		//	System.out.print(i + "\n");
		
		//ArrayList<String> str = data_ex.getNames();
		//for(String s : str)
		//	System.out.print(s + "\n");
		

		/*
		String[] str = data_ex.getData("발할라");
		//data_ex.getData("타이완");
		if(str != null)
			for(String i : str)
				System.out.print(i + " ");
		else
			System.out.print("데이터가 없습니다.");
		*/
		
		/*
		//time check
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
		//실험할 코드 추가
		String[] str = data_ex.getData("말레이시아");
		//data_ex.getData("타이완");
		if(str != null) {
			for(String i : str)
				System.out.print(i + " ");
			System.out.print("\n");
		} else
			System.out.print("데이터가 없습니다.\n"); 
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이 : "+ secDiffTime);		
		*/
		
		/*
		ArrayList<Integer> i = new ArrayList<Integer>();
		i.add(1);
		i.add(5);
		i.add(10);
		ArrayList<String> str = data_ex.getNames(i);
		for(String k : str)
			System.out.print(k + " ");
		System.out.print("\n");
		*/
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		String[] str = data_ex.getData("발할라");
		//data_ex.getData("타이완");
		if(str != null) {
			for(String i : str)
				System.out.print(i + " ");
			System.out.print("\n");
		} else
			System.out.print("데이터가 없습니다.\n"); 
		
		cont.addFilter("기후", "아열대성");
		cont.addFilter("종교", "불교");
		ArrayList<Integer> result = cont.search();
		for(int i : result)
			System.out.print(i + " ");
		System.out.print("\n");
		
		str_a = data_ex.getNames(result);
		for(String i : str_a)
			System.out.print(i + " ");
		System.out.print("\n");
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(ms) : "+ secDiffTime);
	}
}
