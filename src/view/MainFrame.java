package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constant.ComponentText;
import constant.Path;

public class MainFrame extends JFrame{
	
	public MainFrame(ActionListener listener) {
		super(ComponentText.TITLE_MAIN_FRAME);
		this.setLayout(new GridBagLayout());
		this.setSize(550,400);
		this.setMinimumSize(new Dimension(500, 400));
		this.setResizable(true);
	//	this.getContentPane().setBackground(AppColor.DARK_BLUE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource(Path.DATA_IMAGES_APP_ICON_PNG)).getImage());
		initsCompontents(listener);
		this.setVisible(true);
	}
	
	private void initsCompontents(ActionListener listener) {
		
	}

}
