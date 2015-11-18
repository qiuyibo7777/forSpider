package fun.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import fun.bean.CommonData;

public class ParseNewsContent<NewsData> extends AbstractParseContent<NewsData> implements Runnable
{

    public ParseNewsContent(String filePath){
	super(filePath);
    }
   
    @Override
    protected void process()
    {
	Document doc = null;
	try
	{
	    doc = Jsoup.parse(new File(filePath), "UTF-8");
	    List<String> list = getHrefByJsoup(doc.select("a[href]"));
	    System.out.println("Current Thread Name:"+Thread.currentThread().getName());
	    System.out.println(getCommonDataText(doc.body().text()));
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
    }
    

    @Override
    protected void afterProcess()
    {
	
    }

    @Override
    protected void prePorcess()
    {
	
    }

    @Override
    protected List<? extends CommonData> getCommonData(String text)
    {
	
	return null;
    }

    
    private String getCommonDataText(String text)
    {
	if(text.contains("java"));{
	    return text;
	}
    }

}
