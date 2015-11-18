package fun.bean;

import java.io.Serializable;
import java.util.Date;

//For
public class CommonData implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5730905750529478550L;
    protected int id;
    protected Date pubdate;
    protected Date inserttime;
    protected String content;
    protected int siteId;
    protected String url;
    protected String title;

    public int getId()
    {
	return id;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public Date getPubdate()
    {
	return pubdate;
    }

    public void setPubdate(Date pubdate)
    {
	this.pubdate = pubdate;
    }

    public Date getInserttime()
    {
	return inserttime;
    }

    public void setInserttime(Date inserttime)
    {
	this.inserttime = inserttime;
    }

    public String getContent()
    {
	return content;
    }

    public void setContent(String content)
    {
	this.content = content;
    }

    public int getSiteId()
    {
	return siteId;
    }

    public void setSiteId(int siteId)
    {
	this.siteId = siteId;
    }

    public String getUrl()
    {
	return url;
    }

    public void setUrl(String url)
    {
	this.url = url;
    }

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

}
