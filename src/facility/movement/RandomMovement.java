/**
 * 
 */
package facility.movement;

import facility.Grid;
import facility.testSubject.Subject;
import java.util.Random;

/**
 * @author Christian R. Coughlin
 *
 */
public class RandomMovement implements Phases{
    
        private final Random rand = new Random();

        /*public RandomMovement(int[][] board, int size){
            
        }*/
        
        @Override
	public void nextTurn(Grid grid){
            Subject sub;
            int x;
            for(int i=0; i < grid.subjects(); i++){
                sub = grid.getSubject(i);
                
                for(int j=0; j < sub.getSpeed(); j++){
                    move(i, grid);              
                }
            }
	}
        
        private void move(int ID, Grid grid){
            Subject sub = grid.getSubject(ID);
            int x;
            int y;
            do{
                x = sub.getX() + rand.nextInt() * 2 -1;
                y = sub.getY() + rand.nextInt() * 2 -1;
                
            } while(x < grid.getLength() && y < grid.getLength() && y >= 0 && x >= 0); // Still in grid
           
            if(grid.isEmpty(x, y)){
                grid.updateSubjectPosition(ID, x, y);
            }
           /* else if(grid.getSubject(grid.getIDAt(x, y)).getClass() == sub.getClass() && 
                    grid.getSubject(grid.getIDAt(x, y)).getGender() != sub.getGender())
                    //reproduce
           */   
            else if(grid.getSubject(grid.getIDAt(x, y)).getClass() != sub.getClass())
                    if(sub.getStrength() > grid.getSubject(grid.getIDAt(x, y)).getStrength()){
                        grid.getSubject(grid.getIDAt(x, y)).dead();
                        grid.removeSubject(grid.getIDAt(x, y));
                    } else if (sub.getStrength() < grid.getSubject(grid.getIDAt(x, y)).getStrength()){
                        grid.getSubject(ID).dead();
                        grid.removeSubject(ID);
                    } else {
                        grid.getSubject(ID).dead();
                        grid.removeSubject(ID);
                        
                        grid.getSubject(grid.getIDAt(x, y)).dead();
                        grid.removeSubject(grid.getIDAt(x, y));
                    }
                         
        }
}
