package projectGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Setup_Panel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setup_Panel window = new Setup_Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Setup_Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel setup_Panel = new JPanel();
		setup_Panel.setBounds(0, 0, 824, 461);
		frame.getContentPane().add(setup_Panel);
		setup_Panel.setLayout(null);
		
		JComboBox language_Combobox = new JComboBox();
		language_Combobox.setBounds(260, 50, 480, 35);
		setup_Panel.add(language_Combobox);
		
		JLabel language_Label = new JLabel("Language");
		language_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		language_Label.setBounds(140, 50, 90, 35);
		setup_Panel.add(language_Label);
		
		JComboBox fontsize_Combobox = new JComboBox();
		fontsize_Combobox.setBounds(260, 130, 480, 35);
		setup_Panel.add(fontsize_Combobox);
		
		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);
		setup_Panel.add(fontsize_Label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\home_icon.jpg"));
		btnNewButton.setBounds(70, 380, 45, 45);
		setup_Panel.add(btnNewButton);
		
		JLabel gotomain_Label = new JLabel("Goto_Main");
		gotomain_Label.setBounds(64, 436, 68, 15);
		setup_Panel.add(gotomain_Label);
	}

}
