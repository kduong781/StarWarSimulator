package StarWars;
import java.util.*;
/**
 * Jedi class that extends Person super class
 * @author KevinD
 *
 */
public class Jedi extends Person implements HasForce, Healable{
	private String saberColor, name;
	/**
	 * Jedi Constructor
	 * @param n
	 * @param q
	 * @param c
	 */
	public Jedi(String n, String q, String c){
		super(n, 100, "Lightsaber", q);
		saberColor = c;
		name = n;
	}
	/**
	 * attack method
	 */
	@Override
	public void attack(Entity e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int random = r.nextInt(2);
		int damage = r.nextInt(45)+ 10;
		if(random == 0&&super.getHp()!=0){
		System.out.println(name + " slashes at "+ e.getName()+" but misses!");
		sayCatchPhrase();
	}else if(random == 1&&super.getHp()!=0){
		System.out.println(name + " slashes at "+ e.getName()+" and does "+damage+" damage!");
		int newHp = e.getHp() - damage;
		e.modifyHp(newHp);
		if(e.getHp()==0){
			sayCatchPhrase();
		}
	}
	}
	/**
	 * doTask method which overrides the persons abstract method
	 */
	@Override
	public void doTask(Entity e) {
		// TODO Auto-generated method stub
		String s = getTask();
		if(s.equals("useForce")){
			useForce(e);
		}
		attack(e);
}
	/**
	 * useForce class that makes the jedi use the force when jedi pickes option 2
	 */
	@Override
	public void useForce(Entity e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int random = r.nextInt(2);
		int damage = r.nextInt(50)+ 10;
		if(random == 0){
		System.out.println(name + " uses the force "+ e.getName()+" but misses!");
		sayCatchPhrase();
	}else if(random == 1){
		System.out.println(name + " pushes "+ e.getName()+" with and does "+damage+" damage!");
		int newHp = e.getHp() - damage;
		e.modifyHp(newHp);
		if(e.getHp()==0){
			sayCatchPhrase();
		}
	}
	}
	/**
	 * heal method which heals the designated character chosen
	 */
	@Override
	public void heal(int hp) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int heal = r.nextInt(45)+ 10;
		System.out.println(getName() + " has been healed "+heal + " hp!");
		int hp1 = getHp();
		int newHp = hp1+ heal;
		modifyHp(newHp);
	}
}