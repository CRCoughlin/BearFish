import facility.Room;
import testSubject.TestSubject;
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
	static String condition = "Random";
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
		Room board = new Room();
		getInput_AutoRandom();
		createSubjects();
		System.out.println("\nSubjects:\n" + subjects.toString());
		
	}
	
	private static boolean getInput_AutoRandom() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter board size: ");
		size = myObj.nextInt();
		
		System.out.println("Auto select: \n"
				+ "Condition - Random\n"
				+ "Subjects - 2\n"
				+ "Subject 1 - Bear\n"
				+ "Subject 2 - Fish\n"
				+ "Placement - Random");
		
		condition = "Random";
		numSubjects = 2;
		subjectType = new String[] {"Bear", "Fish"};
		placement = "Random";
		return true;
	}
	
	private static void createSubjects() {
		int[] amounts = new int[] {size/4, size/4};				//TODO: Temp fix for object amounts till GUI input
		
		subjects = new TestSubject(amounts, subjectType);
	}

}
