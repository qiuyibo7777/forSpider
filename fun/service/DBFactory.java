package fun.service;

public class DBFactory
{
    public static DBService getDBService(int dbType){
	switch (dbType)
	{
	case 1 : 
	case 2 : return new NewsSqlService();
	case 3 : 
	}
	return null;
    }
}
