package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Enums.ImageManager;

//설정패널
public class SetupPage extends JPanel {

	private JComboBox language_setup; //언어 선택 콤보박스
	private JComboBox fontsize_setup; //폰트사이즈 콤보박스
	private static JButton setup_button; //메인으로 돌아가는 버튼

	public SetupPage() {
		setFrame();
		defineSetupComponents();
	}

	private void setFrame() {
		setVisible(false);
		setBounds(0, 0, 824, 461);
		setLayout(null);
	}

	private void defineSetupComponents() {
		/**
		* 설정 컴포넌트는 따로 컨테이너를 정의해서 구조화시킬 필요가 있음.
		 */
		//언어선택 콤보박스
		language_setup = new JComboBox();
		language_setup.setBounds(260, 50, 480, 35);

		//폰트사이즈 콤보박스
		fontsize_setup = new JComboBox();
		fontsize_setup.setBounds(260, 130, 480, 35);

		JLabel language_Label = new JLabel("Language");
		language_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		language_Label.setBounds(140, 50, 90, 35);

		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);

		JLabel gotomain_Label = new JLabel("    Close");
		gotomain_Label.setBounds(64, 436, 68, 15);

		//설정창 키고끄는 버튼
		setup_button = new JButton("");
		setup_button.setIcon(ImageManager.TOGGLE_SETUP.getIcon());
		setup_button.setVisible(true);
		setup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSetupPanel();
			}
		});

		add(language_setup);
		add(fontsize_setup);
		add(setup_button);
		add(language_Label);
		add(fontsize_Label);
		add(gotomain_Label);
	}

	private void toggleSetupPanel() {
		this.setVisible(!setup_button.isVisible());
	}

	//설정창을 여는 버튼 생성 및 반환
	public JButton getSetupButton() {
		return setup_button;
	}
}