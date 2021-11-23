package dnDCharacterCreator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
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
import java.awt.Font;

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

	String[] races = { "Human", "Orge", "Troll", "Worgen" };
	String[] classes = { "Warrior", "Mage", "Hunter" };
	JLabel lbltotalStatsLabel;
	JLabel lblStrLabel;
	JComboBox raceComboBox;
	JComboBox classComboBox;
	JPanel charSelectionPanel;
	JPanel controlPanel;
	int pointsToSpend = 10;

	// Stats
	int str = 10;
	int wis = 8;
	int dex = 8;
	int intelligence = 5;
	int con = 10;
	int cha = 5;
	
	int counter = 0;
	int nuCounter = 0;

	// Race, Class, Gender
	static String characterClass = "Warrior";
	static String characterRace = "Human";
	static Boolean isFemale = false;

	ButtonGroup genderGroup = new ButtonGroup();
	private JPanel displayPanel;

	// End temp

	public MainWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		displayPanel = new ChangingImgsPanel();
		contentPane.add(displayPanel);

		controlPanel = createControlPanel();

	}

	private JPanel createCharSelectionPanel(JPanel controlPanel) {
		charSelectionPanel = new JPanel();
		charSelectionPanel.setPreferredSize(new Dimension(250, 110));
		charSelectionPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
		controlPanel.add(charSelectionPanel);
		charSelectionPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel raceSelectionPanel = raceSelectionPanel();

		JPanel classSelectionPanel = createClassSelectionPanel();

		JButton btnRandomizeButton = new JButton("Randomize");
		btnRandomizeButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRandomizeButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRandomizeButton.setBorder(new EmptyBorder(10, 10, 10, 10));
		charSelectionPanel.add(btnRandomizeButton);

		return charSelectionPanel;
	}

       /**
	* Change the class(body) depending on which choice of the dropbox the user selected (Added backstage logic).
	*/
	private JPanel createClassSelectionPanel() {
		JPanel classSelectionPanel = new JPanel();
		charSelectionPanel.add(classSelectionPanel);
		classSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JComboBox classComboBox = new JComboBox(classes);
		classComboBox.setBorder(new EmptyBorder(1, 0, 0, 0));
		classComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterClass = classComboBox.getSelectedItem().toString();
				
				if (characterClass == "Warrior")
					((ChangingImgsPanel) displayPanel).changeBody(0);
				else if (characterClass == "Mage")
					((ChangingImgsPanel) displayPanel).changeBody(1);
				else if (characterClass == "Hunter")
					((ChangingImgsPanel) displayPanel).changeBody(2);
				
			}
		});
		classSelectionPanel.add(classComboBox);

		JButton btnClassInfoButton = new JButton("i");
		btnClassInfoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				characterClass = classComboBox.getSelectedItem().toString();
				displayInfoFromComboBox(classComboBox, true);
			}
		});
		classSelectionPanel.add(btnClassInfoButton);

		return classSelectionPanel;
	}

       /**
	* Changes the the race(head) depending on which choice of the dropbox the user selected. Also assign the counter with an according number 
	* for the changes of gender on the createGenderPanel method (Add backstage logic).
	*/
	private JPanel raceSelectionPanel() {
		JPanel raceSelectionPanel = new JPanel();
		charSelectionPanel.add(raceSelectionPanel);
		raceSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		raceComboBox = new JComboBox(races);
		raceComboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		raceComboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				characterRace = raceComboBox.getSelectedItem().toString();
				
				
				if (characterRace == "Human" && isFemale == false) {
					counter = 0;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Human" && isFemale == true) {
					counter = 1;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
					
				else if (characterRace == "Orge" && isFemale == false) {
					counter = 2;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Orge" && isFemale == true) {
					counter = 3;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
					
				else if (characterRace == "Troll" && isFemale == false) {
					counter = 4;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Troll" && isFemale == true) {
					counter = 5;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Worgen" && isFemale == false) {
					counter = 6;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
					
				else if (characterRace == "Worgen" && isFemale == true) {
					counter = 7;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
					
			}
		});
		raceSelectionPanel.add(raceComboBox);

		JButton btnRaceInfoButton = new JButton("i");
		btnRaceInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterRace = raceComboBox.getSelectedItem().toString();
				displayInfoFromComboBox(raceComboBox, false);
			}
		});
		raceSelectionPanel.add(btnRaceInfoButton);

		return raceSelectionPanel;
	}
	
       /**
	* Check if the character is a female, if not, decrease the counter by one to display male version of the race (See DisplayImgsPanel.java).
	* Else increase the counter by one to display the female version of the race (Added backstage logic). 
	*/
	private JPanel createGenderPanel() {
		JPanel GenderPanel = new JPanel();
		GenderPanel.setPreferredSize(new Dimension(200, 30));
		
		controlPanel.add(GenderPanel);
		
		JRadioButton rdbtnManButton = new JRadioButton("Man");
		genderGroup.add(rdbtnManButton);
		GenderPanel.add(rdbtnManButton);
		
		JRadioButton rdbtnWomanButton = new JRadioButton("Woman");
		genderGroup.add(rdbtnWomanButton);
		GenderPanel.add(rdbtnWomanButton);
	
		rdbtnManButton.setSelected(true);
		
		rdbtnManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFemale == true) {
					isFemale = false;
					counter-=1;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
			}
		});
		
		rdbtnWomanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFemale == false) {
					isFemale = true;
					counter+=1;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
			}
		});
		

		return GenderPanel;
	}

	private JPanel createStatsPanel() {
		JPanel StatsPanel = new JPanel();
		StatsPanel.setPreferredSize(new Dimension(275, 100));
		controlPanel.add(StatsPanel);
		StatsPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel strPanel = new JPanel();
		StatsPanel.add(strPanel);
		strPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnStrDownButton = new JButton("-");
		btnStrDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (str > 0) {
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
				// raiseOrLowerStat(str, "Str", lblStrLabel, true);
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
		lbltotalStatsLabel.setPreferredSize(new Dimension(100, 14));
		StatsPanel.add(lbltotalStatsLabel);

		return StatsPanel;
	}

	private JPanel createCharacterResetPanel() {
		JPanel createCharacterResetPanel = new JPanel();
		controlPanel.add(createCharacterResetPanel);

		JButton btnCreateCharacterButton = new JButton("Create");
		btnCreateCharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create character Object
				System.out.println(characterClass);
				System.out.println(characterRace);
				Character newChar = new Character(characterClass, characterRace, str, wis, dex, intelligence, con, cha,
						isFemale);
				newChar.createCharacter();
			}
		});
		createCharacterResetPanel.add(btnCreateCharacterButton);

		JButton btnResetCharacterButton = new JButton("Reset");
		createCharacterResetPanel.add(btnResetCharacterButton);

		return createCharacterResetPanel;
	}

	private JPanel createControlPanel() {
		controlPanel = new JPanel();
		contentPane.add(controlPanel);

		JPanel charSelectionPanel = createCharSelectionPanel(controlPanel);

		JPanel GenderPanel = createGenderPanel();

		JPanel StatsPanel = createStatsPanel();

		JPanel createCharacterResetPanel = createCharacterResetPanel();

		return controlPanel;
	}

	/**
	 * Displays class/race info in a new window.
	 * 
	 * @param box     Combo box to pull information from.
	 * @param isClass True if class, false if race.
	 */
	private void displayInfoFromComboBox(JComboBox<?> box, Boolean isClass) {

		// Gets the race or class in the combobox and converts it to a string.
		String findDesc = box.getSelectedItem().toString();

		// Opens a window.
		try {
			DisplayInformation.getInformation(findDesc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Raises or lowers a characters stat and updates the main window.
	 * 
	 * @param stat    Stat to be raised or lowered
	 * @param label   Label associated with stat.
	 * @param toRaise True if raising, false if lowering.
	 */
	private void raiseOrLowerStat(int stat, String statName, JLabel label, Boolean toRaise) {

		if (toRaise == true) {
			if (pointsToSpend > 0) {
				stat++;
				System.out.println("Setting " + stat);
				pointsToSpend--;
				label.setText(statName + ": " + stat);
				System.out.println("Attempting to set text for " + label.getText());
				lbltotalStatsLabel.setText("Points: " + pointsToSpend);
			}
		}
		if (toRaise == false) {
			if (stat > 0) {
				stat--;
				pointsToSpend++;
				label.setText(statName + ": " + stat);
				lbltotalStatsLabel.setText("Points: " + pointsToSpend);
			}
		}
	}

}