package StarWars;
import java.util.*;
/**
 * the main method which runs the program
 * @author Kevin Duong 01171500
 *
 */
public class main {
	private static int x = 1;
	public static void main(String[]args){
		run();
	}
	public static void run(){
		int counter = 1;
		Teams t = new Teams();
		Menu m = new Menu();
		System.out.println("Welcome to the Star Wars Galaxy!");
		System.out.println("Please choose a name for your Jedi:");
		Scanner s = new Scanner(System.in);
		String n = s.next();
		Jedi jedi = new Jedi(n,"hi","green");
		Entity RebelTeam[] = new Entity[8];
		Entity ImperialTeam[] = new Entity[8];
		Entity StormTroopers[] = new Entity[8];
		StormTroopers = t.makeStorm(StormTroopers);
		RebelTeam = t.makeRebel(RebelTeam, jedi);
		ImperialTeam = t.makeImperial(ImperialTeam);
		int answer = m.getAnswer();
		m.action(answer,RebelTeam,ImperialTeam,StormTroopers,counter,0);
		if(t.checkDead(StormTroopers)==true){
			StormTroopers = t.makeStorm(StormTroopers);
			m.count();
			m.action(2,RebelTeam,StormTroopers,StormTroopers,counter,0);
			
		}
		if(ImperialTeam[0].getHp()<=0 && answer == 2){
			System.out.println("Congratulations! You Win!");
		}else if(RebelTeam[0].getHp()<=0){
			System.out.println("Sorry! You Lose!");
		}
		String play = answer();
		if(play.equals("yes")){
			run();
		}else if(play.equals("no")){
			System.out.println("Program exiting...");
			System.exit(0);
		}
	}
	public static String answer(){
		Scanner s = new Scanner(System.in);
		System.out.println("Would you like to play again?(yes or no)");
		try{
		String play = s.next();
		if(!(play.equals("yes")||play.equals("no"))){
			play = answer();
	}
		return play;
		}catch(Exception e){
			String play = answer();
			return play;
		}
	}
	
}
