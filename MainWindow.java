import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

	// Temp

	String[] races = { "Human", "Worgen", "Troll", "Elf" };
	String[] classes = { "Warrior", "Mage", "Paladin", "Hunter" };
	JLabel lbltotalStatsLabel;
	JLabel lblStrLabel;
	JComboBox raceComboBox;
	JComboBox classComboBox;
	int pointsToSpend = 10;

	// Stats
	int str = 10;
	int wis = 8;
	int dex = 8;
	int intelligence = 5;
	int con = 10;
	int cha = 5;

	// Race, Class, Gender 
	static String characterClass = "Warrior";
	static String characterRace = "Human";
	static Boolean isFemale = false;

	// End temp

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

		raceComboBox = new JComboBox(races);
		raceComboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		raceSelectionPanel.add(raceComboBox);

		JButton btnRaceInfoButton = new JButton("i");
		btnRaceInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterRace = raceComboBox.getSelectedItem().toString();
				displayInfoFromComboBox(raceComboBox, false);
			}
		});
		raceSelectionPanel.add(btnRaceInfoButton);

		JPanel classSelectionPanel = new JPanel();
		charSelectionPanel.add(classSelectionPanel);
		classSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JComboBox classComboBox = new JComboBox(classes);
		classComboBox.setBorder(new EmptyBorder(1, 0, 0, 0));
		classSelectionPanel.add(classComboBox);

		JButton btnClassInfoButton = new JButton("i");
		btnClassInfoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				characterClass = classComboBox.getSelectedItem().toString();
				displayInfoFromComboBox(classComboBox, true);
			}
		});
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
				if (pointsToSpend != 20 && str != 0) {
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
				if (pointsToSpend > 0) {
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

		JLabel lblWisLabel = new JLabel("Wis: " + wis);
		lblWisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wisPanel.add(lblWisLabel);

		JButton btnWisUpButton = new JButton("+");
		wisPanel.add(btnWisUpButton);

		JPanel dexPanel = new JPanel();
		StatsPanel.add(dexPanel);
		dexPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnDexDownButton = new JButton("-");
		dexPanel.add(btnDexDownButton);

		JLabel lblDexLabel = new JLabel("Dex: " + dex);
		lblDexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dexPanel.add(lblDexLabel);

		JButton btnDexUpButton = new JButton("+");
		dexPanel.add(btnDexUpButton);

		JPanel intPanel = new JPanel();
		StatsPanel.add(intPanel);
		intPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnIntDownButton = new JButton("-");
		intPanel.add(btnIntDownButton);

		JLabel lblIntLabel = new JLabel("Int: " + intelligence);
		lblIntLabel.setHorizontalAlignment(SwingConstants.CENTER);
		intPanel.add(lblIntLabel);

		JButton btnIntUpButton = new JButton("+");
		intPanel.add(btnIntUpButton);

		JPanel conPanel = new JPanel();
		StatsPanel.add(conPanel);
		conPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnConDownButton = new JButton("-");
		conPanel.add(btnConDownButton);

		JLabel lblConLabel = new JLabel("Con: " + con);
		lblConLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conPanel.add(lblConLabel);

		JButton btnConUpButton = new JButton("+");
		conPanel.add(btnConUpButton);

		// Best stat
		JPanel chaPanel = new JPanel();
		StatsPanel.add(chaPanel);
		chaPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnChaDownButton = new JButton("-");
		chaPanel.add(btnChaDownButton);

		JLabel lblChaLabel = new JLabel("Cha: " + cha);
		lblChaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chaPanel.add(lblChaLabel);

		JButton btnChaUpButton = new JButton("+");
		chaPanel.add(btnChaUpButton);

		lbltotalStatsLabel = new JLabel("Points: " + pointsToSpend);
		StatsPanel.add(lbltotalStatsLabel);

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JButton btnCreateCharacterButton = new JButton("Create");
		btnCreateCharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> statsExport = new ArrayList<>();
				Collections.addAll(statsExport, str, wis, dex, intelligence, con, cha);
				//Create character Object
				Character newChar = new Character(characterClass, characterRace, str, wis, dex, intelligence, con, cha, isFemale);
				newChar.createCharacter();
			}
		});
		panel.add(btnCreateCharacterButton);

		JButton btnResetCharacterButton = new JButton("Reset");
		panel.add(btnResetCharacterButton);

	}

	private void displayInfoFromComboBox(JComboBox<?> box, Boolean isClass) {
		JOptionPane infoFrame = new JOptionPane();

		// Gets the race or class in the combobox and converts it to a string.
		String findDesc = box.getSelectedItem().toString();
		

		// Opens a window.
		displayInformation.getInformation(findDesc, isClass);

	}



}

