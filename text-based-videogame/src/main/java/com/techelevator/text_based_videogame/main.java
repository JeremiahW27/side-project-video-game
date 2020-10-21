package com.techelevator.text_based_videogame;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		Slime slime = new Slime();
		Goblin goblin = new Goblin();
		Wolf wolf = new Wolf();
		Bear bear = new Bear();
		Troll troll = new Troll();
		Minotaur minotaur = new Minotaur();
		AttackItem weapon = new AttackItem();
		
		//Game Variables
		Object[] enemies = {slime, goblin, wolf, bear, troll, minotaur};
		
		//Player Variables
		int playerScore = 0;
		int playerHp = 100;
		int playerAtt = 10;
		int weaponBuff = 0;
		int armorBuff = 0;
		Object currentWeapon = "";
		Object currentArmor = "";
		
		//Health Potion
		int numHealthPots = 3;
		int healthPotHealAmount = 20;
		int healthPotDropChance = 0;
		
		//Rusty Sword
		int rustySwordDropChance = 0;
		int numOfRustySwords = 0;
		boolean doesHaveRustySword = false;
		
		boolean running = true;
		
		List<String> inv = new ArrayList<String>();
		
		System.out.println(" _________  ___   ___   ________   __       ___ __ __    ________  ______    ______   ___   ______       ______   ________   __   __   ______      ");
		System.out.println("/________/\\/__/\\ /__/\\ /_______/\\ /_/\\     /__//_//_/\\  /_______/\\/_____/\\  /_____/\\ /__/\\ /_____/\\     /_____/\\ /_______/\\ /_/\\ /_/\\ /_____/\\     ");
		System.out.println("\\__.::.__\\/\\::\\ \\\\  \\ \\\\::: _  \\ \\\\:\\ \\    \\::\\| \\| \\ \\ \\__.::._\\/\\:::_ \\ \\ \\:::_ \\ \\\\::\\ \\\\::::_\\/_    \\:::__\\/ \\::: _  \\ \\\\:\\ \\\\ \\ \\\\::::_\\/_    ");
		System.out.println("   \\::\\ \\   \\::\\/_\\ .\\ \\\\::(_)  \\ \\\\:\\ \\    \\:.      \\ \\   \\::\\ \\  \\:(_) ) )_\\:\\ \\ \\ \\\\:_\\/ \\:\\/___/\\    \\:\\ \\  __\\::(_)  \\ \\\\:\\ \\\\ \\ \\\\:\\/___/\\   ");
		System.out.println("    \\::\\ \\   \\:: ___::\\ \\\\:: __  \\ \\\\:\\ \\____\\:.\\-/\\  \\ \\  _\\::\\ \\__\\: __ `\\ \\\\:\\ \\ \\ \\      \\_::._\\:\\    \\:\\ \\/_/\\\\:: __  \\ \\\\:\\_/.:\\ \\\\::___\\/_  ");
		System.out.println("     \\::\\ \\   \\: \\ \\\\::\\ \\\\:.\\ \\  \\ \\\\:\\/___/\\\\. \\  \\  \\ \\/__\\::\\__/\\\\ \\ `\\ \\ \\\\:\\_\\ \\ \\       /____\\:\\    \\:\\_\\ \\ \\\\:.\\ \\  \\ \\\\ ..::/ / \\:\\____/\\ ");
		System.out.println("      \\__\\/    \\__\\/ \\::\\/ \\__\\/\\__\\/ \\_____\\/ \\__\\/ \\__\\/\\________\\/ \\_\\/ \\_\\/ \\_____\\/       \\_____\\/     \\_____\\/ \\__\\/\\__\\/ \\___/_(   \\_____\\/ ");
		System.out.println("                                                                                                                                                   ");
		
		
		GAME:
		while(running) {
			System.out.println("___________________________________________________________________________________________________________________________________________________");
			System.out.println();
			
			Object enemyType = enemies[rand.nextInt(enemies.length - 1)];
			String enemy = "";
			int enemyHp = 0;
			
			if(enemyType.equals(slime)) {
				enemy = "slime";
				enemyHp = slime.getHp();
				healthPotDropChance = 25;
				rustySwordDropChance = 35;
			}
			else if(enemyType.equals(goblin)) {
				enemy = "goblin";
				enemyHp = goblin.getHp();
				healthPotDropChance = 25;
			}
			else if(enemyType.equals(wolf)) {
				enemy = "wolf";
				enemyHp = wolf.getHp();
				healthPotDropChance = 50;
			}
			else if(enemyType.equals(bear)) {
				enemy = "bear";
				enemyHp = bear.getHp();
				healthPotDropChance = 50;
			}
			else if(enemyType.equals(troll)) {
				enemy = "troll";
				enemyHp = troll.getHp();
				healthPotDropChance = 75;
			}
			else if(enemyType.equals(minotaur)) {
				enemy = "minotaur";
				enemyHp = minotaur.getHp();
				healthPotDropChance = 75;
			}
			
			System.out.println("\t# A " + enemy + " has appeared. #\n");
			
			while(enemyHp > 0) {
				
				if(currentWeapon.equals("rusty sword")) {
					weaponBuff = weapon.rustySwordBoost();
				}
				
				playerHp = playerHp + armorBuff;
				System.out.println("\tYour HP: " + playerHp);
				System.out.println("\t" + enemy + "'s HP: " + enemyHp);
				System.out.println();
				System.out.println("\tWhat would you like to do?");
				System.out.println("\t1. Attack.");
				System.out.println("\t2. Drink health potion.");
				System.out.println("\t3. Run.");
				System.out.println("\t4. Access Inventory");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(playerAtt + weaponBuff);
					int damageTaken = 0;
					if(enemy.equals("slime")) {
						damageTaken = rand.nextInt(slime.getAtt());
					}
					else if(enemy.equals("goblin")) {
						damageTaken = rand.nextInt(goblin.getAtt());
					}
					else if(enemy.equals("wolf")) {
						damageTaken = rand.nextInt(wolf.getAtt());
					}
					else if(enemy.equals("bear")) {
						damageTaken = rand.nextInt(bear.getAtt());
					}
					else if(enemy.equals("troll")) {
						damageTaken = rand.nextInt(troll.getAtt());
					}
					else if(enemy.equals("minotaur")) {
						damageTaken = rand.nextInt(minotaur.getAtt());
					}
					
					enemyHp -= damageDealt;
					playerHp -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + ".");
					System.out.println("\t> You take " + damageTaken + " from the enemy.");
					System.out.println();
					
					if(playerHp < 1) {
						System.out.println("The world slowly starts to fade to black...");
						System.out.println("..................");
						break;
					}
				}//End of #1 Attack
				else if(input.equals("2")) {
					if(playerHp >= 100) {
						System.out.println("You already have full health.");
					}
					else if(numHealthPots > 0) {
						playerHp += healthPotHealAmount;
						numHealthPots --;
						
						System.out.println("\t> *Gulp* *Gulp* *Gulp*");
						System.out.println("\t> You drank a health potion.");
						System.out.println("\t> You now have " + playerHp + " HP.");
						System.out.println();
						System.out.println("\t> You have " + numHealthPots + " left in your inventory.");
					}
					else {
						System.out.println("You have no health potions left!");
					}
				}//End of #2 Drink HP
				else if(input.equals("3")) {
					System.out.println("\t> You manage to run away from the " + enemy + ".");
					continue GAME;
				}//End of #3 Run Away
				else if(input.equals("4")) {
					System.out.println("\t> You access your inventory: ");
					System.out.println();
					System.out.println(inv);
					System.out.println();
					System.out.println(" # Would you like to equip a weapon or armor? (Y/N): ");////////////////////////////////
					String invAnswer = in.nextLine();
					invAnswer = invAnswer.toLowerCase();
					if(invAnswer.equals("y")) {
						System.out.println();
						System.out.println(" # Choose an item by typing it's name: # ");
						String invInput = in.nextLine();
						invInput = invInput.toLowerCase();
						boolean hasItem = false;
						if(inv.contains(invInput)) {
							hasItem = true;
						}
						if(hasItem = true) {
							currentWeapon = invInput;
							inv.remove(invInput);
						}
 					}
					else if(invAnswer.equals("n")) {
							System.out.println("\t> You leave your inventory.");
							System.out.println();
						}
					else {
						System.out.println("\tInvalid Input.");
					}
				}//End of Access Inventory
				else {
					System.out.println("\tInvalid Command.");
				}
				
			}//End of enemy health loop
			
			if(playerHp < 1) {
				System.out.println("You have died...");
				break;
			}
			
			System.out.println("_____________________________________________");
			System.out.println();
			System.out.println(" # The " + enemy + " was defeated!");
			System.out.println(" # You have " + playerHp + " HP left.");
			System.out.println();
			if(rand.nextInt(100) < rustySwordDropChance) {
				numOfRustySwords ++;
				inv.add("Rusty Sword");
				System.out.println(" # The " + enemy + " dropped a Rusty Sword!");
				System.out.println(" # The Rusty Sword was added to your inventory.");
				System.out.println();
			}
			if(rand.nextInt(100) < healthPotDropChance) {
				numHealthPots ++;
				System.out.println(" # The " + enemy + " dropped a health potion!");
				System.out.println(" # You now have " + numHealthPots + " health potion in your inventory!");
				System.out.println();
			}
			else {
				System.out.println(" # The " + enemy + " did not drop any health potions.");
			}
			System.out.println("_____________________________________________");
			System.out.println();
			System.out.println("\tWhat would you like to do now?");
			System.out.println("\t1. Continue fighting.");
			System.out.println("\t2. Exit dungeon.");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Command.");
				input = in.nextLine();
			}
			
			if(input.equals("1")) {
				System.out.println("You continue your adventure!");
			}
			else if(input.equals("2")) {
				System.out.println("You exit the dungeon successfully from you adventure!");
				break;
			}
					
		}//End of Game while

		System.out.println();
		System.out.println("_____________________________________________");
		System.out.println();
		System.out.println("Thanks for playing Thalmiro's Cave");
		System.out.println("_____________________________________________");
		
	}//End of main method

}//End of main class
