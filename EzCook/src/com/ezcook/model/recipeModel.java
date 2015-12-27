package com.ezcook.model;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;

import com.ezcook.bean.ingredientBean;
import com.ezcook.bean.recipeBean;
import com.ezcook.dbconnection.dbConnection;

public class recipeModel {
	public static String[] getField()
	{
		String[] field=new String[9];
		field[0]="recipe.id";
		field[1]="recipe.name";
		field[2]="made_in";
		field[3]="processing";
		field[4]="image";
		field[5]="category_id";
		field[6]="is_deleted";
		field[7]="last_update";
		field[8]="category.name";
		return field;
	}

	/**
	 * @return
	 */
	public static JSONArray getAllRecipe()
	{
		String fields="id,name,made_in,processing,image,category_id,is_deleted,last_update";
		String[] field=new String[8];
		field[0]="id";
		field[1]="name";
		field[2]="made_in";
		field[3]="processing";
		field[4]="image";
		field[5]="category_id";
		field[6]="is_deleted";
		field[7]="last_update";
		dbConnection conn = new dbConnection();
		return conn.selectData(fields,"recipe",field);
	}
	public static ArrayList<recipeBean> getAll()
	{
		ArrayList<recipeBean> list=new ArrayList<recipeBean>();		
		dbConnection db=new dbConnection();

		String fields="recipe.id,recipe.name,made_in,processing,image,category_id,is_deleted,last_update,category.name";
		String[] field=new String[9];
		field = getField();
		Object[][] sl=db.selectData2Array(fields, "recipe","category", field, "category_id = category.id");
//		System.out.println(sl.length);

		for(int i=0;i<sl.length;i++)
		{
			try
			{
			recipeBean ct=new recipeBean();
			ct.setId(Integer.parseInt(sl[i][0]+""));
			ct.setName(sl[i][1]+"");
			ct.setMade_in(sl[i][2]+"");
			ct.setProcessing(sl[i][3]+"");
			ct.setimage(sl[i][4]+"");
			ct.setIdCat(Integer.parseInt(sl[i][5]+""));
			ct.setIs_del(Integer.parseInt(sl[i][6]+""));
			ct.setLast_update(sl[i][7]+"");
			ct.setNameCat(sl[i][8]+"");
			list.add(ct);

			}
			catch(NumberFormatException ne){}
		}
		return list;
	}
	public static int EditRecipe(recipeBean in)
	{
		dbConnection db=new dbConnection();
   	 	Date now=new Date();
   	 	String last_update=now.getYear()+"-"+now.getMonth()+"-"+now.getDay();
		String values = "name =N'"+in.getName()+"', made_in =N'"+in.getMade_in()+" ',processing ='"+in.getProcessing()+"',category_id = "+in.getIdCat()+",last_update=\""+last_update+"\"";
		System.out.println(values);
		return db.editData("recipe",values ,"id = "+in.getId());
		

	}
	public static int DelRecipe(int id)
	{
		dbConnection db = new dbConnection();
		return db.deleteData("recipe"," id = "+id);
	}
	public static int InsertRecipe(recipeBean in)
	{
		dbConnection db = new dbConnection();
		String fields="name,made_in,processing,category_id,last_update";
   	 	Date now=new Date(System.currentTimeMillis());
   	 	String last_update=now.getYear()+"-"+now.getMonth()+"-"+now.getDay();
		String values="N'"+in.getName()+"',N'"+in.getMade_in()+"','"+in.getProcessing()+"',"+in.getIdCat()+",\""+last_update+"\"";
		return db.insertData("recipe", fields, values);
	}
// recipe_has_ingredient
	public static int AddIngre(int id_re, int id_in,float quantity)
	{
		dbConnection db = new dbConnection();
		String fields = "recipe_id,ingredient_id,quantity";
		String values =id_re+","+id_in+","+quantity;
		return db.insertData("recipe_has_ingredient", fields, values);
	}
	public static int DelIngre(int id_re, int id_in)
	{
		dbConnection db = new dbConnection();
		String where ="recipe_id= "+id_re+" and ingredient_id="+id_in;
		return db.delData("recipe_has_ingredient", where);
	}
	public static int EditIngre(int id_re, int id_in,float quantity)
	{
		dbConnection db = new dbConnection();
		String values = "quantity = "+quantity;
		String where ="recipe_id= "+id_re+" and ingredient_id="+id_in;
		return db.editData("recipe_has_ingredient", values, where);
	}

}
