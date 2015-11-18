package fun.news;

import java.util.List;

import org.jsoup.nodes.Node;

import fun.bean.CommonData;
import fun.excator.SpiderAttribute;

public interface NewsSpiderAttribute<T extends CommonData> extends SpiderAttribute<T> 
{
	public void parseBrief(List<T> list, Node dom,String... args);
	public void parseAuthor(List<T> list, Node dom,String... args);
}
