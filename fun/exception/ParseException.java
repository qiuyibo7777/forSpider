package fun.exception;

import java.util.concurrent.ConcurrentHashMap;

public class ParseException extends ExtractorException
{
    /**
     * 
     */
    private static final long serialVersionUID = -4859848432754853988L;
    private static final ConcurrentHashMap<Integer,String> errors = new ConcurrentHashMap<Integer, String>();
    
    static{
	addErrors(10001, "PARSE HREF FAILED");
	addErrors(10002, "PARSE TEXT FAILED");
	addErrors(10003, "PARSE PAGENO FAILED");
    }
    
    private static void addErrors(int paramInt, String paramString)
    {
      errors.put(new Integer(paramInt), paramString);
    }
    
   
    private static String find(int errCode, String errMessage)
    {
      String str = errors.get(new Integer(errCode));
      return errMessage != null ? str + " [" + errMessage + "]" : str;
    }

    public ParseException(int errCode){
	super(errCode, find(errCode, null));
    }
    
    public ParseException(int errCode,String errMessage){
	super(errCode,find(errCode, errMessage));
    }
    
    public ParseException(ExtractorException extractorException){
	super(extractorException.getErrCode(),extractorException.getErrMessage(),extractorException.getCause());
    }
}
