package com.techelevator.text_based_videogame;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		//Game Variables
		String[] enemies = {"slime", "goblin", "wolf", "giant spider", "troll", "minotaur"};
		int maxMobHp = 75;
		int maxMobAtt = 25;
		
		//Player Variables
		int playerHp = 100;
		int playerAtt = 50;
		int numHealthPots = 3;
		int healthPotHealAmount = 20;
		int healthPotDropChance = 40;
		
		boolean running = true;
		
		System.out.println("Welcome child to the wishing well.. You ask for heaven, we give you hell.");
		
		GAME:
		while(running) {
			System.out.println("_____________________________________________");
			System.out.println();
			
			int enemyHp = rand.nextInt(maxMobHp);
			String enemy = enemies[rand.nextInt(enemies.length - 1)];
			System.out.println("\t# A " + enemy + " has appeared. #\n");
			
			while(enemyHp > 0) {
				System.out.println("\tYour HP: " + playerHp);
				System.out.println("\t" + enemy + "'s HP: " + enemyHp);
				System.out.println();
				System.out.println("\tWhat would you like to do?");
				System.out.println("\t1. Attack.");
				System.out.println("\t2. Drink health potion.");
				System.out.println("\t3. Run.");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(playerAtt);
					int damageTaken = rand.nextInt(maxMobAtt);
					
					enemyHp -= damageDealt;
					playerHp -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + ".");
					System.out.println("\t> You take " + damageTaken + " from the enemy.");
					System.out.println();
					
					if(playerHp < 1) {
						System.out.println("The world slowly starts to fade to black...");
						System.out.println("...");
						break;
					}
				}//End of #1 Attack
				else if(input.equals("2")) {
					if(numHealthPots > 0) {
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
			if(rand.nextInt(100) < healthPotDropChance) {
				numHealthPots ++;
				System.out.println(" # The " + enemy + " dropped a health potion!");
				System.out.println(" # You now have " + numHealthPots + " health potion in your inventory!");
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
			else if(input.equals("3")) {
				System.out.println("You exit the dungeon successfully from you adventure!");
				break;
			}
					
		}//End of Game while

		System.out.println();
		System.out.println("_____________________________________________");
		System.out.println("Thanks for playing Jeremiah's Dungeon Game :D");
		System.out.println("_____________________________________________");
		
	}//End of main method

}//End of main class
