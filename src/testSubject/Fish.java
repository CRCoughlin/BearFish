/**
 * 
 */
package testSubject;

/**
 * @author Christian Coughlin
 *
 */
public class Fish extends Subject implements Actions<Fish>{

	/* (non-Javadoc)
	 * @see testSubject.Actions#killed(int)
	 */
	@Override
	public boolean killed(int strength) {
		if (strength > this.strength)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see testSubject.Actions#move()
	 */
	@Override
	public int move() {
		// TODO Auto-generated method stub
		return 1;
	}

	/* (non-Javadoc)
	 * @see testSubject.Actions#reprocreate(testSubject.Subject)
	 */
	@Override
	public Fish reprocreate(Subject subject) {
		return new Fish();
	}
	
	@Override
	public String toString() {
		return "Fish{'Strength': " + strength + ", 'Gender': " + gender + "}\n";
	}
}
