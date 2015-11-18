package fun.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

public class LogHelper
{
    private BlockingQueue<String> msgQueue;
    private BlockingQueue<Throwable> exceptionQueue;
//    private volatile boolean isShutDown;
    private LogThread logThread;
    private Logger log;
    
    public LogHelper(Logger log){
	msgQueue = new ArrayBlockingQueue<String>(0);
	exceptionQueue = new LinkedBlockingQueue<Throwable>();
	logThread = new LogThread();
	this.log = log;
    }
        
    public Logger getLog(){
	return this.log;
    }
    
    public void start(){
	logThread.start();
    }
    
    public void stop(){
	logThread.interrupt();
    }
    
    public void log(String msg){
	log(msg,null);
    }
    
    public void log(String msg,Throwable throwable){
	try
	{
	    msg = log.getName() + " : " + msg;
	    msgQueue.put(msg);
	    if(throwable == null){
		exceptionQueue.put(null);
	    }else{
		exceptionQueue.put(throwable);
	    }
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
	
    }
    
    
    private class LogThread extends Thread{

	@Override
	public void run()
	{
	    while(true){
		try
		{
		    String msg = msgQueue.take();
		    Throwable throwable = exceptionQueue.take();
		    if(throwable == null){
			log.info(msg);
		    }else{
			log.error(msg, throwable);
		    }
		}
		catch (InterruptedException e)
		{
		    e.printStackTrace();
		}
	    }
	}
	
    }
}
