package fun.shopSite;

import java.util.List;

import org.w3c.dom.Node;

import fun.bean.ShopSiteData;
import fun.excator.JsoupSpider;

public class ShopSiteJsoupSpiderAttribute extends JsoupSpider<ShopSiteData> implements ShopSiteSpiderAttribute<ShopSiteData>
{

    @Override
    public void parseUrl(List<ShopSiteData> list, Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void parseContent(List<ShopSiteData> list, Node dom, String... args)
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void parseNext(List<ShopSiteData> list, Node dom, String... args)
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
	
    }
    
}
