package StarWars;

import java.util.Random;
/**
 * StormTrooper class that extends to Person Superclass
 * @author KevinD
 *
 */
public class Stormtrooper extends Person{
	private String name;
	public Stormtrooper(String n, String q){
		super(n, 50, "hi", q);
		name = n;
	}
/**
 * method that overrides Person Super Class
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
 * method that overrides Person Super Class
 */
	@Override
	public void doTask(Entity e) {
		// TODO Auto-generated method stub
		attack(e);
		
	}
}
