package View.Gamepage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import Control.Controller;
import Enums.Schema;
import Model.NationDataModel;

public class GameAlgorithm {
	private int score;
	private int limit = 5;
	private String country_name;
	private String right;
	private String[] answers;
	private NationDataModel ndm;
	private boolean gameover = false;
	private boolean done = false;
	
	//method
	public int getScore() {return score;}
	
	public String getName() {return country_name;}
	
	public int getLimit() {return limit;}
	
	public String getCorrect() {return right;}
	
	public String getAnswer(int index) {
		if(index >= 0 && index <4)
			return answers[index];
		else
			return null;
	}
	
	public boolean isGameOver() {
		return gameover;
	}
	
	public GameAlgorithm() {
		ndm = new NationDataModel();
		answers = new String[4];
	}

	public void makeQuestion() {
		done = false;
		Random random = new Random();
		int answer = random.nextInt(4);

		int pNum = -1, nNum = -1;
		for (int i = 0; i < 4; ) {
			System.out.print(i + "\n");
			pNum = nNum;
			//데이터의 수
			nNum = random.nextInt(228);

			if (pNum == nNum) {
				continue;
			}

			String[] info = ndm.gameInfo(nNum);
			if (info == null || info[0].isEmpty() || info[0] == null) {
				System.out.print("again\n");
				if (info != null)
					System.out.print(info[0] + "\n");
				continue;
			}
			String capital = "", country = "";
			try {
				capital = info[0];
				country = info[1];
				String[] forSplit = capital.split("\\(");
				capital = forSplit[0];
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			if (i == answer) {
				//해당하는 인덱스의 국가명과 수도 가져오기
				country_name = country;
				right = capital;
			}
			//System.out.print(nNum + "\n");

			answers[i] = capital;
			i++;
		}
	}
	
	public boolean gameRun() {
		if(gameover == false) {
			makeQuestion();
			
			System.out.print("\n국가명 : " + country_name + "\n");
			System.out.print("정답 : " + right + "\n");
			System.out.print("1 : " + answers[0]);
			System.out.print(" 2 : " + answers[1]);
			System.out.print(" 3 : " + answers[2] + "");
			System.out.print(" 4 : " + answers[3] + "\n\n");
		}
		return gameover;
	}
	
	public int isCorrect(String label) {
		if(done == false && gameover == false) {
			if (label.equals(right)) {
				score ++;
				done = true;
				return 1;
			}
			if(limit > 0 )
				limit--;
			if(limit == 0)
				gameover = true;
			done = true;
			return 0;
		}else
			return -1;
	}
	
	public void initGame() {
		score = 0;
		limit = 5;
		gameover = false;
		done = false;
	}
}