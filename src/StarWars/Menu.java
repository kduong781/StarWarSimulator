package StarWars;

import java.util.Random;
import java.util.Scanner;
/**
 * Methods for the menu of this program
 * @author KevinD
 *
 */
public class Menu {
	private static int count = 0, counter1 = 1;
	/**
	 * menu for which mission to pick
	 */
	public static void menu(){
		System.out.println("Choose a mission: ");
		System.out.println("1. Hunt the Sith Lord ");
		System.out.println("2. Capture the Imperial Base");
	}
	/**
	 * gets answer to which mission to pick with error checking
	 * @return
	 */
	public static int getAnswer(){
		int answer;
		menu();
		Scanner s = new Scanner(System.in);
		try{// error checking
		answer = s.nextInt();
		if(answer>2 || answer < 0){ // if answer isnt mission 1 or 2 pick the mission again
			System.out.println("Invalid Input! Try Again!");
			answer = getAnswer();
		}
		}catch(Exception e){
			answer = getAnswer(); 
			return answer;
		}
		return answer;
	}
	/**
	 * Does an action depending on what mission is chosen
	 * @param answer the mission that the use has chosen
	 * @param RebelTeam your team of rebels
	 * @param ImperialTeam the enemy team
	 * @param StormTroopers the enemy team
	 * @param counter counter to count how many times mission has been run
	 * @param answ the door which you chose
	 */
	public static void action(int answer, Entity[] RebelTeam, Entity[] ImperialTeam,Entity[] StormTroopers, int counter, int answ){
		Teams t = new Teams();
		int x = 1;
		if(counter1==3){ // if mission 2 door has been chosen correct 3 times you win
			System.out.println("Congratulations! You Win!");
			System.out.println("You have entered the Control Center!");
			System.out.println("Wipe Out the rest of the soldiers!");
		}
		if(counter1==4&&t.checkDead(StormTroopers)==true){ // after you wipe out the storm troopers you win
			System.out.println("Congratulations! You Win!");
		}
		if(RebelTeam[0].getHp()==0){ // if sith lord hp hits zero you lose
			System.out.println("Sorry! You Lose!");
			answer = -1;
		}
		if(ImperialTeam[0].getHp()==0 && ImperialTeam[0].getName()=="Darth Vader"){
			System.out.println("Congratulations! You Win!");
			answer = -1;
		}
		if(answer == 1){ // if user chooses mission one, run mission 1
			count++;
			if(count ==1){
			System.out.println("You run across the Sith Lord, he has troops with him. Attack!\n");
		}
			mission(answer,RebelTeam,ImperialTeam,StormTroopers,counter,x,answ);
	
		}else if(answer==2){ // if user chooses mission 2, run mission 2
			count++;
			boolean check =t.checkDead(StormTroopers);
			if(count>1&& check == false){ // run mission2 if user has already chosena door and if storm troopers are not dead yet
				mission2(answer,RebelTeam,StormTroopers,StormTroopers,counter,x,answ);
			}
			if(count == 1){ // run this code if user has not chosen a door
			//System.out.println("You have gotten closer to the Control Center!");
			//System.out.println("Find the Control Center!");
			Random r = new Random();
			int prize = r.nextInt(3)+1;
		//	System.out.println("Choose A Door");
			if(counter1!=3){
			System.out.println("Choose A Door!(1,2,3)");
			Scanner s = new Scanner(System.in);
			answ = s.nextInt();
			}
			if(answ==prize&&counter1!=3){ // if user choses the right door, get closer to the 
				if(counter1!=3){
					System.out.println("You have gotten closer to the Control Center!");
					counter++;
					count = 0;
					action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
				}
				
			}else if(answ!=prize&&counter1!=3){ // if user chooses the wrong door, wipe out the soldiers to choose the next door
				System.out.println("You have run into some Storm Troopers!");
				counter1++;
				mission2(answer,RebelTeam,ImperialTeam,StormTroopers,counter,x,answ);
			}
			}
			}
		}
//}
	public static int getAnsw(){
		System.out.println("Choose A Door!(1,2,3)");
		Scanner s = new Scanner(System.in);
		try{
		int answ = s.nextInt();
		if(answ<1||answ>3){
			answ = getAnsw();
		}
		return answ;
	}catch(Exception e){
		System.out.println("Invalid Input!");
		int answ = getAnsw();
		return answ;
	}
	}
/**
 * Resets the count to zero.
 */
public static void count(){
	count = 0;
}
/**
 * Error Checking for what user wants to do with jedi
 * @return
 */
public static int getAnswer3(){
	System.out.println("What do you want to do?");
	subMenu();
	Scanner s = new Scanner(System.in);
	try{
	int answer3 = s.nextInt();
	if(answer3<1||answer3>3){
		System.out.println("Invalid Input");
		answer3 = getAnswer3();
	}
	return answer3;
	}catch(Exception e){
		System.out.println("Invalid Input");
		int answer3 = getAnswer3();
		return answer3;
	}
}

public static int getAnswer2(Entity[] ImperialTeam, String s1){
	int x = 1;
	System.out.println(s1);
	for(Entity i: ImperialTeam){
		System.out.println(x +".  "+i.getName());
		x++;
	}
	Scanner s = new Scanner(System.in);
	try{
	int answer2 = s.nextInt();
	if(answer2<1||answer2>8){
		answer2 = getAnswer2(ImperialTeam,s1);
	}
	return answer2;
	}catch(Exception e){
		System.out.println("Invalid Input!");
		int answer2 = getAnswer2(ImperialTeam,s1);
		return answer2;
	}
}
/**
 * Error Checking for who to heal
 * @param RebelTeam
 * @return
 */
public static int getAnswerv2(Entity[] RebelTeam){
	System.out.println("\nChoose someone to heal: ");
	for(int x1 = 0; x1<=6; x1++){
		System.out.println(x1 + 1 +".  "+RebelTeam[x1].getName());
		//x1++;
	}	
	Scanner s = new Scanner(System.in);
	try{
	int answer2 = s.nextInt();
	if(answer2<1||answer2>5){
		answer2 = getAnswerv2(RebelTeam);
	}
	return answer2;
	}catch(Exception e){
		System.out.println("Invalid Input!");
		int answer2 = getAnswerv2(RebelTeam);
		return answer2;
	}
}
	/**
	 * Runs mission 1 (Killing the Sith Lord)
	 * @param answer answer is which mission the user has chosen
	 * @param RebelTeam Rebel Team is the team that contains rebels
	 * @param ImperialTeam Imperial Team is the team that has the Sith Lord
	 * @param StormTroopers StormTroopers is the team that consists of just Storm Troopers
	 * @param counter counter counts has many times the mission has been run
	 * @param x x is another variable for counting
	 * @param answ answ is which door the user chose
	 */
public static void mission(int answer, Entity[] RebelTeam, Entity[] ImperialTeam,Entity[] StormTroopers, int counter, int x, int answ){
	Teams t = new Teams();
	System.out.println("Good Guys");
	System.out.println("----------");
	for(Entity i: RebelTeam){ // for each loop to print out characters in the rebel team
		System.out.println(i.getName() +"   "+ i.getHp());
	}
	System.out.println("\nBad Guys");
	System.out.println("----------");
	for(Entity i: ImperialTeam){ // for each loop to print out characters in the bad team
		System.out.println(i.getName() +"   "+ i.getHp());
	}
Scanner s = new Scanner(System.in);
 // calls submenu of options of what to do
int answer3 = getAnswer3();
if(answer3 ==1){ // attack if answer is 1
	int answer2 = getAnswer2(ImperialTeam,"\nChoose someone to attack: ");
RebelTeam[0].doTask(ImperialTeam[answer2 - 1]);
t.teamAttack(RebelTeam,ImperialTeam,7,5); // 7, 5
t.teamAttack(ImperialTeam,RebelTeam,7,5);// 7, 5
action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
}else if(answer3 ==2){ // if answer is 2 use the force and attack
	int answer2 = getAnswer2(ImperialTeam,"\nChoose someone to attack: ");
	RebelTeam[0].setTask("useForce");
	RebelTeam[0].doTask(StormTroopers[answer2 - 1]);
	RebelTeam[0].setTask("");
	t.teamAttack(RebelTeam,ImperialTeam,7,5);  //7,3 d =  7 e = 3 f = 3 
	t.teamAttack(ImperialTeam,RebelTeam,7,5);  //3, 7
	action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
}else if(answer3 == 3){ // if answer is 3 heal a character
		int answer2 = getAnswerv2(RebelTeam);
		if(RebelTeam[7].getHp()>0&&(Jedi.class.isInstance(RebelTeam[answer2-1])||Rebel.class.isInstance(RebelTeam[answer2-1]))){
		((Medical) RebelTeam[7]).doTask(RebelTeam[answer2-1]);
		action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
	}else{
		System.out.println("You cannot heal the character chosen!");
	}
	}
}
/**
 * Menu for what the user wants to do with his Jedi/Medic
 */
public static void subMenu(){
	System.out.println("1. Attack with Lightsaber.");
	System.out.println("2. Attack using the Force.");
	System.out.println("3. Have the droid to heal someone.");

}
/**
 * Runs mission 2 (Monty Hall) if u choose 3 doors right, you win
 * @param answer answer is which mission the user has chosen
 * @param RebelTeam Rebel Team is the team that contains rebels
 * @param ImperialTeam Imperial Team is the team that has the Sith Lord
 * @param StormTroopers StormTroopers is the team that consists of just Storm Troopers
 * @param counter counter counts has many times the mission has been run
 * @param x x is another variable for counting
 * @param answ answ is which door the user chose
 */
public static void mission2(int answer, Entity[] RebelTeam, Entity[] ImperialTeam,Entity[] StormTroopers, int counter, int x, int answ){
	Teams t = new Teams();
	System.out.println("Good Guys");
	System.out.println("----------");
	for(Entity i: RebelTeam){ // for each loop to print out rebel team
		System.out.println(i.getName() +"   "+ i.getHp());
	}
	System.out.println("\nBad Guys");
	System.out.println("----------");
	for(Entity i: StormTroopers){ // for each loop to print out bad team
		System.out.println(i.getName() +"   "+ i.getHp());
	}
Scanner s = new Scanner(System.in);
int answer3 = getAnswer3();
if(answer3 ==1){ // if answer is 1 chose an attack
	int answer2 = getAnswer2(StormTroopers,"\nChoose someone to attack: ");
RebelTeam[0].doTask(StormTroopers[answer2 - 1]);
t.teamAttack(RebelTeam,StormTroopers,7,5); // 7, 5           method to attack other team
t.teamAttack(StormTroopers,RebelTeam,7,7);// 7, 5
action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
}else if(answer3 ==2){               // if answer is 2 use the force and attack
	int answer2 = getAnswer2(StormTroopers,"\nChoose someone to attack: ");
	RebelTeam[0].setTask("useForce");
	RebelTeam[0].doTask(StormTroopers[answer2 - 1]);
	RebelTeam[0].setTask("");
	t.teamAttack(RebelTeam,StormTroopers,7,5);  //7,3 d =  7 e = 3 f = 3 
	t.teamAttack(StormTroopers,RebelTeam,7,7);  //3, 7
	action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
}else if(answer3 == 3){ // if answer is 3 heal an chosen character
	int answer2 = getAnswerv2(RebelTeam);
	if(RebelTeam[7].getHp()>0&&(Jedi.class.isInstance(RebelTeam[answer2-1])||Rebel.class.isInstance(RebelTeam[answer2-1]))){
		RebelTeam[7].doTask(RebelTeam[answer2-1]);
		action(answer,RebelTeam,ImperialTeam,StormTroopers,counter, answ);
	}else{
		System.out.println("You cannot heal the character chosen!");
	}
	}
}
}
