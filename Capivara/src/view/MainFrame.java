package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class MainFrame extends JFrame implements VisualWindow {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem open1, open2, open3, close;
	private TelaBase base;
	private CardLayout cl;
	//private Register register; //controller básico

	public MainFrame() {
		setupLayout();
		setupComponents();
		setupEvents();

	}

	@Override
	public void setupLayout() {
		setSize(700, 700);
		setLayout(new BorderLayout());
		setVisible(true);
		// setdefault encerra a execução do sistema quando fechada a tela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void setupComponents() {

		menuBar = new JMenuBar();
		menu = new JMenu("File");
		open1 = new JMenuItem("Main");
		open2 = new JMenuItem("Monitoring");
		open3 = new JMenuItem(" ??? ");
		close = new JMenuItem("Close");
		menu.add(open1);
		menu.add(open2);
		menu.add(open3);
		menu.add(close);
		menuBar.add(menu);
		add(menuBar, BorderLayout.NORTH);

		// ------------------------------------
	//	register = new Register();
		// add(register, BorderLayout.CENTER);

		// -------------

		base = new TelaBase(this);
		cl = new CardLayout();
		cl = (CardLayout) base.getLayout();
		add(base, BorderLayout.CENTER);

	}

	@Override
	public void setupEvents() {
		open1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "t1");

			}
		});
		open2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "t2");

			}
		});
		open3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "t3");

			}
		});
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

	public void home() {
		cl.show(base, "t1");
	}

	private void repaintAll() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				repaint();

			}
		});
	}

}
