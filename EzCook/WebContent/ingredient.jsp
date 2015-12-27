<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>

<%@page import="com.ezcook.model.ingredientModel"%>
<%@page import="com.ezcook.bean.ingredientBean"%>
<%@page import="java.util.ArrayList"%>
	
	<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>

<html>
    <head >
    		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
		<link rel="stylesheet" href="style-new.css" type="text/css" charset="utf-8" >
		<script language="javascript" src="script.js"/></script>
				<h1>Nhập Dữ Liệu: <h1>
		
    </head>
    <body>
		<a href="ingredient.jsp"/> Thực Phẩm</a>    
				<a href="recipe.jsp"/> Món Ăn</a>    
		
	
    <%
	ArrayList<ingredientBean> list_intgerdient = ingredientModel.getAll(); 

    int pos=-1;
    int id_in=0;
    String ten_in="";
    float gia_in=0;
    String unit_in="";
    String last_update="";
    String icon="";
    String function = "add";
	String disabled_add="";
	String disabled_edit="disabled";

    if(request.getParameter("pos")!=null)
    {
  		pos=Integer.parseInt(request.getParameter("pos"));

    }
    if(pos>=0)
    {
		id_in=list_intgerdient.get(pos).getId();
    
    	gia_in=list_intgerdient.get(pos).getPrice();
    	ten_in=list_intgerdient.get(pos).getName();
    	unit_in=list_intgerdient.get(pos).getUnit();
    }

    if(request.getParameter("function")!=null)
    {
    	function=request.getParameter("function");
    }
    %>
		<form name="admin" action="admin_ingredient.do" method="post">
			<table border="0">
		            	<tr>
                    <td><input type="hidden" name="function" value="<%=function %>"/></td>
                    <td><input type="hidden" name="id_in" value="<%=id_in+"" %>"/></td>
                </tr>
		
					 <tr><td>Tên nguyên liệu</td><td><input type="text" name="name_in"  value="<%=ten_in%>" /></td></tr>
					 <tr><td>Giá </td><td><input type="text" name="price_in" value="<%=gia_in%>"  /></td></tr>
					  <tr><td>Đơn vị </td><td><input type="text" name="unit_in" value="<%=unit_in%>"  /></td></tr>
					 <tr><td>Lần Cập Nhật Cuối<td><td><%=last_update %></td></tr>
					 <tr><td>Ảnh</td><td><input type="file" name="icon"  /></td></tr>
				<tr>	 
				    <td >
                        <input id="add" type="submit" value="Thêm" onClick="function='add'">
                        <input type="submit" value="Sửa" onClick="function='add'">
                    </td>
				</tr>
				 </table>
				 			</form>
				 
		<table border="1">
			<tr>
				<th>STT</th>
				<th>Tên Nguyên Liệu</th>
				<th>Gía Nguyên Liệu</th>
				<th>Đơn vị</th>
				
			</tr>
			<%
			for(int i=0;i<list_intgerdient.size();i++)
        		{
			%>
			<tr>
				<td><%=i+1%></td>
				<td><%=list_intgerdient.get(i).getName()%></td>
				<td><%=list_intgerdient.get(i).getPrice()%></td>
				<td><%=list_intgerdient.get(i).getUnit()%></td>
				<td><a href="ingredient.jsp?function=edit&pos=<%=i%>">Sửa</a>
				/<a href="admin_ingredient.do?function=del&id=<%=list_intgerdient.get(i).getId() %>">Xóa</a></td>
			</tr>
			<%} %>
		</table>
    </body>
</html>