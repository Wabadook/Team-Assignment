import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//Temp
	
	String[] races = {"Human", "Worgen", "Troll","Elf"};
	String[] classes = {"Warrior", "Mage", "Paladin", "Hunter"};
	JLabel lbltotalStatsLabel;
	JLabel lblStrLabel;
	int pointsToSpend = 10;
	int str = 0;
	
	
	//End temp
	
	
	public MainWindow() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel charSelectionPanel = new JPanel();
		charSelectionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(charSelectionPanel);
		charSelectionPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel raceSelectionPanel = new JPanel();
		charSelectionPanel.add(raceSelectionPanel);
		raceSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox raceComboBox_1 = new JComboBox(races);
		raceComboBox_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		raceSelectionPanel.add(raceComboBox_1);
		
		JButton btnRaceInfoButton = new JButton("i");
		raceSelectionPanel.add(btnRaceInfoButton);
		
		JPanel classSelectionPanel = new JPanel();
		charSelectionPanel.add(classSelectionPanel);
		classSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox classComboBox_1 = new JComboBox(classes);
		classComboBox_1.setBorder(new EmptyBorder(1, 0, 0, 0));
		classSelectionPanel.add(classComboBox_1);
		
		JButton btnClassInfoButton = new JButton("i");
		classSelectionPanel.add(btnClassInfoButton);
		
		JButton btnRandomizeButton = new JButton("Randomize");
		btnRandomizeButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRandomizeButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		charSelectionPanel.add(btnRandomizeButton);
		
		JPanel GenderPanel = new JPanel();
		contentPane.add(GenderPanel);
		
		JRadioButton rdbtnManButton = new JRadioButton("Man");
		GenderPanel.add(rdbtnManButton);
		
		JRadioButton rdbtnWomanButton = new JRadioButton("Woman");
		GenderPanel.add(rdbtnWomanButton);
		
		JPanel StatsPanel = new JPanel();
		contentPane.add(StatsPanel);
		StatsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel strPanel = new JPanel();
		StatsPanel.add(strPanel);
		strPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnStrDownButton = new JButton("-");
		btnStrDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pointsToSpend != 20 && str != 0) {
				str--;
				pointsToSpend++;
				lblStrLabel.setText("Str: " + str);
				lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		strPanel.add(btnStrDownButton);
		
		lblStrLabel = new JLabel("Str: " + str);
		lblStrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strPanel.add(lblStrLabel);
		
		JButton btnStrUpButton = new JButton("+");
		btnStrUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pointsToSpend > 0) {
				str++;
				pointsToSpend--;
				lblStrLabel.setText("Str: " + str);
				lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		strPanel.add(btnStrUpButton);
		
		JPanel wisPanel = new JPanel();
		StatsPanel.add(wisPanel);
		wisPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnWisDownButton = new JButton("-");
		wisPanel.add(btnWisDownButton);
		
		JLabel lblWisLabel = new JLabel("Wis: 10");
		lblWisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wisPanel.add(lblWisLabel);
		
		JButton btnWisUpButton = new JButton("+");
		wisPanel.add(btnWisUpButton);
		
		JPanel dexPanel = new JPanel();
		StatsPanel.add(dexPanel);
		dexPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnDexDownButton = new JButton("-");
		dexPanel.add(btnDexDownButton);
		
		JLabel lblDexLabel = new JLabel("Dex: 15");
		lblDexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dexPanel.add(lblDexLabel);
		
		JButton btnDexUpButton = new JButton("+");
		dexPanel.add(btnDexUpButton);
		
		JPanel intPanel = new JPanel();
		StatsPanel.add(intPanel);
		intPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnIntDownButton = new JButton("-");
		intPanel.add(btnIntDownButton);
		
		JLabel lblIntLabel = new JLabel("Int: 10");
		lblIntLabel.setHorizontalAlignment(SwingConstants.CENTER);
		intPanel.add(lblIntLabel);
		
		JButton btnIntUpButton = new JButton("+");
		intPanel.add(btnIntUpButton);
		
		JPanel conPanel = new JPanel();
		StatsPanel.add(conPanel);
		conPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnConDownButton = new JButton("-");
		conPanel.add(btnConDownButton);
		
		JLabel lblConLabel = new JLabel("Con: 10");
		lblConLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conPanel.add(lblConLabel);
		
		JButton btnConUpButton = new JButton("+");
		conPanel.add(btnConUpButton);
		
		//Best stat
		JPanel chaPanel = new JPanel();
		StatsPanel.add(chaPanel);
		chaPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnChaDownButton = new JButton("-");
		chaPanel.add(btnChaDownButton);
		
		JLabel lblChaLabel = new JLabel("Cha: 10");
		lblChaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chaPanel.add(lblChaLabel);
		
		JButton btnChaUpButton = new JButton("+");
		chaPanel.add(btnChaUpButton);
		
		lbltotalStatsLabel = new JLabel("Points: " + pointsToSpend);
		StatsPanel.add(lbltotalStatsLabel);
		

	
		
	}
}

