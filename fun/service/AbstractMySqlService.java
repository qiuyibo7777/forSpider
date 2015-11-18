package fun.service;

import java.io.IOException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


public abstract class AbstractMySqlService<T> implements DBService<T>
{
    protected JdbcTemplate jdbcTemplate;
    
    @Override
    public void saveLog(String siteFlag, int logType, String... info) throws IOException
    {
	// TODO Auto-generated method stub
//	this.jdbcTemplate.update();
	
    }

    
    @Override
    public void saveDatas(List<T> list) throws IOException
    {
	for(T data:list){
	    saveData(data);
	}
    }
    
}
