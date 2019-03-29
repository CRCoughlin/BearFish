/**
 * 
 */
package testSubject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * @author Christian R. Coughlin
 * Mar 24, 2019 
 */
public class TestSubject {
	
	private final String[] types = new String[]{"Bear", "Fish"};
	
	private Object[] subjects;
	int len = 0;

	public TestSubject(int[] amount, String[] type){
            //subjects = new Object[IntStream.of(amount).sum()];

            for(int i=0; i < type.length; i ++){
                    if(Arrays.stream(types).anyMatch(type[i]::equals)) {	// Throw exception if not a valid class
                            //subjects[i] = new Object[amount[i]];
                            //subjects = 
                        subjectFactory(amount[i], type[i]);
                    }
            }
	}

	@SuppressWarnings("unchecked")
	private void subjectFactory(int amount, String type){
		String clazz = "testSubject."+type;
		try {	
			if(Arrays.stream(types).anyMatch(type::equals)) {
				//T[] subject = (T[]) Array.newInstance(Class.forName(clazz), amount);
				for(int i=0; i < amount; i ++) {
					Object obj = Class.forName(clazz).newInstance();
                                        //Object obj = Class.forName(clazz).getDeclaredConstructors()[2].newInstance(len++);  //TODO: !Inspect of gDC()
					subjects[i] = obj;
				}
			}		
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.print("ERROR: Bad access!\n");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {	
			System.out.print("ERROR: Invalid subject type! Only 'Bear', 'Fish' are allowed.\n");
			e.printStackTrace();
		}
	}	
	
        public Object getSubject(int id){ return subjects[id]; }
        
	public String toString() {
		String str = new String();
		for(int i=0; i < subjects.length; i++)
                    str += subjects[i].toString();
		return str;
	}
	
}
