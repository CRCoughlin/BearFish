/**
 * 
 */
package facility;

import testSubject.TestSubject;

/**
 * @author Christian R. Coughlin
 *
 */
public class Room{

	private int[][] board;
	private Conditioner condition;
        private TestSubject subjects;
        private int size = 0;           // As square
	
	public Room (int size, String type) {
		condition = new Conditioner(type);
		board = new int[size][size];
                this.size = size*size;
	}
        
        public Room (int size, String type, TestSubject subjects) {
		condition = new Conditioner(type);
		board = new int[size][size];
                this.size = size*size;
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
            Collention[] d = {2,3,4,};
            d.s
        }
	
	public void setSubjects(TestSubject subjects) {
		this.subjects = subjects;
	}
	
	public void setSize(int size) {
		board = new int[size][size];
                this.size = size*size;
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
            for(int i=0; i < size; i++){
                for(int j=0; j < size; j++){  // Set for squares only
                    str += subjects.getSubject([board[i][j]]).getClass()[0];
                   if(j < size-1)
                       str += '|';
                }
                if(i < size-1)
                       for(int j=0; j<size; j++)
                           str += '-';
            }
            return str;
        }
}
