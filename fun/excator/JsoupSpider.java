package fun.excator;

import fun.bean.CommonData;
import fun.bean.HtmlInfo;

public abstract class JsoupSpider<T extends CommonData> implements Spider<T>,Runnable
{
    
	@Override
	public void templateContentPage(T data, HtmlInfo html, int page, String... keyword){
	    processList();
	}

	public abstract void processList();
}
