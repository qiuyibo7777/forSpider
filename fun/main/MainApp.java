package fun.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fun.test.ParseNewsContent;

public class MainApp
{
    private final static String path = "";
    private static int dep  = 2;
    private static int threadCount = 1;
    private static List<String> files = Arrays.asList("./src/iteye.txt","./src/jd.txt","./src/content.txt");
    private static Map<String, ExecutorService> dataexec = new HashMap<String, ExecutorService>();

    public static void main(String[] args)
    {
	configLog();
	configSpring();
	spider();
    }
    
    private static void spider(){
	createThreadPool();
	for(String filePath:files){
	    if(filePath.contains("iteye")){
		dataexec.get(filePath).execute(new ParseNewsContent(filePath));		
	    }
	    if(filePath.contains("jd")){
		dataexec.get(filePath).execute(new ParseNewsContent(filePath));		
	    }
	    if(filePath.contains("content")){
		dataexec.get(filePath).execute(new ParseNewsContent(filePath));		
	    }
	    dataexec.get(filePath).shutdown();
	}
    }
    
    private static void createThreadPool() {
 	int cpuNums = Runtime.getRuntime().availableProcessors();
 	for(String file:files){
 	    dataexec.put(file, Executors.newFixedThreadPool(threadCount*cpuNums));
 	    Executors.newCachedThreadPool();
 	}
    }
    
    private static void configLog(){
	PropertyConfigurator.configure(path+"./config/log4j.properties");
    }
    
    private static void configSpring(){
	File[] files = new File(path + "config").listFiles();
	ArrayList<String> list = new ArrayList<String>();
	for (File file : files) {
		if (file.getName().startsWith("app")) {
			list.add(path + "config" + File.separator + file.getName());
		}
	}
	String[] arry = new String[list.size()];
	list.toArray(arry);
	ApplicationContext appCtx = new FileSystemXmlApplicationContext(arry);
//	readConfigFromDB();
    }
}
