package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Tela1 extends JPanel implements VisualWindow {
	int valor = 0;
	NumberFormat format = NumberFormat.getIntegerInstance();
	JLabel time = new JLabel(" Time ");
	JLabel timeCount = new JLabel("00:00");
	Font font0 = new Font("Arial", Font.PLAIN, 20);
	Font font1 = new Font("Arial", Font.PLAIN, 25);
	Font font2 = new Font("Arial", Font.PLAIN, 40);
	Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
	
	JButton btReset = new JButton(" RESET ");
	JButton btStart = new JButton(" START ");
	JButton btStop = new JButton(" STOP ");
	JLabel capivaraTeam = new JLabel("Capivara Team");
	JLabel enemy = new JLabel(" Enemy ");
	JLabel capivaraGoals = new JLabel("00",SwingConstants.CENTER);
	JLabel enemyGoals = new JLabel("00",SwingConstants.CENTER);
	private Timer t;
	private long startTime = 0;
	JButton btStrtg1 = new JButton(" ESTRAT-1 ");
	JButton btStrtg2 = new JButton(" ESTRAT-2 ");
	JButton btStrtg3 = new JButton(" ESTRAT-3 ");
	JLabel speed1 = new JLabel("00",SwingConstants.CENTER);
	JLabel speed2 = new JLabel("00",SwingConstants.CENTER);
	JLabel speed3 = new JLabel("00",SwingConstants.CENTER);
	JLabel speed = new JLabel("speed");
	
	JProgressBar battery1 = new JProgressBar(SwingConstants.VERTICAL);
	JProgressBar battery2 = new JProgressBar(SwingConstants.VERTICAL);
	JProgressBar battery3 = new JProgressBar(SwingConstants.VERTICAL);
	
	
	
	
	public Tela1() {
		setupLayout();
		setupComponents();
		setupEvents();

	}

	@Override
	public void setupLayout() {
		setVisible(true);
		setLayout(null);

	}

	@Override
	public void setupComponents() {
		
		
		btStart.setBounds(50, 5, 140, 100);
		btStop.setBounds(500, 5, 140, 100);
		btStart.setFont(font0);
		btStop.setFont(font0);
		add(btStart);
		add(btStop);
		time.setFont(font1);
		time.setBounds(300, 5, 100, 45);
		add(time);
		timeCount.setBounds(290, 40, 160, 45);
		timeCount.setFont(font2);
		add(timeCount);

		capivaraTeam.setBounds(100, 120, 200, 45);
		enemy.setBounds(450, 120, 200, 45);
		capivaraTeam.setFont(font1);
		enemy.setFont(font1);
		add(capivaraTeam);
		add(enemy);

		capivaraGoals.setBounds(150, 170, 100, 60);
		enemyGoals.setBounds(470, 170, 100, 60);
		capivaraGoals.setFont(font2);
		capivaraGoals.setBorder(border);
		capivaraGoals.setBackground(Color.WHITE);
		capivaraGoals.setOpaque(true);
		enemyGoals.setBorder(border);
		enemyGoals.setBackground(Color.WHITE);
		enemyGoals.setOpaque(true);
		enemyGoals.setFont(font2);
		add(capivaraGoals);
		add(enemyGoals);
		btReset.setBounds(280, 240, 120, 60);
		btReset.setFont(font0);
		add(btReset);
		btStrtg1.setBounds(70, 350, 150, 45);
		btStrtg2.setBounds(270, 350, 150, 45);
		btStrtg3.setBounds(470, 350, 150, 45);
		btStrtg1.setFont(font0);
		btStrtg2.setFont(font0);
		btStrtg3.setFont(font0);
		btStrtg1.setBackground(Color.GREEN);// estrategia default
		add(btStrtg1);
		add(btStrtg2);
		add(btStrtg3);
		
		speed1.setBounds(110, 405, 70, 50);
		speed1.setFont(font2);
		speed1.setBorder(border);
		speed1.setBackground(Color.WHITE);
		speed1.setOpaque(true);
		speed2.setBounds(310, 405, 70, 50);
		speed2.setFont(font2);
		speed2.setBorder(border);
		speed2.setBackground(Color.WHITE);
		speed2.setOpaque(true);
		speed3.setBounds(510, 405, 70, 50);
		speed3.setFont(font2);
		speed3.setBorder(border);
		speed3.setBackground(Color.WHITE);
		speed3.setOpaque(true);
		add(speed1);
		add(speed2);
		add(speed3);
		speed.setFont(font0);
		speed.setForeground(Color.BLUE);
		speed.setBounds(610, 405, 100, 50);
		add(speed);
		
		battery1.setBounds(110, 460, 70, 100);
		battery1.setMaximum(100);
		battery1.setMinimum(0);
		battery1.setForeground(Color.GRAY);
		battery1.setValue(10);
		battery2.setBounds(310, 460, 70, 100);
		battery2.setMaximum(100);
		battery2.setMinimum(0);
		battery2.setForeground(Color.GRAY);
		battery2.setValue(60);
		battery3.setBounds(510, 460, 70, 100);
		battery3.setMaximum(100);
		battery3.setMinimum(0);
		battery3.setForeground(Color.GRAY);
		battery3.setValue(77);
		add(battery1);
		add(battery2);
		add(battery3);
		
		
		//draw(getGraphics(), 120, 600);
		// inicializando o timer
		initTimer();
	}

	private void initTimer() {
		t = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
				long currentTime = System.currentTimeMillis();
				timeCount.setText(sdf.format(currentTime - startTime));

			}
		});
	}

	@Override
	public void setupEvents() {
		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "start OK");

			}
		});

		btStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "STOP OK");

			}
		});

		btReset.addActionListener(new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent e) {
                valor++;
                				
				startTime = System.currentTimeMillis();

				if (t.isRunning()) {
					t.restart();
					
				} else {
					t.start();
					
				}
				capivaraGoals.setText(format.format(0));
				enemyGoals.setText(format.format(0));
			}
		});

		btStrtg1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ATAQUE");
				setButtonSTRATEGYColor(1);
			}
		});
		btStrtg2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "DEFESA");
				setButtonSTRATEGYColor(2);
			}
		});
		btStrtg3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "VACA-LOCA");
				setButtonSTRATEGYColor(3);
			}
		});

	}
	
	public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 10, 10);

        g2d.setColor(Color.GRAY);
        g2d.fill(circle);
    }
	
	public void drawCircleByCenter(Graphics g, int x, int y, int radius){
        //g.setColor(Color.LIGHT_GRAY);
        g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
    }
	
//id = 1 para gol da capivara
//id = 2 para gol do rival	
	public void setGoals(int id){
		if(id == 1){
			int gols = Integer.parseInt(capivaraGoals.getText());
			gols++;
			capivaraGoals.setText(format.format(gols));
		}
		if(id == 2){
			int gols = Integer.parseInt(enemyGoals.getText());
			gols++;
			enemyGoals.setText(format.format(gols));
		}
		
	}
	public void setButtonSTRATEGYColor(int id) {
		switch (id) {
		case 1:
			btStrtg1.setBackground(Color.GREEN);
			btStrtg2.setBackground(null);
			btStrtg3.setBackground(null);
			break;
		case 2:
			btStrtg1.setBackground(null);
			btStrtg2.setBackground(Color.GREEN);
			btStrtg3.setBackground(null);
			break;
		case 3:
			btStrtg1.setBackground(null);
			btStrtg2.setBackground(null);
			btStrtg3.setBackground(Color.GREEN);
			break;
		default:
			btStrtg1.setBackground(Color.GREEN);
			btStrtg2.setBackground(null);
			btStrtg3.setBackground(null);
			break;
		}
	}

}
