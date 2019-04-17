/**
 *
 */
package facility;

import facility.movement.Phases;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import facility.testSubject.Actions;
import facility.testSubject.TestSubject;
import java.util.concurrent.TimeUnit;

/**
 * @author Christian R. Coughlin Mar 24, 2019
 */
public class Conditioner {

    final static private String[] TYPES = {"RandomMovement", "Conway"};
    final static private String CLASSPATH = "facility.movement.";
    protected Phases condition;

    public Conditioner(String type) {
        if (Arrays.stream(TYPES).anyMatch(type::equals)) {
            String clazz = CLASSPATH + type;
            try {
                condition = (Phases)Class.forName(clazz).newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
			System.out.print("ERROR: Bad access!\n");
			
		} catch (ClassNotFoundException e) {	
			System.out.print("ERROR: Invalid subject type! Only 'RandomMovement', 'Conway' are allowed.\n");
		}
        }
    }

    public void turn(int turns, Grid grid, int speed) throws InterruptedException {
        for (int i = 0; i < turns; i++){
            condition.nextTurn(grid);
            if(speed > 0)
                System.out.println("\nTurn: " + (i+1) + "\n" +grid.toText());
                TimeUnit.SECONDS.sleep(speed);
        }
    }
    
    public String[] getConditions() {
        return TYPES;
    }
}
