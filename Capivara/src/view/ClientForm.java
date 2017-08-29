package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientForm extends JPanel implements VisualWindow {

	private JLabel name;
	private JTextField nameField;
	private JButton btName;

	public ClientForm() {
		setupLayout();
		setupComponents();
		setupEvents();
	}

	@Override
	public void setupLayout() {
		setLayout(null);
		setBackground(Color.GRAY);
		setVisible(true);
		setSize(800, 550);

	}

	@Override
	public void setupComponents() {
		name = new JLabel(" Nome ");
		nameField = new JTextField(100);
		btName = new JButton(" OK ");
		// inserindo os componentes no JPanel Register
		name.setBounds(20, 40, 100, 40);
		nameField.setBounds(80, 40, 150, 40);
		btName.setBounds(150, 100, 100, 100);

		add(name);
		add(nameField);
		add(btName);

	}

	 @Override
	 public void setupEvents() {
	 btName.addActionListener(new ActionListener() {
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
	 System.out.println("Nome digitado = "+nameField.getText());
	
	 }
	 });
	
	 }

	
}