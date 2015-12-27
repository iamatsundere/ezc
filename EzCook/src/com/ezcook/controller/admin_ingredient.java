package com.ezcook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezcook.bean.ingredientBean;
import com.ezcook.model.ingredientModel;


/**
 * Servlet implementation class detail_intergrill
 */
public class admin_ingredient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_ingredient() {
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

		if(request.getParameter("function").equals("del"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			if(ingredientModel.DelIngredient(id)==1)
			{
				response.sendRedirect("ingredient.jsp");
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

		if(request.getParameter("function").equals("edit"))
		{
			ingredientBean in = new ingredientBean();
			in.setId(Integer.parseInt(request.getParameter("id_in")));
			in.setName(request.getParameter("name_in"));
			in.setPrice(Float.parseFloat(request.getParameter("price_in")));
			in.setUnit(request.getParameter("unit_in"));
			if(ingredientModel.EditIngredient(in)==1)
			{

				response.sendRedirect("ingredient.jsp");

			}
			else
			{
				System.out.println("loi roi");

			}
		}
		if(request.getParameter("function").equals("add"))
		{
			ingredientBean in = new ingredientBean();
			in.setName(request.getParameter("name_in"));
			in.setPrice(Float.parseFloat(request.getParameter("price_in")));
			in.setUnit(request.getParameter("unit_in"));
			if(ingredientModel.InsertIngredient(in)==1)
			{
				response.sendRedirect("ingredient.jsp");
			}

		}

	}

}
