/**
 * 
 */
package facility.testSubject;

/**
 * @author Christian Coughlin
 *
 */
public class Fish extends Subject implements Actions<Fish>{

    public Fish() {
        super();
    }
    
    public Fish(int min, int max) {
        super(min, max);
    }

	/* (non-Javadoc)
	 * @see testSubject.Actions#killed(int)
	 */
	@Override
	public boolean killed(int strength) {
		return strength > this.strength;
	}

	/* (non-Javadoc)
	 * @see testSubject.Actions#move()
	 */
	@Override
	public int moves() {
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
		return "Fish{'Alive': " + alive + ", 'Strength': " + strength + ", 'Gender': " + gender + "}\n";
	}
}
