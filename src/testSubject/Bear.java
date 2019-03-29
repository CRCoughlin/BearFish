/**
 * 
 */
package testSubject;

/**
 * @author Christian Coughlin
 *
 */
public class Bear extends Subject implements Actions<Bear>{

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
	public Bear reprocreate(Subject subject) {
		return new Bear();
	}
	
	@Override
	public String toString() {
		return "Bear{'Strength': " + strength + ", 'Gender': " + gender + "}\n";
	}

}
