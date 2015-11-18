package fun.exception;

public class DBException extends ExtractorException
{    
    /**
     * 
     */
    private static final long serialVersionUID = 4330427546739592426L;

    public DBException(int errCode,String errMessage){
	super(errCode,errMessage);
    }
}
