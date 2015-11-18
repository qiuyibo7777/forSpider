package fun.service;

import java.io.IOException;
import java.util.List;

public class AbstractOracelSqlService<T> implements DBService<T>
{

    @Override
    public void saveLog(String siteFlag, int logType, String... info) throws IOException
    {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void saveDatas(List<T> list) throws IOException
    {
	
    }

    @Override
    public void saveData(Object t) throws IOException
    {
	
    }
    
}
