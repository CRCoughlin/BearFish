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
        static int turns;
        static int pop;
        static int speed;
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
                
                System.out.println("Starting Board:");
                board.displayGrid();
                
                board.runs(turns, speed);
                
                System.out.println("Result ~~~~~~~~~~\nTurns after: " + turns);
                board.displayGrid();
                System.out.println("Subjects:\n" + subjects.toString());
	}
	
	private static void getInput_AutoRandom() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter board size: ");
		size = input.nextInt();
                
                System.out.println("How many turns: ");
		turns = input.nextInt();
                
                System.out.println("Population Percent(1-100): ");
		pop = input.nextInt();
                
                System.out.println("Time between turns (0-..)seconds: ");
		speed = input.nextInt();
		
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
                int amount = (int) Math.round(((pop / numSubjects)* 0.01 * (size * size)));
                if (amount*2 > size*size)
                    amount = size;
                
		int[] amounts = new int[] {amount, amount};				//TODO: Temp fix for object amounts till GUI input
		
		subjects = new TestSubject(amounts, subjectType);
	}

}
