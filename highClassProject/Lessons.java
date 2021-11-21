package highClassProject;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.tools.javac.Main;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Lessons {

	private JFrame frame;
	//private final JPanel pnSearch_main = new JPanel();
	private PnSearch_main pnSearch_main = new PnSearch_main();
	private JTable tbCtris;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lessons window = new Lessons();
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
	public Lessons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lessions");
		frame.setBounds(0, 0, 840, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PnMain pnMain = new PnMain();
		PnSetup pnSetup = new PnSetup();
		
		JButton setup_Button = new JButton("");
		setup_Button.setForeground(Color.WHITE);
		setup_Button.setIcon(new ImageIcon("./Images/btStup2.PNG"));
		setup_Button.setBorderPainted(false);
		setup_Button.setBounds(741, 10, 59, 57);
		setup_Button.setVisible(true);
		
		frame.getContentPane().add(pnMain);
		frame.getContentPane().add(pnSetup);
		frame.getContentPane().add(setup_Button);
		
		JLayeredPane jlp = frame.getLayeredPane();
		
		jlp.add(pnMain, JLayeredPane.DEFAULT_LAYER);
		jlp.add(setup_Button, JLayeredPane.PALETTE_LAYER);
		jlp.add(pnSetup, JLayeredPane.MODAL_LAYER);
		
		pnMain.setVisible(true);
		
		setup_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pnSetup.setVisible(true);
				
				
			}

			
		});
		
	}
}
