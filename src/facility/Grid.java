/**
 *
 */
package facility;

import java.util.Random;
import facility.testSubject.TestSubject;
import facility.testSubject.Subject;

/**
 * @author Christian R. Coughlin Mar 24, 2019
 */
public class Grid {

    private TestSubject testSubjects;
    private int[][] grid;
    private int length;
    private int area;
    private int subjects;

    public Grid(int size, TestSubject subjects, int[][] pos) {
        testSubjects = subjects;
        grid = new int[size][size];
        length = size;
        area = size * size;
        this.subjects = subjects.subjects();
        clearBoard();
        
        position(pos);
    }

    public final void clearBoard() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                grid[i][j] = -1;
            }
        }
    }

    public void position(int[][] pos) {
        // TODO: User checks size vs board
        if (pos == null) {
            randomPlacement();
        } else { // TODO: Test for correct
            grid = pos;
        }
    }

    private void randomPlacement() {
        int id = 0;
        int amount = testSubjects.subjects();
        for (int i = 0; i < length && id < amount; i++) {
            for (int j = 0; j < length && id < amount; j++) {
                testSubjects.setCord(id, i, j);
                grid[i][j] = id++;
            }
        }

        Random rand = new Random();
        int temp;
        int x, y;
        int maxRow = (int) (Math.floor(amount / length));
        int maxCol = amount % length;
        for (int i = 0; i < maxRow+1; i++) {
            for (int j = 0; j < length && !(i == maxRow && j == maxCol); j++) {
                temp = grid[i][j];

                do {
                    x = rand.nextInt(length);
                    y = rand.nextInt(length);
                } while (x == i && y == j);

                testSubjects.setCord(temp, x, y);
                if(grid[x][y] != -1){
                    testSubjects.setCord(grid[x][y], i, j);
                }
                grid[i][j] = grid[x][y];
                grid[x][y] = temp;
            }
        }
    }

    public void updateSubjectPosition(int ID, int x, int y){
        Subject sub = getSubject(ID);
        grid[x][y] = ID;
        grid[sub.getX()][sub.getY()] = -1;
        sub.setCord(x, y);
    }
    
    /*public void reproduce(int ID1, int ID2){
        
    }
    
    public int addSubject(int x, int y){
        
    }
  */
    public void removeSubject(int id){
        Subject sub = getSubject(id);
        grid[sub.getX()][sub.getY()] = -1;
        testSubjects.getSubject(id).setCord(-1, -1);
    }
    
    public Subject getSubject(int ID){
        return testSubjects.getSubject(ID);
    }
    
    public String[] subjectInfo(int id){
        return testSubjects.subjectInfo(id);
    }
    
    public int subjects(){
        return subjects;
    }
    
    public boolean isEmpty(int x, int y) {
        return (grid[x][y] == -1);
    }
    
    public int getIDAt(int x, int y){
        return grid[x][y];
    }
    
    public void setSize(int size) {
        grid = new int[size][size];
        area = size * size;
        length = size;
    }
    
    public int getLength(){ return length; }

    public void setNewSubjects(TestSubject subjects, int[][] pos) {
        testSubjects = subjects;
        clearBoard();
        position(pos);
    }

    public int[][] getGrid() {
        return grid;
    }

    public String toText() {
        String str = new String();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == -1) {
                    str += "| ";
                } else {
                    str += "|" + testSubjects.getSubject(grid[i][j]).getClass().getSimpleName().charAt(0);
                }
            }
            str += "|\n";
        }
        return str;
    }
}
