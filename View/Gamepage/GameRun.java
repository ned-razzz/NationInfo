package View.Gamepage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Control.gameControl.Game;
import Enums.ImgData;

public class GameRun extends JPanel {
	JButton answer_1;
	JButton answer_2;
	JButton answer_3;
	JButton answer_4;
	JButton next_question_Button;
	JButton result_Button;
	JButton sub_result_Button;
	
	JLabel correct_Label;
	JLabel wrong_Label;
	JLabel score_Label;
	JLabel life_Label;
	JLabel question_label;
	JLabel answer_Label;
	JLabel correct_static_label;
	
	Game game;
	
	JPanel panel;
	JPanel right_p;

	GameResult game_result;
	
	public GameRun(Container content_pane, PnGame pn, Game g) {
		game = g;
		
		setVisible(true);
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		game_result = new GameResult(pn);
		content_pane.add(game_result);
		game_result.setVisible(false);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(260, 10, 334, 441);
		add(panel);
		panel.setLayout(null);
		
		right_p = new JPanel();
		right_p.setBorder(new LineBorder(new Color(125, 125, 125), 2, true));
		right_p.setBounds(20, 230, 150, 100);
		add(right_p);
		right_p.setLayout(null);
		right_p.setVisible(false);
		
		answer_1 = new JButton(game.getAnswer(0));
		answer_1.setBounds(12, 160, 310, 50);
		answer_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(answer_1);
		answer_1.addActionListener(choiceAnswer);
		
		answer_2 = new JButton(game.getAnswer(1));
		answer_2.setBounds(12, 230, 310, 50);
		answer_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(answer_2);
		answer_2.addActionListener(choiceAnswer);
		
		answer_3 = new JButton(game.getAnswer(2));
		answer_3.setBounds(12, 300, 310, 50);
		answer_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(answer_3);
		answer_3.addActionListener(choiceAnswer);
		
		answer_4 = new JButton(game.getAnswer(3));
		answer_4.setBounds(12, 370, 310, 50);
		answer_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(answer_4);
		answer_4.addActionListener(choiceAnswer);
		
		question_label = new JLabel(game.getName());
		question_label.setFont(new Font("돋움체", Font.PLAIN, 17));
		question_label.setBorder(new TitledBorder(new LineBorder(Color.black,3)));
		question_label.setBounds(50, 26, 240, 60);
		panel.add(question_label);
		question_label.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel question_static_label = new JLabel("위 국가의 수도는 무엇일까요 ?");
		question_static_label.setFont(new Font("돋움체", Font.PLAIN, 20));
		question_static_label.setBounds(20, 90, 443, 52);
		panel.add(question_static_label);
		
		correct_static_label = new JLabel("정답은?");
		correct_static_label.setFont(new Font("굴림", Font.PLAIN, 20));
		correct_static_label.setBounds(10, 0, 443, 52);
		right_p.add(correct_static_label);
		
		answer_Label = new JLabel("정답!");
		answer_Label.setFont(new Font("굴림", Font.BOLD, 15));
		answer_Label.setBounds(10, 50, 205, 47);
		right_p.add(answer_Label);
		
		score_Label = new JLabel("점수 : 0점");
		score_Label.setFont(new Font("굴림", Font.BOLD, 30));
		score_Label.setBounds(12, 15, 205, 47);
		add(score_Label);
		
		life_Label = new JLabel("남은 기회 : " + game.getLimit());
		life_Label.setFont(new Font("굴림", Font.BOLD, 25));		
		life_Label.setBounds(12, 72, 205, 47);
		add(life_Label);
		
		correct_Label = new JLabel("정답입니다!");
		correct_Label.setFont(new Font("굴림", Font.PLAIN, 25));
		correct_Label.setBounds(20, 154, 205, 47);
		add(correct_Label);
		correct_Label.setVisible(false);
		
		wrong_Label = new JLabel("오답입니다..");
		wrong_Label.setFont(new Font("굴림", Font.PLAIN, 25));
		wrong_Label.setBounds(20, 154, 205, 47);
		add(wrong_Label);
		wrong_Label.setVisible(false);
		
		next_question_Button = new JButton("다음문제");
		next_question_Button.setBounds(12, 386, 205, 47);
		next_question_Button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(next_question_Button);
		next_question_Button.setVisible(false);
		next_question_Button.addActionListener(next);
		
		sub_result_Button = new JButton("다음");
		sub_result_Button.setBounds(12, 386, 205, 47);
		sub_result_Button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(sub_result_Button);
		sub_result_Button.setVisible(false);
		sub_result_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_result_Button.setVisible(false);
				result_Button.setVisible(true);
				panel.setVisible(false);
			}
		});
		
		result_Button = new JButton("");
		result_Button.setIcon(ImgData.GO_RESULT_GAME.getIcon());
		result_Button.setBounds(290, 150, 300, 80);
		result_Button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(result_Button);
		result_Button.setVisible(false);
		result_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				game_result.setResult(game.getScore());
				game_result.setVisible(true);
			}
		});
	}
	
	ActionListener choiceAnswer = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton nowButton = null;
			if(e.getSource() == answer_1)
				nowButton = answer_1;
			else if(e.getSource() == answer_2)
				nowButton = answer_2;
			else if(e.getSource() == answer_3)
				nowButton = answer_3;
			else if(e.getSource() == answer_4)
				nowButton = answer_4;
			
			int result = game.isCorrect(nowButton.getText());
			if(result == 1)
				correct_Label.setVisible(true);
			else if(result == 0) {
				wrong_Label.setVisible(true);
				answer_Label.setText(game.getCorrect() + "!");
				right_p.setVisible(true);
			}
			
			score_Label.setText("점수 : " + Integer.toString(game.getScore()) + "점");
			life_Label.setText("남은 기회 : " + Integer.toString(game.getLimit()));
			
			if(game.isGameOver()) {
				sub_result_Button.setVisible(true);
			}else 
				next_question_Button.setVisible(true);
		}
	};
	
	ActionListener next = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			correct_Label.setVisible(false);
			wrong_Label.setVisible(false);
			next_question_Button.setVisible(false);
			game.gameRun();
			
			question_label.setText(game.getName());
			answer_1.setText(game.getAnswer(0));
			answer_2.setText(game.getAnswer(1));
			answer_3.setText(game.getAnswer(2));
			answer_4.setText(game.getAnswer(3));
			
			right_p.setVisible(false);
		}
	};
	
	public void init() {
		game.initGame();
		game.gameRun();
		
		answer_1.setText(game.getAnswer(0));
		answer_2.setText(game.getAnswer(1));
		answer_3.setText(game.getAnswer(2));
		answer_4.setText(game.getAnswer(3));
		
		correct_Label.setVisible(false);
		wrong_Label.setVisible(false);
		next_question_Button.setVisible(false);
		result_Button.setVisible(false);
		
		score_Label.setText("점수 : " + Integer.toString(game.getScore()) + "점");
		life_Label.setText("남은 기회 : " + Integer.toString(game.getLimit()));
		question_label.setText(game.getName());
		
		panel.setVisible(true);
		game_result.setVisible(false);
		right_p.setVisible(false);
		this.setVisible(true);
	}
}
