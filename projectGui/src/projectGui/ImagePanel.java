package projectGui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
//¿¬½À

public class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img=img;
		setSize(new Dimension(824, 461));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}

}
