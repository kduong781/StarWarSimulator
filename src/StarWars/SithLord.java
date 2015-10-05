package StarWars;

import java.util.Random;
/**
 * subclass that extends to the person superclass and implements has force
 * @author KevinD
 *
 */
public class SithLord extends Person implements HasForce{
	private String saberColor, name;
	/**
	 * 
	 * @param n
	 * @param q
	 * @param c
	 */
	public SithLord(String n, String q, String c){
		super(n, 200, "lightsaber", q);
		saberColor = c;
		name = n;
	}
	/**
	 *doTasks method which overwrites the supers method
	 */
	@Override
	public void doTask(Entity e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int random = r.nextInt(3);
		if(random>0){
		attack(e);
		}else{
			useForce(e);
		}
		
	}
	@Override
	/**
	 * specific attack for this subclass which overrides the supers method
	 */
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
	@Override
	/**
	 * useForce method
	 */
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
}
