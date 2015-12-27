package com.ezcook.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;

import com.ezcook.bean.ingredientBean;
import com.ezcook.dbconnection.dbConnection;

public class ingredientModel {
	
	
	public static String[] getField()
	{
		String[] field=new String[7];
		field[0]="id";
		field[1]="name";
		field[2]="icon";
		field[3]="price";
		field[4]="unit";
		field[5]="is_deleted";
		field[6]="last_update";
//		field[7]="quantity";
		return field;
	}
	public static JSONArray getAllIngredient()
	{
		String fields="id,name,icon,price,unit,is_deleted,last_update";
		String[] field = getField();
		dbConnection conn = new dbConnection();
		return conn.selectData(fields,"ingredient",field);
	}
	public static JSONArray getIngredientHasRecipe(int id_re)
	{
		String fields="id,name,icon,price,unit,quantity";
		String[] field=new String[6];
		field[0]="id";
		field[1]="name";
		field[2]="icon";
		field[3]="price";
		field[4]="unit";
		field[5]="quantity";
		dbConnection conn = new dbConnection();
		return conn.select2Data(fields, "ingredient","recipe_has_ingredient", field, "ingredient.id=ingredient_id and recipe_id = "+id_re);
	}
	public static ArrayList<ingredientBean> getAll()
	{
		ArrayList<ingredientBean> list=new ArrayList<ingredientBean>();		
		dbConnection db=new dbConnection();
		String fields="id,name,icon,price,unit,is_deleted,last_update";
		String[] field = getField();
		Object[][] sl=db.selectDataArrayWhere(fields,"ingredient",field,"is_deleted=0");
		for(int i=0;i<sl.length;i++)
		{
			try
			{
			ingredientBean ct=new ingredientBean();
			ct.setId(Integer.parseInt(sl[i][0]+""));
			ct.setName(sl[i][1]+"");
			ct.setIcon(sl[i][2]+"");
			ct.setPrice(Float.parseFloat(sl[i][3]+""));
			ct.setUnit(sl[i][4]+"");
			ct.setIsDel(Integer.parseInt(sl[i][5]+""));
			list.add(ct);
			}
			catch(NumberFormatException ne){}
		}
		return list;
	}
	
	public static ArrayList<ingredientBean> getWhere(int id_re)
	{
		ArrayList<ingredientBean> list=new ArrayList<ingredientBean>();		
		dbConnection db=new dbConnection();
		String fields="id,name,icon,price,unit,quantity";
		String[] field=new String[6];
		field[0]="id";
		field[1]="name";
		field[2]="icon";
		field[3]="price";
		field[4]="unit";
		field[5]="quantity";
		Object[][] sl=db.selectData2Array(fields,"ingredient","recipe_has_ingredient", field,"ingredient.id=ingredient_id and recipe_id = "+id_re);
//		System.out.println(sl.length);
		for(int i=0;i<sl.length;i++)
		{
			try
			{
			ingredientBean ct=new ingredientBean();
			ct.setId(Integer.parseInt(sl[i][0]+""));
			ct.setName(sl[i][1]+"");
			ct.setIcon(sl[i][2]+"");
			ct.setPrice(Float.parseFloat(sl[i][3]+""));
			ct.setUnit(sl[i][4]+"");
			ct.setIsDel(Integer.parseInt(sl[i][5]+""));
			ct.setQuantity(Integer.parseInt(sl[i][6]+""));
			list.add(ct);
			}
			catch(NumberFormatException ne){}
		}
		return list;
	}
	public static int EditIngredient(ingredientBean in)
	{
		dbConnection db=new dbConnection();
   	 	Date now=new Date();
   	 	String last_update=now.getYear()+"-"+now.getMonth()+"-"+now.getDay();
		String values = "name =N'"+in.getName()+"',price = "+in.getPrice()+",unit='"+in.getUnit()+"',"+"last_update = \""+last_update+"\"";
		System.out.println(values);
		return db.editData("ingredient",values ,"id = "+in.getId());
	}
	public static ArrayList<ingredientBean> searchData(String values)
	{
		ArrayList<ingredientBean> lstSearch = new ArrayList<ingredientBean>();
		String fields="name";
		String[] field = getField();
		dbConnection db = new dbConnection();
		Object ob[][]= db.searchData(fields, "ingredient", field, values);
		for(int i = 0;i<ob.length;i++){
			ingredientBean in = new ingredientBean();
			in.setName(ob[i][0]+"");
			lstSearch.add(in);
		}
		return lstSearch;

	}
	public static int DelIngredient(int id)
	{
		dbConnection db = new dbConnection();
		return db.deleteData("ingredient"," id = "+id);
	}
	public static int InsertIngredient(ingredientBean in)
	{
		dbConnection db = new dbConnection();
		String fields="name,icon,price,unit,last_update";
   	 	Date now=new Date();
   	 	String last_update=now.getYear()+"-"+now.getMonth()+"-"+now.getDay();
		String values="N'"+in.getName()+"',"+in.getIcon()+","+in.getPrice()+",'"+in.getUnit()+"',\""+last_update+"\"";
		return db.insertData("ingredient", fields, values);
	}
}
