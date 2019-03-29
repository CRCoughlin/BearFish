/**
 * 
 */
package facility;

/**
 * @author Christian R. Coughlin
 * Mar 26, 2019 
 */
public interface Phases {

		int turn = 2;
	
		void nextTurn();
		
		void reset();
}
