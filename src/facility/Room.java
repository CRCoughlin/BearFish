/**
 * 
 */
package facility;

import java.util.Random;
import testSubject.TestSubject;

/**
 * @author Christian R. Coughlin
 *
 */
public class Room{

	private int[][] board;
	private Conditioner condition;
        private TestSubject subjects;
        private int length = 0;           // As square
        private int area = 0;
	
	public Room (int size, String condType) {
		condition = new Conditioner(condType);
		board = new int[size][size];
                area = size*size;
                length = size;
	}
        
        public Room (int size, String condType, TestSubject subjects) {
		condition = new Conditioner(condType);
		board = new int[size][size];
                area = size*size;
                this.subjects = subjects;
	}
        
        public void position(int[][] pos){
            //TODO: size vs board
            if(pos == null)
                randomPlacement();
            else{                   //TODO: Test for correct
                board = pos;
            }
        }
        
        private void randomPlacement(){
            int id = 0;
            int amount = subjects.subjects();
            for(int i=0; i < size && id < amount; i++)
                for(int j=0; j < size && id < amount; j++)
                    board[i][j] = id++;
                
int temp;
            for(int i=0; i < Math.floor(amount/length); i++)
for( j=amount%length; j > -1; j--){
x = Rand.nextInt() * length

temp = board[IMath....][x%length];
board[I][j] = x;

        }
	
	public void setSubjects(TestSubject subjects) {
		this.subjects = subjects;
	}
	
	public void setSize(int size) {
		board = new int[size][size];
                area = size*size;
	}
	
	public void setCondition(String type) {
		condition = new Conditioner(type);
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public String[] getConditions() {
		return condition.getConditions();
	}
        
        public String toASCIIBoard(){
            String str = new String();
            for(int i=0; i < length; i++){
                for(int j=0; j < length; j++){  // Set for squares only
                    str += subjects.getSubject([board[i][j]]).getClass()[0];
                   if(j < length-1)
                       str += '|';
                }
                if(i < size-1)
                       for(int j=0; j<length; j++)
                           str += '-';
            }
            return str;
        }
}
