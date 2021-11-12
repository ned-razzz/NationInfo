package Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonListener implements ActionListener{
	Controller controller = new Controller();
	
	/*
	public ButtonListener(Controller c) {
		controller = c;
	}
	*/
	
	public void actionPerformed(ActionEvent event) {
		//event
		controller.search();
	}
	
	//temporary
	public void actionPerformed() {
		controller.search();
	}
	
	public void pushButton() {
		this.actionPerformed();
	}
}
