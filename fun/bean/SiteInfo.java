package fun.bean;

import java.io.Serializable;
import java.util.Map;

public class SiteInfo implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 8128360550733767248L;
    
    private String siteName;
    private int siteFlag;
    private String charset;
    private int downInterval;
    private int threadNum;
    private String url;
    private int page;
    //Sub site
    private  Map<String, SiteInfo> subSite;
    
    public String getSiteName()
    {
        return siteName;
    }
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    public int getSiteFlag()
    {
        return siteFlag;
    }
    public void setSiteFlag(int siteFlag)
    {
        this.siteFlag = siteFlag;
    }
    public String getCharset()
    {
        return charset;
    }
    public void setCharset(String charset)
    {
        this.charset = charset;
    }
    public int getDownInterval()
    {
        return downInterval;
    }
    public void setDownInterval(int downInterval)
    {
        this.downInterval = downInterval;
    }
    public int getThreadNum()
    {
        return threadNum;
    }
    public void setThreadNum(int threadNum)
    {
        this.threadNum = threadNum;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public int getPage()
    {
        return page;
    }
    public void setPage(int page)
    {
        this.page = page;
    }
    public Map<String, SiteInfo> getSubSite()
    {
        return subSite;
    }
    public void setSubSite(Map<String, SiteInfo> subSite)
    {
        this.subSite = subSite;
    }
    
    
    
}
