package fun.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fun.bean.CommonData;

public abstract class AbstractParseContent<NewsData> implements Runnable
{
    protected final String filePath;

    protected List<String> getHrefByJsoup(Elements elements)
    {
	List<String> list = new ArrayList<String>();
	for (Element link1 : elements)
	{
	    String linkString = link1.attr("abs:href");
	    if (!StringUtil.isBlank(linkString))
		list.add(linkString);
	}
	return list;
    }
    
    public AbstractParseContent(String filePath)
    {
	this.filePath = filePath;
    }

    @Override
    public void run()
    {
	prePorcess();
	process();
	afterProcess();
    }

    protected abstract List<? extends CommonData> getCommonData(String text);
    
    protected abstract void process();

    protected abstract void afterProcess();

    protected abstract void prePorcess();

}
