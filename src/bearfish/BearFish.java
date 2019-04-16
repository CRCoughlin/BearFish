package bearfish;

import facility.Room;
import facility.testSubject.TestSubject;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Christian R. Coughlin
 * Mar 24, 2019 
 */
public class BearFish {
	
	static int size;
	static String condition = "RandomMovement";
	static int numSubjects;
	static String[] subjectType;
	static String subject1 = "Bear";
	static String subject2 = "Fish";
	static String placement = "Random";
	
	static TestSubject subjects;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getInput_AutoRandom();
		createSubjects();
		System.out.println("\nSubjects:\n" + subjects.toString());
		
                Room board = new Room(size, condition, subjects, null);
                
                board.displayGrid();
                
	}
	
	private static void getInput_AutoRandom() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter board size: ");
		size = myObj.nextInt();
		
		System.out.println("Auto select: \n"
				+ "Condition - RandomMovement\n"
				+ "Subjects - 2\n"
				+ "Subject 1 - Bear\n"
				+ "Subject 2 - Fish\n"
				+ "Placement - Random");
		
		condition = "RandomMovement";
		numSubjects = 2;
		subjectType = new String[] {"Bear", "Fish"};
		placement = "Random";
	}
	
	private static void createSubjects() {
		int[] amounts = new int[] {size*size/8, size*size/8};				//TODO: Temp fix for object amounts till GUI input
		
		subjects = new TestSubject(amounts, subjectType);
	}

}
