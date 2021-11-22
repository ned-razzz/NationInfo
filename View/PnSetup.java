package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

//설정패널
public class PnSetup extends JPanel {

	JComboBox lang_select; //언어 선택 콤보박스
	JComboBox fontsize_select; //폰트사이즈 콤보박스
	JButton gotomain_Button; //메인으로 돌아가는 버튼
	JLabel gotomain_Label;
	
	public PnSetup() {
		//기본설정
		setVisible(false);
		setBounds(0, 0, 824, 461);
		setLayout(null);
		
		//언어선택 콤보박스
		lang_select = new JComboBox();
		lang_select.setBounds(260, 50, 480, 35);
		add(lang_select);
		
		JLabel lang_label = new JLabel("Language");
		lang_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lang_label.setBounds(140, 50, 90, 35);
		add(lang_label);
		
		//폰트사이즈 콤보박스
		fontsize_select = new JComboBox();
		fontsize_select.setBounds(260, 130, 480, 35);
		add(fontsize_select);
		
		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);
		add(fontsize_Label);
		
		//메인으로 돌아가는 버튼
		JButton gotomain_Button = gotomainButton();
		add(gotomain_Button);
		
		JLabel gotomain_Label = gotomainLabel();
		add(gotomain_Label);

	}
	
	private JButton gotomainButton() {
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("./images/home_icon.jpg"));
		button.setBounds(70, 380, 45, 45);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfclose();
			}
		});
		return button;
	}

	private JLabel gotomainLabel() {
		JLabel label = new JLabel("    Close");
		label.setBounds(64, 436, 68, 15);
		return label;
	}
	
	private void selfclose() {
		this.setVisible(false);
	}

}