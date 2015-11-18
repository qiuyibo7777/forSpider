package fun.test;

import fun.bean.NewsData;

public class ContentTest
{
    public static void main(String[] args)
    {
	String filePath = "./src/content.txt";
	ParseNewsContent<NewsData> parseNewsContent = new ParseNewsContent<NewsData>(filePath);
	parseNewsContent.process();
    }
}
