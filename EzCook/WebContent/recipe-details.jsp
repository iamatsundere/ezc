<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.ezcook.model.ingredientModel"%>
<%@page import="com.ezcook.bean.ingredientBean"%>
<%@page import="com.ezcook.model.categoryModel"%>
<%@page import="com.ezcook.bean.categoryBean"%>
<%@page import="com.ezcook.model.recipeModel"%>
<%@page import="com.ezcook.bean.recipeBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết món ăn</title>
</head>
<body>
    <%
	ArrayList<recipeBean> list_recipe= recipeModel.getAll();
	ArrayList<categoryBean> list_cat=categoryModel.getAll();
	ArrayList<ingredientBean> list_infull=ingredientModel.getAll();
    int pos = -1,position=-1;
    int id_re = -1,id_in=-1;
    int catId=2;
    float quantity = 0;
    String nameRe ="", nameIn="",nameCat="",made_in="",processing="",image="",last_update="",function="add",selec="";

    if(request.getParameter("pos")!=null)
    {
  		pos=Integer.parseInt(request.getParameter("pos"));

    }

    if(pos>=0)
    {
    	id_re=list_recipe.get(pos).getId();

    	nameRe=list_recipe.get(pos).getName();
    	nameCat=list_recipe.get(pos).getNameCat();
    	made_in=list_recipe.get(pos).getMade_in();
    	processing=list_recipe.get(pos).getProcessing();
    	last_update=list_recipe.get(pos).getLast_update();
    	catId=list_recipe.get(pos).getIdCat();
    }

	ArrayList<ingredientBean> list_in = ingredientModel.getWhere(id_re);

    	if(request.getParameter("position")!=null)
    	{
    		position=Integer.parseInt(request.getParameter("position"));
    	}
    	if(position>=0)
    	{
        	quantity = list_in.get(position).getQuantity();
        	nameIn = list_in.get(position).getName();

    	}
    		
    	


    
    if(request.getParameter("function")!=null)
    {
    	function=request.getParameter("function");
    }
	

	%>
		<form name="recipe_has_ingredient" action="recipe_has_ingredient" method="post">
			<table border="0">
		            	<tr>
                    <td><input type="hidden" name="id_re" value="<%=id_re+""%>"/></td>
                    <td><input type="hidden" name="pos" value="<%=pos+""%>"/></td>
                    
                </tr>
		
					 <tr><td>Tên Món Ăn: </td><td><%=nameRe%> </td></tr>
					 <tr><td>Lần Cập Nhật Cuối<td><td><%=last_update %></td></tr>
					 <tr><td>Chọn nguyên liệu:</td><td><input list = "list_ingre" type="text" name="ingredient"/>
					 						                <datalist id = "list_ingre" >
															 <%for(int j=0;j<list_infull.size();j++)
												        		{ 
												        		%><option value="<%=list_infull.get(j).getId()%>">
												        			<%=list_infull.get(j).getName()
												        			%>
												        		</option>
												        		<% 
																 
												        		} %>
												        	</datalist></td></tr>
												        					 </select></td></tr>
												        		
					 	<tr><td>Số lượng: </td><td><input type="number" name="quantity" value="<%=quantity %>"/></td></tr>
		        		<!-- <option selected=""></option> -->
				<tr>
				    <td >
                        <input id="add" type="submit" value="Thêm" onClick="function='add'">
                        <input type="submit" value="Sửa" onClick="function='edit'">
                        <td><input  type="hidden" name="function" value="<%=function %>"/></td>
                        
                    </td>
				</tr>
				 </table>
		</form>
	
<div>			 
		</div>	
				<table border="1">
			<tr>
				<th>STT</th>
				<th>Tên Nguyên Liệu</th>
				<th>Gía Nguyên Liệu</th>
				<th>Đơn vị</th>
				<th>So luong</th>
				
			</tr>
			<%
			for(int i=0;i<list_in.size();i++)
        		{
			%>
			<tr>
				<td><%=i+1%></td>
				<td><%=list_in.get(i).getName()%></td>
				<td><%=list_in.get(i).getPrice()%></td>
				<td><%=list_in.get(i).getUnit()%></td>
				<td><%=list_in.get(i).getQuantity() %></td>
				<td><a href="recipe-details.jsp?pos=<%=pos%>&position=<%=i%>">Sửa</a>
				/<a href="recipe_has_ingredient?function=del&id_re=<%=id_re%>&pos=<%=pos %>&id_in=<%=list_in.get(i).getId()%>">Xóa</a></td>
			</tr>
			<%} %>
		</table>
		

</body>
</html>