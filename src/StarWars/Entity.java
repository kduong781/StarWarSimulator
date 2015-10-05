package StarWars;
/**
 * Super class that contains abstract methods for subclasses
 * @author KevinD
 *
 */
public abstract class Entity {
	private String name;
	private int hp;
	private boolean active;
	public String task = "";
	public Entity() {};
	public Entity(String n, int h){
		name = n;
		hp = h;
	}
	/**
	 * returns the name of the Entity
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * returns the hp of the entity
	 * @return
	 */
	public int getHp(){
		return hp;
	}
	/**
	 * checks if entity is active or alive
	 * @return
	 */
	public boolean getActive(){
		return active;
	}
	/**
	 * modifies hp of entity
	 * @param h
	 */
	public void modifyHp(int h){
		if(h<0){
			h = 0;
			System.out.println(name+" has been defeated!");
		}
		hp = h;
	}
	/**
	 * abstract method to force subclass to have this method created
	 * @param e
	 */
	public abstract void doTask(Entity e);
	/**
	 * method that does nothing
	 * @return
	 */
	public String getTask(){
		return task;
	}
	/**
	 * method that is supposed to use force ( not really used
	 * @param e
	 */
	/**
	 * method to setTask (not really used)
	 * @param t
	 */
	public void setTask(String t){
		task = t;
	}

}
