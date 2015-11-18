package fun.exception;

public class HttpException extends ExtractorException
{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -2991261541342552644L;
    
    
    public HttpException(int errCode,String errMessage){
	super(errCode,errMessage);
    }
}
