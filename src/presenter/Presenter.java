package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

public class Presenter implements ActionListener{
	
	private MainFrame view;
	
	public Presenter() {
		view = new MainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Defualt":
			
			break;

		default:
			break;
		}
		
	}

}
