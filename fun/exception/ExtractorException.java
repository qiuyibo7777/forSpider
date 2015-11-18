package fun.exception;

public class ExtractorException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 4737536349044245108L;
    
    private int errCode = -2147483648;
    private String errMessage = null;
    
    public ExtractorException(){}
    
    public ExtractorException(Throwable throwable){
	super(throwable);
    }
    
    public ExtractorException(String errMessage,Throwable throwable){
	super(errMessage,throwable);
    }
    
    public ExtractorException(int errCode,String errMessage){
	super(errCode+":"+errMessage);
	this.errCode = errCode;
	this.errMessage = errMessage;
    }
    
    public ExtractorException(int errCode,String errMessage,Throwable throwable){
	super(errCode+":"+errMessage,throwable);
	this.errCode = errCode;
	this.errMessage = errMessage;
    }
    
    public int getErrCode(){
	return this.errCode;
    }
    
    public String getErrMessage(){
	return this.errMessage;
    }
    
    @Override
    public String toString(){
	 if ((this.errCode != -2147483648) || (this.errMessage != null))
	      return "ExtractorException => " + this.errCode + ": " + this.errMessage;
	return super.toString();
    }
    
}
