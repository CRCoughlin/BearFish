/**
 * 
 */
package testSubject;

import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * @author Christian R. Coughlin
 * Mar 24, 2019 
 */
public class TestSubject {
	
	final String[] TYPES = new String[]{"Bear", "Fish"};
        private final String CLASSPATH = "testSubject.";
	
	private final Object[] SUBJECTS;
	int length = 0;

	public TestSubject(int[] amount, String[] type){
            SUBJECTS = new Object[IntStream.of(amount).sum()];

            for(int i=0; i < type.length; i ++){
                    if(Arrays.stream(TYPES).anyMatch(type[i]::equals)) {	// Throw exception if not a valid class
                        subjectFactory(amount[i], type[i]);
                    }
            }
	}

	@SuppressWarnings("unchecked")
	private void subjectFactory(int amount, String type){
		String clazz = CLASSPATH + type;
		try {	
			if(Arrays.stream(TYPES).anyMatch(type::equals)) {
				for(int i=0; i < amount; i ++) {
					Object obj = Class.forName(clazz).newInstance();
                                        //Object obj = Class.forName(clazz).getDeclaredConstructors()[2].newInstance(len++);  //TODO: !Inspect of gDC()
					SUBJECTS[length++] = obj;
				}
			}		
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.print("ERROR: Bad access!\n");
			
		} catch (ClassNotFoundException e) {	
			System.out.print("ERROR: Invalid subject type! Only 'Bear', 'Fish' are allowed.\n");
		}
	}	
	
        public Object getSubject(int id){ return SUBJECTS[id]; }
        
        public int subjects(){return length;}
        
        @Override
	public String toString() {
		String str = new String();
		for(int i=0; i < length; i++)
                    str += SUBJECTS[i].toString();
		return str;
	}
	
}
