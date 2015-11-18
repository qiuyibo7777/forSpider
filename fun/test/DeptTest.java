package fun.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DeptTest
{
    
    static HashMap<String, Integer> depth = new HashMap<String, Integer>();
    static ArrayList<String> allURL = new ArrayList<String>();
    static ArrayList<String> unVisitURL = new ArrayList<String>();
    static int dep  = 2;
    static int threadCount = 1;
    int count = 0;
    static final Object signal = new Object();
    private static final String URL = "";
//    private static List<String> files = Arrays.asList("./src/iteye.txt","./src/jd.txt","./src/sort.txt");
    private static List<String> files = Arrays.asList("./src/sort.txt");

    private static Map<String, ExecutorService> dataexec = new HashMap<String, ExecutorService>();
    public static void main(String[] args)
    {
	createThreadPool();
	for(String filePath:files){
	    dataexec.get(filePath).execute(new ParseNewsContent(filePath));
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
    
    
    
    
    //crawler begin 
    private static synchronized void begin()
    {
	for (int i = 0; i < threadCount; i++)
	{
	    new Thread(new Runnable()
	    {
		@Override
		public void run()
		{
		    while (true)
		    {
			String url = getUrl();
			if(url!=null){
			    crawler(url);
			}
		    }
		}
	    }).start();
	}
	
//	String url = getUrl();
//	if(url!=null){
//	    crawler(url);
//	}
    }
    
    // crawler
    private static synchronized void crawler(String url){
	//get Content
	String content = null;
	int d = depth.get(url);
	
	if(d<=dep){
	    System.out.println(url);
	    parseContent(content,d+1);
	}
    }
    
    //add url and dept
    private static synchronized void addUrl(String url,int d){
	allURL.add(url);
	unVisitURL.add(url);
	depth.put(url, d);
    }
    
    //get Un visit url
    private static synchronized String getUrl(){
	if(unVisitURL.isEmpty()){
	    return null;
	}
	return unVisitURL.remove(0);
    }
    
    //parse content and add Url with dept
    private static synchronized void parseContent(String content,int dept){
	List<String> urls = parseContentGetuRL(content);
	for(String url:urls){
	    if(!allURL.contains(url)){
		addUrl(url,dept);
	    }
	}
    }
    
    //return all urls
    private static synchronized List<String> parseContentGetuRL(String content){
	URLTest urlTest = new URLTest();
	Document doc = null;
	try
	{
	    doc = Jsoup.parse(new File("./src/jd.txt"), "UTF-8");
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	List<String> list = urlTest.getHrefByJsoup(doc.select("a[href]"));
	return list;
    }
    
    
}