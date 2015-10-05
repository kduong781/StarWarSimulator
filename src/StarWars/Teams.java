package StarWars;
import java.util.*;
/**
 * Methods for whole team action/checking
 * @author KevinD
 *
 */
public class Teams {
	/**
	 * Creates the rebel team
	 * @param e entity array to pass the values into
	 * @param jedi jedi to pass into entity e
	 * @return   returns the values of the array into array e
	 */
	public static Entity[] makeRebel(Entity[] e, Jedi jedi){
		e[0] = jedi;
			for(int x = 1; x<=5; x++){
				Entity r = new Rebel("Rebel Trooper "+ x, "haha");
				e[x]= r;
			}
			Astromech mech = new Astromech("Mech");
			Medical medic = new Medical("Medic");
			e[6] = mech;
			e[7] = medic;
		return e;
	}
	/**
	 * Creates the Imperial Team
	 * @param e  entity array to pass the values into
	 * @return   returns the values of the array into array e
	 */
	public static Entity[] makeImperial(Entity[] e){
		SithLord sith = new SithLord("Darth Vader", "You Will Die", "black");
		e[0] = sith;
			for(int x = 1; x<=5; x++){
				Entity s = new Stormtrooper("Storm Trooper "+ x, "You Will Die");
				e[x]= s;
			}
			Door door = new Door("Door");
			Computer computer = new Computer("Computer");
			e[6] = door;
			e[7] = computer;
		return e;
	}
	/**
	 * Creates the team of StormTroopers
	 * @param e array to pass the values into
	 * @return StormTroopers into array e
	 */
	public static Entity[] makeStorm(Entity[] e){

			for(int x = 1; x<=8; x++){
				Entity s = new Stormtrooper("Storm Trooper "+ x, "Almost!");
				e[x-1]= s;
			}

		return e;
	}
	/**
	 * Has the Team attack the other team
	 * @param e Team that is attacking
	 * @param e2 Team that is getting attacked
	 * @param z random
	 * @param y random
	 */
	public static void teamAttack(Entity[] e, Entity[] e2, int z, int y){
		int x = 1;
		int coun = 0;
		Teams t = new Teams();
		Random r = new Random();
		int random = r.nextInt(z);
		for(int x1 = 0; x1<=y; x1++){
		random = r.nextInt(z);
		boolean check = t.checkDead(e2);
		if(e[x1].getHp()>0){
			while(e2[random].getHp() <=0&&coun<1000){
				random = r.nextInt(z);
				//e[x1].doTask(e2[random]);
				check = t.checkDead(e2);
			//	x1++;
				coun++;
			}
			//e[x1].doTask(e2[random]);
		check = t.checkDead(e2);
		if(check == false&&e[0].getHp()!=0){
		e[x1].doTask(e2[random]);
		}
		}
	}
		
}
/**
 * Method for checking if enemy team is dead
 * @param StormTroopers Enemy Team array
 * @return boolean true if StormTroopers are dead and false if Storm Troopers are still alive
 */
	public boolean checkDead(Entity[] StormTroopers){
		boolean check = false;
		int a = StormTroopers[0].getHp();
		int b = StormTroopers[1].getHp();
		int c = StormTroopers[2].getHp();
		int d = StormTroopers[3].getHp();
		int e = StormTroopers[4].getHp();
		int f = StormTroopers[5].getHp();
		int g = StormTroopers[6].getHp();
		int h = StormTroopers[7].getHp();
	//	int i = StormTroopers[8].getHp();
		
		int sum = a+b+c+d+e+f+g+h;
		if(sum== 0){
			check = true;
		}
		return check;
	}
}