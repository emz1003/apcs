import java.util.NoSuchElementException;

public class EmptyDequeException extends NoSuchElementException{

    public EmptyDequeException(String error){
	super(error);
    }

}
