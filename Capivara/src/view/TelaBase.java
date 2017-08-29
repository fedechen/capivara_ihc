package view;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class TelaBase extends JPanel{

	Tela1 t1;
	Tela2 t2;
	Tela3 t3;
	
	private MainFrame mainFrame;

	
	public TelaBase(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		
		setLayout(new CardLayout());
		t1 = new Tela1();
		t2 = new Tela2();
		t3 = new Tela3();
		
		add(t1, "t1");
		add(t2, "t2");
		add(t3, "t3");
	}
	
}
