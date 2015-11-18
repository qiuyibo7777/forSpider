package fun.service;

import java.sql.Connection;

public class DBConnection
{
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    
    private DBConnection(){}
    
    public Connection getConnection(){
	Connection connection = threadLocal.get();
	return connection;
    }
    
    public void disConnection(){
	
    }
    
    public void setAutoCommit(){
	
    }
    
    public void commit(){
	
    }
    
    public void close(){
    }
    
    public void rollback(){
	
    }
}

