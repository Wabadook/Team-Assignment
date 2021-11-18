import java.util.HashMap;

import javax.swing.JOptionPane;

public class displayInformation {

	// Race Desc
	static String trollDesc = "This is a troll. They have long intimidating tusks. They are masterful warriors and scouts.";
	static String humanDesc = "This is a human, the most versitile of all races. A relatively young race, they've yet to find their place in the wider world.";
	static String elfDesc = "This is an elf. The oldest of races they've mastered the arcane arts. While they're relatively weak of constitution a few elves have been known to break that convention";
	static String worgenDesc = "This is a worgen. Their fury is unbridled. However, those that can tame their fury make excellent hunters.";

	// Class Desc
	static String mageDesc = "Mages cast spells.";
	static String hunterDesc = "Hunters use animals and guns. Also they kite like pansies.";
	static String paladinDesc = "Best class. Uses hammers.";
	static String warriorDesc = "Okay class.";


	
	/**
	 * Finds class or race description
	 * 
	 * @param input   class or race to retrieve
	 * @param isClass true to pull class info, false to pull race info
	 */
	public static void getInformation(String input, Boolean isClass) {

		// HashMap of Races
		HashMap<String, String> raceSet = new HashMap<>();
		raceSet.put("Troll", trollDesc);
		raceSet.put("Human", humanDesc);
		raceSet.put("Elf", elfDesc);
		raceSet.put("Worgen", worgenDesc);

		// HasMap of Classes
		HashMap<String, String> classSet = new HashMap<>();
		classSet.put("Mage", mageDesc);
		classSet.put("Hunter", hunterDesc);
		classSet.put("Paladin", paladinDesc);
		classSet.put("Warrior", warriorDesc);

		String output = "";

		if (isClass == false) {
			output = raceSet.get(input);
		}

		if (isClass == true) {
			output = classSet.get(input);
		}

		displayInformationWindow(output);
	}
	
	public static void displayInformationWindow(String input) {
		JOptionPane infoFrame = new JOptionPane();
		JOptionPane.showMessageDialog(infoFrame, input);
	}

	

}
