package fun.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class BloomTest
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	int size = getnNum(map);
	int t = 800000;
	int k = 10;
	int n = size * k < t ? t : size * k;// 保证在8K万以上
	double error = 0.01d;
	int m = new Double(Math.log(error) * n / (Math.log(1d - Math.pow(Math.E, -0.6d)) * 0.6)).intValue();
	System.out.println(m);
	BloomFilter<String> bloomFilters = new BloomFilter<String>(m, n);
		
	List<String> noRepeatList = new ArrayList<String>();
	for (Map.Entry<String, List<String>> ma : map.entrySet()) {
		Iterator<String> iter = ma.getValue().iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			if (bloomFilters.contains(s)) {
				System.err.println("error :  " + s + "为重复数据！");// 删除重复url？！
			} else {
			    bloomFilters.add(s);
			    noRepeatList.add(s);
			}
		}
		ma.setValue(noRepeatList);
	}
	
	for (Map.Entry<String, List<String>> ma : map.entrySet()) {
		Iterator<String> iter = ma.getValue().iterator();
		while (iter.hasNext()) {
		    System.out.println(iter.next());
		}
	}
		
    }
    
    private static int getQueryList(Map<String, List<String>> map) {
	return getnNum(map);
    }
    
    private static int getnNum(Map<String, List<String>> map){
	Map<String, List<String>> hashMap = new HashMap<String, List<String>>();
	List<String> list1 = new ArrayList<String>();
	int num = 0;
	list1.add("http://www.baidu.com/0");
	list1.add("http://www.baidu.com/1");
	list1.add("http://www.baidu.com/2");
	list1.add("http://www.baidu.com/3");
	list1.add("http://www.baidu.com/4");
	list1.add("http://www.baidu.com/5");
	list1.add("http://www.baidu.com/6");
	list1.add("http://www.baidu.com/7");
	list1.add("http://www.baidu.com/8");
	list1.add("http://www.baidu.com/9");
	list1.add("http://www.baidu.com/0");
	num = list1.size();
	map.put("baidu", list1);
	List<String> list2 = new ArrayList<String>();
	list2.add("http://www.google.com/0");
	list2.add("http://www.google.com/1");
	list2.add("http://www.google.com/2");
	list2.add("http://www.google.com/3");
	list2.add("http://www.google.com/4");
	list2.add("http://www.google.com/5");
	list2.add("http://www.google.com/6");
	list2.add("http://www.google.com/7");
	list2.add("http://www.google.com/8");
	list2.add("http://www.google.com/9");
	list2.add("http://www.google.com/0");
	num += list2.size();
	map.put("google", list2);
	return num;
    }
}
