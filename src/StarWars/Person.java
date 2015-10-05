package StarWars;
/**
 * Person subclass that extends to Entity super class
 * @author KevinD
 *
 */
public abstract class Person extends Entity{
	private String weapon;
	private String quip, name;
//	public Person() {};
	public Person(String n, int h,String w, String q){
		super(n,h);
		weapon = w;
		quip = q;
		name = n;
	}

/**
 * says the catchprhase of the person when method is called
 */

	public void sayCatchPhrase(){
		System.out.println(name +" says: "+quip);
	}
	/**
	 * abstract method that forces all persons to have this method be created
	 * @param e
	 */
	public abstract void attack(Entity e);
/**
 * returns weapon of person
 * @return
 */
	public String getWeapon(){
		return "";
	}

}

