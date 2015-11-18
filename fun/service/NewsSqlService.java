package fun.service;

import java.io.IOException;

import org.apache.log4j.Logger;

public class NewsSqlService<NewsData> extends AbstractMySqlService<NewsData>
{

    private final Logger logger = Logger.getLogger(NewsSqlService.class);
    
    @Override
    public void saveData(Object t) throws IOException
    {
//	this.jdbcTemplate.update();
	logger.info("hehe da");
    }
    
}
