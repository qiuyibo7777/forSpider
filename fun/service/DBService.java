package fun.service;

import java.io.IOException;
import java.util.List;

public interface DBService<T>
{
    
	public void saveLog(String siteFlag, int logType, String... info) throws IOException;
	
	public void saveData(T t) throws IOException;

	public void saveDatas(List<T> list) throws IOException;
	
}
