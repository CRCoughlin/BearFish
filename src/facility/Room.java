/**
 *
 */
package facility;

import facility.testSubject.TestSubject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Christian R. Coughlin
 *
 */
public class Room {

    private Grid grid;
    private Conditioner condition;

    public Room(int size, String condType, TestSubject subjects, int[][] pos) {
        condition = new Conditioner(condType);
        grid = new Grid(size, subjects, pos);
    }

    
    public void runs(int turns, int speed){
        try {
            condition.turn(turns, grid, speed);
        } catch (InterruptedException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void displayGrid(){
        System.out.println(grid.toText());
    }
    
    public void setGrid(int size, TestSubject subjects, int[][] pos) {
        grid = new Grid(size, subjects, pos);
    }

    public String[] getConditions() {
        return condition.getConditions();
    }

    public void setCondition(String type) {
        condition = new Conditioner(type);
    }

    public void setSubjects(TestSubject subjects, int[][] pos) {
        grid.setNewSubjects(subjects, pos);
    }
    
}
