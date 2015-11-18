package fun.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLTest
{

    // private static Set visitedUrl = new HashSet();
    // private static Queue<String> unVisitedUrl = new PriorityQueue<>();
    //
    // public static Queue getUnVisitedUrl() {
    //
    // return unVisitedUrl;
    // }
    //
    // public static void addVisitedUrl(String url) {
    // visitedUrl.add(url);
    // }
    //
    // public static void removeVisitedUrl(String url) {
    // visitedUrl.remove(url);
    // }
    //
    // public static Object unVisitedUrlDeQueue() {
    // return unVisitedUrl.poll();
    // }
    //
    public static void main(String[] args) throws IOException
    {
	Document  doc = Jsoup.parse(new File("./src/fun.txt"), "UTF-8");
	doc = Jsoup.parse(new File("./src/fun.txt"), "UTF-8");
	List<String> list = getHrefByJsoup(doc.select("a[href]"));
	
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	map.put(doc.title(), list);
	int size = list.size();
	int t = 800000;
	int k = 10;
	int n = size * k < t ? t : size * k;// 保证在8K万以上
	double error = 0.01d;
	int m = new Double(Math.log(error) * n / (Math.log(1d - Math.pow(Math.E, -0.6d)) * 0.6)).intValue();
	System.out.println(m);
	BloomFilter<String> bloomFilters = new BloomFilter<String>(m, n);

	List<String> repeatList = new ArrayList<String>();
	for (Map.Entry<String, List<String>> ma : map.entrySet())
	{
	    Iterator<String> iter = ma.getValue().iterator();
	    System.out.println("Before BloomFilter:" + ma.getValue().size());
	    int i = 0;
	    while (iter.hasNext())
	    {
		String s = iter.next();
		if (bloomFilters.contains(s))
		{
		    repeatList.add(s);
		    System.err.println(i++ + "error :  " + s + "为重复数据！");// 删除重复url？！
		}
		else
		{
		    bloomFilters.add(s);
		}
	    }
	    ma.getValue().removeAll(repeatList);
	    System.out.println("After BloomFilter:" + ma.getValue().size());
	}

	ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

	for (String l : repeatList)
	{
	    new Thread(new Producer(queue, l)).start();
	    new Thread(new Consumer(queue)).start();
	}

    }
    
    private static String getContent()
    {
	String content = null;
	String url = "http://www.baidu.com/";
	HttpParams params = new BasicHttpParams();
	HttpConnectionParams.setConnectionTimeout(params, 10 * 1000);
	HttpConnectionParams.setSoTimeout(params, 10 * 1000);
	AbstractHttpClient httpClient = new DefaultHttpClient(params);
	HttpGet getHttp = new HttpGet(url);
	getHttp.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:16.0) Gecko/20100101 Firefox/16.0");
	HttpResponse response;
	try
	{
	    response = httpClient.execute(getHttp);
	    HttpEntity entity = response.getEntity();
	    if (entity != null)
	    {
		content = EntityUtils.toString(entity, "UTF-8");
		System.out.println(content);
	    }
	}
	catch (ClientProtocolException e)
	{
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	return content;
    }
    
    
    static List<String> getHrefByJsoup(Elements elements){
	List<String> list = new ArrayList<String>();
	for (Element link1 : elements)
	{
	    String linkString = link1.attr("abs:href");
	    if (!StringUtil.isBlank(linkString))
		list.add(linkString);
	}
	return list;
    }
    
}



//Producer and Customer
class Producer implements Runnable
{

    private ArrayBlockingQueue<String> queue;
    private String link;

    public Producer(ArrayBlockingQueue<String> queue, String link)
    {
	this.queue = queue;
	this.link = link;
    }

    @Override
    public void run()
    {
	String str = "producer:" + link;
	System.out.println(str);
	queue.add(str);
    }
}

class Consumer implements Runnable
{
    private ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue)
    {
	this.queue = queue;
    }

    @Override
    public void run()
    {
	try
	{
	    System.out.println("Get:" + queue.take());
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
    }

}
