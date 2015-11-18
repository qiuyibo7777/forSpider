package fun.bean;

public class NewsData extends CommonData
{
    /**
     * 
     */
    private static final long serialVersionUID = -4008869268616793412L;
    private String brief;
    private String pubtime;
    private String author;

    public String getBrief()
    {
	return brief;
    }

    public void setBrief(String brief)
    {
	this.brief = brief;
    }

    public String getPubtime()
    {
	return pubtime;
    }

    public void setPubtime(String pubtime)
    {
	this.pubtime = pubtime;
    }

    public String getAuthor()
    {
	return author;
    }

    public void setAuthor(String author)
    {
	this.author = author;
    }

}
