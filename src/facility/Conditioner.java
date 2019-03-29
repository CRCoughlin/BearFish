/**
 * 
 */
package facility;

import java.util.Arrays;

import testSubject.Actions;

/**
 * @author Christian R. Coughlin
 * Mar 24, 2019 
 */
public class Conditioner {
	
	final static private String[] types = {"Random", "Conway"};

	public Conditioner(String type) {
		int condition = Arrays.asList(types).indexOf(type);
		//if (condition == -1)
		//if(Arrays.stream(types).anyMatch(type::equals))
	}
	
	
	public void turn(int speed, int[][] positions) {
		
	}
	
	private void nextTurn() {
		
	}
	
	
	public String[] getConditions() {return types;}
}
