<%@page import="com.ezcook.model.ingredientModel"%>
<%@page import="com.ezcook.bean.ingredientBean"%>
<%@page import="com.ezcook.model.categoryModel"%>
<%@page import="com.ezcook.bean.categoryBean"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="com.ezcook.model.recipeModel"%>
<%@page import="com.ezcook.bean.recipeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
ArrayList<recipeBean> list_recipe= recipeModel.getAll();
ArrayList<categoryBean> list_cat=categoryModel.getAll();
ArrayList<ingredientBean> list_in = ingredientModel.getAll();

%>

<html>
    <head >
    		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
		<link rel="stylesheet" href="style-new.css" type="text/css" charset="utf-8" >
		<script language="javascript" src="script.js"/></script>
				<h1>Nhập Dữ Liệu: <h1>
		
    </head>

    
    <body>
        <%
    int pos = -1;
    int id_re = -1;
    int catId=2;
    String nameRe ="", nameCat="",made_in="",processing="",image="",last_update="",function="add",selec="";
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
    if(request.getParameter("function")!=null)
    {
    	function=request.getParameter("function");
    }
	

	%>
    
		<a href="ingredient.jsp"/> Thực Phẩm</a>    
				<a href="recipe.jsp"/> Món Ăn</a>    
	<form name="adminrecipe" action="admin_recipe.do" method="post">
			<table border="0">
		            	<tr>
                    <td><input  type="hidden" name="function" value="<%=function %>"/></td>
                    <td><input type="hidden" name="id_re" value="<%=id_re+""%>"/></td>
                </tr>
		
					 <tr><td>Tên Món Ăn</td><td><input type="text" name="nameRe"  value="<%=nameRe%>" /></td></tr>
					<tr><td>Cách Làm:</td><td><textarea name="processing" cols="50" rows="5" value="<%=processing%>" > <%=processing %></textarea></td></tr>
					  <tr><td>Xuất xứ </td><td><input type="text" name="made_in" value="<%=made_in%>"  /></td></tr>
					 <tr><td>Lần Cập Nhật Cuối<td><td><%=last_update %></td></tr>
					 <tr><td>Chọn Món Ăn:</td><td><input list = "list_ingre" type="text" name="ingredient" onChange=""/>
					 						                <datalist id = "list_ingre" >
															 <%for(int j=0;j<list_in.size();j++)
												        		{ 
												        		%><option value="<%=list_in.get(j).getName() %>">
												        		<% 
																 
												        		} %>
					 				                
					 				                </datalist></td></tr>
					 <tr><td>Món Ăn Đã Chọn:</td><td></td></tr>
					 
					 <tr><td>Tải ảnh:</td><td> <input type="file" name="icon"  /></td></td></tr>
					 <tr><td> <select name = "id_cat">
					 <%for(int j=0;j<list_cat.size();j++)
		        		{ 
						 if(list_cat.get(j).getId()==catId)
						 {
		        		%><option value="<%=list_cat.get(j).getId() %>" selected=selected ><%=list_cat.get(j).getName()%></option>
		        		<% 
						 }
						 else
						 {%>
							 <option value="<%=list_cat.get(j).getId() %>"  ><%=list_cat.get(j).getName()%></option>
							 <% }
		        		} %>
		        		<!-- <option selected=""></option> -->
					 </select></td></tr>
				<tr>
				    <td >
                        <input id="add" type="submit" value="Thêm" onClick="function='add'">
                        <input type="submit" value="Sửa" onClick="function='edit'">
                    </td>
				</tr>
				 </table>
		</form>

		<div>
		<table border="1">
			<tr>
				<th>STT</th>
				<th>Tên Món Ăn</th>
				<th>Xuất sứ</th>
				<th>Cách Làm</th>
				<th>Lần Cập Nhật Cuối</th>
				<th>Tên Loại Món Ăn</th>
				
			</tr>
			<%
			for(int i=0;i<list_recipe.size();i++)
        		{
			%>
			<tr>
				<td><%=i+1%></td>
				<td><%=list_recipe.get(i).getName()%></td>
				<td><%=list_recipe.get(i).getMade_in()%>
				<td><%=list_recipe.get(i).getProcessing()%>
				<td><%=list_recipe.get(i).getLast_update()%>
				<td><%=list_recipe.get(i).getNameCat()%></td>
				<td><a href="recipe.jsp?function=edit&pos=<%=i%>">Sửa</a>
				/<a href="recipe-details.jsp?pos=<%=i%>">Chi tiết</a>
				/<a href="admin_recipe.do?function=del&id=<%=list_recipe.get(i).getId() %>">Xóa</a></td>
			</tr>
			<%} %>
		</table>
		</div>
</body>
</html>