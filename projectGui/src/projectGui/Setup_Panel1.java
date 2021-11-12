package projectGui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class Setup_Panel1 extends JPanel{
	public JButton gotomain_Button;
	public JComboBox language_Combobox;
	public JComboBox fontsize_Combobox;
	public JLabel language_Label;
	public JLabel fontsize_Label;
	public JLabel gotomain_Label;
	
	Setup_Panel1(){
		
		setSize(new Dimension(824,461));
		setPreferredSize(new Dimension(824,461));
		
		JPanel setup_Panel = new JPanel();
		setup_Panel.setBounds(0, 0, 824, 461);
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
		
		JButton gotomain_Button = new JButton("");
		gotomain_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\home_icon.jpg"));
		gotomain_Button.setBounds(70, 380, 45, 45);
		
		setup_Panel.add(gotomain_Button);
		
		JLabel gotomain_Label = new JLabel("Goto_Main");
		gotomain_Label.setBounds(64, 436, 68, 15);
		setup_Panel.add(gotomain_Label);
		
		gotomain_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//main_Panel.setVisible(true);
				setup_Panel.setVisible(false);
			}
		});

		
	}
	
	

}

