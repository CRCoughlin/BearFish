/**
 * <p>Title: DataException class</p>
 * 
 * <p>Description: </p>
 * 
 * @author Chrsitan Coughlin
 *
 */
@SuppressWarnings("serial")
public class DataException extends Exception
{

	public DataException(){
		super("Invaild vale for rang");
	}
	
	public DataException(String message){
		super(message);
	}
}
