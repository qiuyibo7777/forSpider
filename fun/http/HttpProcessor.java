package fun.http;

import fun.bean.HtmlInfo;

public interface HttpProcessor
{
	public void getContent(HtmlInfo html);
	
	public void setHttpCliet(HtmlInfo html);
}
