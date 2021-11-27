package game;

import java.util.Random;

import Control.Controller;
import Model.NationDataModel;

public class Game {
	private int score;
	private int limit = 5;
	private String country_name;
	private String right;
	private String[] answers;
	private NationDataModel ndm;
	private boolean gameover = false;
	
	public int getScore() {return score;}
	
	public String getName() {return country_name;}
	
	public int getLimit() {return limit;}
	
	public String getAnswer(int index) {
		if(index >= 0 && index <3)
			return answers[index];
		else
			return null;
	}
	
	public boolean isGameOver() {
		return gameover;
	}
	
	public Game() {
		ndm = new NationDataModel();
		answers = new String[3];
	}
	
	public void makeQuestion() {
		Random random = new Random();
		int answer = random.nextInt(3);
		
		int pNum = -1, nNum = -1;
		for(int i = 0; i<3;) {
			pNum = nNum;
			//데이터의 수
			nNum = random.nextInt(228);
			if(pNum == nNum) continue;
			if(ndm.gameCapital(nNum) == null) continue;
			
			String capital = ndm.gameCapital(nNum);
			String[] forSplit = capital.split("\\(");
			capital = forSplit[0];
			if(i == answer) {
				//해당하는 인덱스의 국가명과 수도 가져오기
				country_name = ndm.gameName(nNum);
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
			System.out.print(" 3 : " + answers[2] + "\n\n");
		}
		return gameover;
	}
	
	public boolean isCorrect(String label) {
		if (label.equals(right)) {
			score ++;
			return true;
		}
		if(limit > 0 )
			limit--;
		if(limit == 0)
			gameover = true;
		return false;
	}
}