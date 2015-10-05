package StarWars;
/**
 * a superclass for droids as well as a subclass for Entity class (not really used)
 * @author KevinD
 *
 */
public abstract class Droid extends Entity{
	private int numtasks;
	public Droid(String n, int h) {
		super(n, h);
	}
	/**
	 * returns the number of Tasks a droid has used
	 * @return
	 */
	public int getNumTasks(){
		return numtasks;
	}
	/**
	 * uses the task specified by user
	 */
	public void useTask(){
		
	}
}
