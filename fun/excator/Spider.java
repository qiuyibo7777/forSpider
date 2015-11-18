package fun.excator;

import fun.bean.HtmlInfo;

public interface Spider<T>
{
	
	public void templateContentPage(T data, HtmlInfo html, int page, String... keyword);

}
