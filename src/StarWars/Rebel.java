package StarWars;

import java.util.Random;
/**
 * Rebel subclass that extends to Person while implementing Healable interface
 * @author KevinD
 *
 */
public class Rebel extends Person implements Healable{
	private String name;
	public Rebel(String n, String q){
	//	String a,b,c;
		super(n, 50, "gun" , q);
		name = n;
	}
/**
 * doTask method that overrides Person Super Class
 */
	@Override
	public void doTask(Entity e) {
		// TODO Auto-generated method stub
		attack(e);
	}
/**
 * method that overrides Person Super Class
 * method that attacks entity targeted
 */
	@Override
	public void attack(Entity e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int random = r.nextInt(2);
		int damage = r.nextInt(25)+ 10;
		if(random == 0&&super.getHp()!=0){
		System.out.println(name + " shoots at "+ e.getName()+" but misses!");
		sayCatchPhrase();
	}else if(random == 1&&super.getHp()!=0){
		System.out.println(name + " shoots at "+ e.getName()+" and does "+damage+" damage!");
		int newHp = e.getHp() - damage;
		e.modifyHp(newHp);
			if(e.getHp()==0){
				sayCatchPhrase();
			}
	}
	}
/**
 * method that heals a target( not used)
 */
	@Override
	public void heal(int hp) {
		Random r = new Random();
		int heal = r.nextInt(45)+ 10;
		System.out.println(getName() + " has been healed "+heal + " hp!");
		int hp1 = getHp();
		int newHp = hp1+ heal;
		modifyHp(newHp);
		// TODO Auto-generated method stub
		
	}
}
