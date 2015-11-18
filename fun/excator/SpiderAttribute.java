package fun.excator;

import java.util.List;

import org.w3c.dom.Node;

public interface SpiderAttribute<T>
{
	public void parseUrl(List<T> list, Node dom,String... args);

	public void parseContent(List<T> list, Node dom,String... args);

	public void parseNext(List<T> list, Node dom,String... args);

}
