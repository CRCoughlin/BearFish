/**
 * 
 */
package facility.testSubject;

/**
 * @author Christian Coughlin
 *
 */
public interface Actions <T extends Actions<T>> {

	
	boolean killed(int strength);
	
	int moves();
	
	T reprocreate(Subject subject);
}
