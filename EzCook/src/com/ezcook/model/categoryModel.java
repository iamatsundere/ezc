package com.ezcook.model;

import java.util.ArrayList;

import org.json.JSONArray;

import com.ezcook.bean.categoryBean;
import com.ezcook.bean.ingredientBean;
import com.ezcook.dbconnection.dbConnection;


public class categoryModel {
	public static JSONArray getLoaiMonAn()
	{
		String fields="id,name";
		String[] field=new String[2];
		field[0]="id";
		field[1]="name";
		dbConnection conn = new dbConnection();
//		System.out.println(conn.selectData(fields, "loaimonan", field)+"");
		return conn.selectData(fields, "category", field);
	}
	public static ArrayList<categoryBean> getAll()
	{
		ArrayList<categoryBean> list=new ArrayList<categoryBean>();		
		dbConnection db=new dbConnection();
		String fields="id,name";
		String[] field=new String[2];
		field[0]="id";
		field[1]="name";
		Object[][] sl=db.selectDataArray(fields, "category", field);
		for(int i=0;i<sl.length;i++)
		{
			try
			{
				categoryBean ct=new categoryBean();
			ct.setId(Integer.parseInt(sl[i][0]+""));
			ct.setName(sl[i][1]+"");
			list.add(ct);
			}
			catch(NumberFormatException ne){}
			
		}
		return list;
	}

	public static void insertData(String value)
	{
		String fields="category";
		String[] field=new String[1];
		field[0]="name";
		dbConnection conn = new dbConnection();
		conn.insertData("category", fields, value);
	}
}
