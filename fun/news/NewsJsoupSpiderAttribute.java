package fun.news;

import java.util.List;

import org.w3c.dom.Node;

import fun.bean.NewsData;
import fun.excator.JsoupSpider;

public class NewsJsoupSpiderAttribute extends JsoupSpider<NewsData> implements NewsSpiderAttribute<NewsData>
{

    @Override
    public void parseUrl(List<NewsData> list, Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void parseContent(List<NewsData> list, Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void parseNext(List<NewsData> list, Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void parseBrief(List<NewsData> list, org.jsoup.nodes.Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void parseAuthor(List<NewsData> list, org.jsoup.nodes.Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void run()
    {
	processList();
    }

    @Override
    public void processList()
    {
//	parseUrl();
//	parseContent();
//	parseBrief();
//	parseAuthor();
//	parseNext()
    }
    
}
