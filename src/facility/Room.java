/**
 *
 */
package facility;

import facility.testSubject.TestSubject;

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

    
    public void runs(int turns){
        condition.turn(turns, grid);
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
