package com.ezcook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezcook.bean.recipeBean;
import com.ezcook.model.recipeModel;

/**
 * Servlet implementation class recipe_has_ingredient
 */
public class recipe_has_ingredient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recipe_has_ingredient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int pos = Integer.parseInt(request.getParameter("pos"));
		int id_re;
		int id_in;
		if(request.getParameter("function").equals("del"))
		{
			id_re = Integer.parseInt(request.getParameter("id_re"));
			id_in = Integer.parseInt(request.getParameter("id_in"));
			if(recipeModel.DelIngre(id_re, id_in)==1)
			{
				response.sendRedirect("recipe-details.jsp?pos="+pos);
			}
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int pos;
		int id_re,id_in;
		float quantity;
		pos = Integer.parseInt(request.getParameter("pos"));
		if(request.getParameter("function").equals("add"))
		{
			id_re = Integer.parseInt(request.getParameter("id_re"));
			id_in = Integer.parseInt(request.getParameter("ingredient"));
			quantity = Float.parseFloat(request.getParameter("quantity"));
			System.out.println(id_re+","+id_in+","+quantity);
			if(recipeModel.AddIngre(id_re, id_in, quantity)==1)
			{
				response.sendRedirect("recipe-details.jsp?pos="+pos);
			}
		}
		if(request.getParameter("function").equals("edit"))
		{
			id_re = Integer.parseInt(request.getParameter("id_re"));
			id_in = Integer.parseInt(request.getParameter("ingredient"));
			quantity = Float.parseFloat(request.getParameter("quantity"));
			System.out.println(id_re+","+id_in+","+quantity);
			if(recipeModel.EditIngre(id_re, id_in, quantity)==1)
			{
				response.sendRedirect("recipe-details.jsp?pos="+pos);
			}
		}
		
	}

}
