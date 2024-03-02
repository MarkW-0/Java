/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.chooseyourownadventurewaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class ChooseYourOwnAdventureWaterman {
	private final static class Page {
		final String TITLE;
		final String[] CHOICENAMES;
		final Page[] CHOICEPAGES;
		final String[] TEXT;
		Page(String title, String[] choiceNames, String[] text){
			this.TITLE = title;
			this.CHOICENAMES = choiceNames;
			this.CHOICEPAGES = new Page[choiceNames.length];
			this.TEXT = text;
		}
	}
	private final static Page[] PAGES = {// <editor-fold defaultstate="collapsed" desc="PAGES">
		new Page("A Battle in the sky", new String[]{"Start Adventure", "Quit"}, new String[]{
			"A Choose Your Own Adventure",
			"Text-Based Game",
			"By Mark Waterman",
			"",
			"Type in a number and hit enter to choose"
		}),
		new Page("KABOOM", new String[]{"Head underground", "Head to the jump control room"}, new String[]{
			"You wake up to a roar of fire.",
			"The alarms trigger, and the computer warns “a Star Cruiser has entered this area”.",
			"You look outside and see a battleship arriving",
			"If you are quick, you can run to the underground bunker, or you can run to jump pads"
		}),
		new Page("The Bunker, the Weapons, and the Core", new String[]{"Enter the bunker", "Get ready to fight", "Detonate the Core"}, new String[]{
			"deep inside the asteroid",
			"You find the tools you need to defend yourself",
			"The bunker in which you can survive this battle",
			"With these plasma drills, you can fight!",
			"However if you invert the tachyon flux in the Core, then you can vaporise this menace!"
		}),
		new Page("In the Bunker", new String[]{}, new String[]{
			"“This bunker is indestructible.",
			"Nothing apart from a positron ray,",
			"Supernova or vacuum collapse will destroy it”",
			"However, the asteroid shakes,",
			"and you think of other weaknesses",
			"until you've lost hope, the bunker is broken, and you succumb to the war."
		}),
		new Page("The First Battle", new String[]{}, new String[]{
			"With your plasma drills mounted, you fly your mining ship to battle.",
			"With your turbo boosted thrusters, and experimental plasma controller,",
			"you flew by the Star Cruiser, sending waves of plasma along its shields.",
			"However, even with these custom modifications, you cannot fight against a ship with a hundred guns.",
			"Each gun you fry, 2 more turn to you.",
			"When you have tried to break another dozen, you get finally hit.",
			"With your plasma down, you flee.",
			"You finally escape to the Sky City,",
			"where they award you the Medal of True Bravery for your help with fighting that vessel of war."
		}),
		new Page("Core Detonation", new String[]{"Continue"}, new String[]{
			"“A Warp Core is a simple device. it simply releases tachyons which disassembles your ship here,",
			"and reassembles your ship there.",
			"If you invert the tachyon flow though, it will disassemble your ship there and build it here,",
			"in which you will have a self intersecting ship.",
			"Kaboom”.",
			"You carefully reflect the tachyons off the positron reflector and the positrons off the tachyon reflector,",
			"and hope nothing immediately goes wrong."
		}),
		new Page("The Artificial Star", new String[]{}, new String[]{
			"All the civilizations the Sky Nations have found have harnessed less then a hundered petawatts.",
			"However You've just made a trillion petawatt reaction!",
			"The power of a Artificial Star!",
			"...",
			"Wow!",
			"...",
			"By the way, You're dead."
		}),
		new Page("Jump Controls", new String[]{"Jump to the Sky City", "Jump to the Star Cruiser"}, new String[]{
			"As you run to the jump pad your computer tells you ",
			"“",
			"  There are currently two jump trajectories available:",
			"    The Sky City (Capital of the Sky Nations and currently holding the Sky Council)",
			"    And the Star Cruiser (Has satus of [Advancing on the foul enemies of The High and Mighty Star Empire of The Most Excellent Most Powerful Emperor of The Suns Master of The Moons Ruler of All The Star God])",
			"”",
			"The Sky City has longer range jump pads and the Sky Council might know whats happened",
			"However this “Star Empire” don't know we can jump on board and sabotage them"
		}),
		new Page("The Sky City", new String[]{"Void end","Avoid the draft","Enlist yourself","Sky council"}, new String[]{
			"The sky city is tense, You might be able to use their jump equipment to get out of this warzone,",
			"or you can try to avoid getting drafted, actively enlist, or try to sneak into the council chambers"
		}),
		new Page("The Final Destination", new String[]{}, new String[]{
			"You activate the jump pad and...",
			"...", "...", "...",
			"“Oh no”",
			"...", "...", "...",
			"“This”",
			"...",
			"“Is”",
			"...", "...",
			"“The”",
			"...", "...", "...",
			"“Void”",
			"...", "...", "...", "...",
		}),
		new Page("Avoid the draft", new String[]{}, new String[]{
			"You try hard to avoid the draft by hiding with your cousins,",
			"however the recruitment officer finds you.",
			"You end up at a cold wet watchpost in the far corner of the sector."
		}),
		new Page("Modern Major General", new String[]{}, new String[]{
			"You are the very model of a modern major general!",
			"You quickly rise up the ranks, and win great battles,",
			"and enjoy relaxing on the beach of bones of your enemies"
		}),
		new Page("The Star Cruiser", new String[]{"Jump back","Sabotage","Fight for freedom","Head to the bridge"}, new String[]{
			"The star cruiser is run by the men of red and gold, a species of massacre",
			"You can jump back and try to avoid their blood lust,",
			"you can steal one of their suits and sabotage this ship,",
			"grab their blasters and fight for the freedom of the Sky Nations,",
			"or try to sneak to the bridge and find out why they are going to war"
		}),
		new Page("Sabotage", new String[]{"Sabotage the core", "Sabotage the shields"}, new String[]{
			"You grab one of their suits, and squeeze inside.",
			"Their uncomfortable suit forces you to march down to the engineering rooms.",
			"Here you can either sabotage the core, or sabotage the shields"
		}),
		new Page("In the Brig", new String[]{}, new String[]{
			"As you sneak behind a patrol, they all turn and look at you.",
			"You try your best, but you are no match for 12 armed men.",
			"They grab you, taser you, and drag you to the brig.",
			"You get locked in the brig, fed gruel, and then sent to harvest salt from an arrid world."
		}),
		new Page("A Visit With the Star God", new String[]{"Continue"}, new String[]{
			"At the top of he ship, you find yourself in front of a gold-plated door.",
			"Inside, you find yourself with a dozen generals, looking over a holo-map of the galaxy.",
			"Behind them, on a gold throne, their captain, the Star God sits.",
			"He says “Hmmmmmmm. My brother has not prepared for this.",
			"And to think it all started when Sky and I found that shattered gem...”"
		}),
		new Page("A Visit With the Sky Council", new String[]{"Continue"}, new String[]{
			"As you enter the council chamber, Sky invites you in. ",
			"“And here comes the final councilor, coming from his lab in the heart of the top university.",
			"He too must hear the tale of when Star and I found that shattered gem...”"
		}),
		new Page("The Story of Star & Sky", new String[]{}, new String[]{
			"“... shattered gem. We returned to out home with this enigma,",
			"and worked for years to unravel its secrets.”",
			"“One morning, we found the shattered gem floating, reassembled, and glowing!",
			"My brother and I quickly learned, through its power.”",
			"“Its power showed us solutions to nature's hardest questions,",
			"we learned the art of immortality, and discovered how to make men move galaxies.”",
			"“But then, when we learned so much, we forgot how to be brothers.",
			"After a fight, of heated words and burning planets, we parted ways,",
			"vowing to never use this power with our bare hands.”",
			"“However, recently, my brother started using this strength,",
			"and we must be ready for whatever he does with it.”"
		}),
		new Page("The Hidden chapter", new String[]{}, new String[]{
			"What have you found here?"
		})
		// </editor-fold>
	};
	static {
		PAGES[0].CHOICEPAGES[0] = PAGES[1];
		PAGES[1].CHOICEPAGES[0] = PAGES[2];
		PAGES[1].CHOICEPAGES[1] = PAGES[7];
		PAGES[2].CHOICEPAGES[0] = PAGES[3];
		PAGES[2].CHOICEPAGES[1] = PAGES[4];
		PAGES[2].CHOICEPAGES[2] = PAGES[5];
		PAGES[5].CHOICEPAGES[0] = PAGES[6];
		PAGES[7].CHOICEPAGES[0] = PAGES[8];
		PAGES[7].CHOICEPAGES[1] = PAGES[12];
		PAGES[8].CHOICEPAGES[0] = PAGES[9];
		PAGES[8].CHOICEPAGES[1] = PAGES[10];
		PAGES[8].CHOICEPAGES[2] = PAGES[11];
		PAGES[8].CHOICEPAGES[3] = PAGES[16];
		PAGES[12].CHOICEPAGES[0] = PAGES[9];
		PAGES[12].CHOICEPAGES[1] = PAGES[13];
		PAGES[12].CHOICEPAGES[2] = PAGES[14];
		PAGES[12].CHOICEPAGES[3] = PAGES[15];
		PAGES[13].CHOICEPAGES[0] = PAGES[5];
		PAGES[13].CHOICEPAGES[1] = PAGES[14];
		PAGES[15].CHOICEPAGES[0] = PAGES[17];
		PAGES[16].CHOICEPAGES[0] = PAGES[17];
	}
	private final static Scanner INPUT = new Scanner(System.in);
	private static Page page = PAGES[0];
	private static void newline() {
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	public static void main(String[] args) {
		while(true){
			System.out.print(page.TITLE);
			newline();
			newline();
			for (var arg : page.TEXT) {
				System.out.print(arg);
				newline();
			}
			if(page.CHOICENAMES.length == 0){
				System.out.print("Type in 0 to retun to title page");
				newline();
				page = PAGES[INPUT.nextInt()];
			}else if(page.CHOICENAMES.length == 1){
				System.out.print("Type in 0 to continue");
				newline();
				page = page.CHOICEPAGES[INPUT.nextInt()];
			}else{
				System.out.print("Do you:");
				newline();
				for (int i = 1; i <= page.CHOICENAMES.length; i++) {
					System.out.print("(" + i + "): ");
					System.out.print(page.CHOICENAMES[i - 1]);
					newline();
				}
				page = page.CHOICEPAGES[INPUT.nextInt() - 1];
			}
		}
	}
}
