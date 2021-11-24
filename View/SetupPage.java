package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

//설정패널
public class SetupPage extends JPanel {

	private JComboBox language_setup; //언어 선택 콤보박스
	private JComboBox fontsize_setup; //폰트사이즈 콤보박스
	private JButton setup_button;
	private JButton close_setup_button; //메인으로 돌아가는 버튼

	public SetupPage() {
		setFrame();
		defineSetupComponents();
		defineSetupBtn();
	}

	private void setFrame() {
		setVisible(false);
		setBounds(0, 0, 824, 461);
		setLayout(null);
	}

	private void defineSetupComponents() {
		//언어선택 콤보박스
		language_setup = new JComboBox();
		language_setup.setBounds(260, 50, 480, 35);
		add(language_setup);

		JLabel language_Label = new JLabel("Language");
		language_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		language_Label.setBounds(140, 50, 90, 35);
		add(language_Label);

		//폰트사이즈 콤보박스
		fontsize_setup = new JComboBox();
		fontsize_setup.setBounds(260, 130, 480, 35);
		add(fontsize_setup);

		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);
		add(fontsize_Label);
	}

	private void defineSetupBtn() {
		//설정창을 여는 버튼
		setup_button = new JButton("");
		setup_button.setForeground(Color.WHITE);
		setup_button.setIcon(new ImageIcon("./images/set_up_icon.png"));
		setup_button.setBounds(741, 10, 40, 40);
		setup_button.setBorderPainted(false);
		setup_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleSetupPanel(true);
			}
		});

		//설정창을 끄는 버튼
		close_setup_button = new JButton("");
		close_setup_button.setIcon(new ImageIcon("./images/home_icon.jpg"));
		close_setup_button.setBounds(70, 380, 45, 45);
		close_setup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSetupPanel(false);
			}
		});
		add(close_setup_button); //끄는 버튼은 설정창에 귀속

		JLabel gotomain_Label = new JLabel("    Close");
		gotomain_Label.setBounds(64, 436, 68, 15);
		add(gotomain_Label);

	}

	private void toggleSetupPanel(boolean on_off) {
		this.setVisible(on_off);
	}

	public JButton getSetupBtn() {
		return setup_button;
	}
}