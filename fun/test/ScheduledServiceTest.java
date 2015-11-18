package fun.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledServiceTest
{

    public static void main(String[] args) throws ParseException
    {
	  ScheduledExecutorService copyConfig = Executors.newScheduledThreadPool(1);
	  
	  long oneDay = 24 * 60 * 60 * 1000;
	  long initDelay  = getTimeMillis("20:00:00") - System.currentTimeMillis();
	  initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

	  copyConfig.scheduleAtFixedRate(
				new CopyConfig(),
				initDelay,
				oneDay,
				TimeUnit.MILLISECONDS);
	  
	  copyConfig.scheduleAtFixedRate(new CopyConfig(), 0, 1, TimeUnit.SECONDS);
    }
    
    private static long getTimeMillis(String time) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
		Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
		return curDate.getTime();
    }
}

class CopyConfig implements Runnable{

    @Override
    public void run()
    {
	System.out.println("Test");
    }
    
}