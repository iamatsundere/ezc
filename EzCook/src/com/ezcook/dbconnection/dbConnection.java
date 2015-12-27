package com.ezcook.dbconnection;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class dbConnection
{
	 public Statement sta;
	   public ResultSet rs;
	   public Connection conn;
	   private String host;
	   private String port;
	   private String dbName;
	   private String userName;
	   private String password;
	 
	   public  dbConnection() {
		   readConfig();
		   connect();
	   }
	   public void readConfig()
	   {
		   Properties prop=new Properties();
		   InputStream input=null;
		   try
	   	{
	   		input=this.getClass().getClassLoader().getResourceAsStream("../config/db.properties");
	   		prop.load(input);
	   		host=prop.getProperty("host");
	   		port=prop.getProperty("port");
	   		dbName=prop.getProperty("dbName");
	   		userName=prop.getProperty("userName");
	   		password=prop.getProperty("password");
		       System.out.println("ket noi r");

	   	}
	   	catch(Exception ex)
	   	{
	   		ex.printStackTrace();
	   		System.out.println("--------------------------------CONNECT DATABASE ERR");
	   	}
	   	finally
	   	{
	   		if(input!=null)
	   		{
	   			try{
	   				input.close();
	   			}
	   			catch(Exception ex)
	   			{
	   				ex.printStackTrace();
	   			}
	   		}
	   	}
		  
		   
	   }
	   public void connect()
	   {
	   	String url="jdbc:mysql://"+host+":"+port+"/";
	   	String driver="com.mysql.jdbc.Driver";
	   	  try
	  	   {
	  		   Class.forName(driver).newInstance();
	  		   conn=DriverManager.getConnection(url+dbName, userName, password);
//	  		System.out.println("dbConnection.connect()");
	  	   }
	  	   catch(Exception ex)
	  	   {
	  		  System.out.println("Err"+ex);
	  	   }	
	   }
		public Object[][] selectData2Array(String fields, String tableName1,String tableName2, String[] field,String where)
		{
			try
			{

				int count=0;				

				Statement statement = conn.createStatement(); 
				ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName1+" INNER JOIN "+tableName2+" ON "+where+" where is_deleted =0");
			    while(resultSet_count.next()){
			    count = resultSet_count.getInt("Rows");
			    }
			    System.out.println(count+"");

			    resultSet_count.close();
				ResultSet resultSet = statement  
	                    .executeQuery("SELECT "+fields+" FROM  "+tableName1+" INNER JOIN "+tableName2+" ON "+where +" where is_deleted=0"); 
				Object[][] data = new Object[count][field.length]; 

		        int row=0;
		        while (resultSet.next()) { 
		        	 for(int i=0;i<field.length; i++)
		        	 {
		        		 data[row][i] = resultSet.getString(field[i]);
		        	 }
		        	 row++;
		        }  
		       resultSet.close();
		       statement.close();
		       conn.close();
		        return data; 
			}
			catch(Exception ex){ 
				System.out.println("loi roi");
		       	return null;
		    } 
		}
		public Object[][] selectDataArray(String fields, String tableName, String[] field)
		{
			try
			{
				int count=0;
				Statement statement = conn.createStatement(); 
				ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName);
			    while(resultSet_count.next()){
			    count = resultSet_count.getInt("Rows");
			    }
			    resultSet_count.close();
				ResultSet resultSet = statement  
	                    .executeQuery("SELECT "+fields+" FROM  "+tableName); 
				Object[][] data = new Object[count][field.length];  
		        int row=0;
		        while (resultSet.next()) { 
		        	 for(int i=0;i<field.length; i++)
		        	 {
		        		 data[row][i] = resultSet.getString(field[i]);
		        	 }
		        	 row++;
		        }  
		       resultSet.close();
		       statement.close();
		       conn.close();
		        return data; 
			}
			catch(Exception ex){ 
		       	return null;
		    } 
		}
		public Object[][] searchData(String fields, String tableName, String[] field,String search)
		{
			try
			{
				int count=0;
				Statement statement = conn.createStatement(); 
				ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName);
			    while(resultSet_count.next()){
			    count = resultSet_count.getInt("Rows");
			    }
			    resultSet_count.close();
				ResultSet resultSet = statement  
	                    .executeQuery("SELECT "+fields+" FROM  "+tableName+" where "+fields +" like "+search+"%"); 
				Object[][] data = new Object[count][field.length];  
		        int row=0;
		        while (resultSet.next()) { 
		        	 for(int i=0;i<field.length; i++)
		        	 {
		        		 data[row][i] = resultSet.getString(field[i]);
		        	 }
		        	 row++;
		        }  
		       resultSet.close();
		       statement.close();
		       conn.close();
		        return data; 
			}
			catch(Exception ex){ 
		       	return null;
		    } 
		}


	public Object[][] selectDataArrayWhere(String fields, String tableName, String[] field,String where)
	{
		try
		{
			int count=0;
			Statement statement = conn.createStatement(); 
			ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName+" where is_deleted=0");
		    while(resultSet_count.next()){
		    count = resultSet_count.getInt("Rows");
		    }
		    resultSet_count.close();
			ResultSet resultSet = statement  
                    .executeQuery("SELECT "+fields+" FROM  "+tableName+" WHERE "+where); 
			Object[][] data = new Object[count][field.length];  
	        int row=0;
	        while (resultSet.next()) { 
	        	 for(int i=0;i<field.length; i++)
	        	 {
	        		 data[row][i] = resultSet.getString(field[i]);
//	     		    System.out.println(data[row][i]+"");
	        	 }
	        	 row++;
	        }  
	       resultSet.close();
	       statement.close();
	       conn.close();
	        return data; 
		}
		catch(Exception ex){ 
	       	return null;
	    } 
	}
public JSONArray selectData(String fields, String tableName, String[] field)	
{
	JSONArray list=new JSONArray();
	try
	{

		 sta = conn.createStatement();
		rs=sta.executeQuery("SELECT "+fields+" FROM "+tableName+" where is_deleted=0");
		System.out.println(rs+"");
		while(rs.next())
		{
			
			JSONObject json=new JSONObject();
			for(int i =0;i<field.length;i++)
			{			
				
				json.put(field[i], rs.getString(field[i]));
			}
			list.put(json);
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return list;
}
public JSONArray select2Data(String fields,String tableName1, String tableName2, String[] field,String where)	
{
	JSONArray list=new JSONArray();
	try
	{

		 sta = conn.createStatement();
//         .executeQuery(); 

		rs=sta.executeQuery("SELECT "+fields+" FROM  "+tableName1+" INNER JOIN "+tableName2+" ON "+where +" where is_deleted=0");
		System.out.println(rs+"");
		while(rs.next())
		{
			
			JSONObject json=new JSONObject();
			for(int i =0;i<field.length;i++)
			{			
				
				json.put(field[i], rs.getString(field[i]));
			}
			list.put(json);
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return list;
}

public JSONArray selectDataWhere(String fields, String tableName, String[] field,String where)	
{
	JSONArray list=new JSONArray();
	try
	{
		 sta = conn.createStatement();
		rs=sta.executeQuery("SELECT "+fields+" FROM "+tableName+" WHERE "+where+" and is_deleted=0");
		System.out.println(rs+"");
		while(rs.next())
		{
			
			JSONObject json=new JSONObject();
			for(int i =0;i<field.length;i++)
			{			
				
				json.put(field[i], rs.getString(field[i]));
			}
			list.put(json);
//			System.out.println(list+"");
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return list;
}
//them
public int insertData(String tblName, String fields, String values)
{
	try { 
		Statement statement = conn.createStatement(); 
		statement.executeUpdate("INSERT INTO " +tblName+" ( "+fields+" )"+" VALUES ( "+ 
            values+" )"); 
        statement.close();
        conn.close(); 
        return 1;
    } catch (Exception e) { 
    	System.out.println("ss"+e);
    	return 0;
    } 
}
//edit
public int editData(String tblName, String values, String where)
{
	try { 
//    	Statement statement = conn.createStatement(); 
		String query = "update "+tblName+" set "+values+" where "+where;
		PreparedStatement  update= conn.prepareStatement(query);
		update.executeUpdate();
		update.close();
//		statement.execute(query);
//		statement.close();
        conn.close(); 
        return 1;
    } catch (Exception e) { 
    	return 0;
    } 
}
//xoa
public int deleteData(String tblName, String where)
{
	String query= "update "+tblName+" set is_deleted = 1 where "+where;
    try {
    	Statement statement = conn.createStatement(); 
    	statement.execute(query);
    	statement.close();
        conn.close();
        return 1;
    } catch (Exception ex) {
        return 0;
    }
}
    public int delData(String tblName, String where)
    {
    	String query= "delete from "+tblName+" where "+where;
        try {
        	Statement statement = conn.createStatement(); 
        	statement.execute(query);
        	statement.close();
            conn.close();
            return 1;
        } catch (Exception ex) {
            return 0;
        }
}

}

