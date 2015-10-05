package StarWars;

import java.util.Random;
/**
 * Medical class that extends Droid super class
 * @author KevinD
 *
 */
public class Medical extends Droid{
	public Medical(String n){
		super(n,20);
	}
/**
 * method that overrides Person Super Class
 */
	@Override
	public void doTask(Entity e) {
		// TODO Auto-generated method stub
		if((Healable.class.isInstance(e))){
			Healable h = (Healable)e;
			h.heal(30);
		
		}
		
	}
}

