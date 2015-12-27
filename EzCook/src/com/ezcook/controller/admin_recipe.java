package com.ezcook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezcook.bean.categoryBean;
import com.ezcook.bean.ingredientBean;
import com.ezcook.bean.recipeBean;
import com.ezcook.model.ingredientModel;
import com.ezcook.model.recipeModel;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class admin_recipe
 */
public class admin_recipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_recipe() {
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

			if(recipeModel.DelRecipe(id)==1)
			{
				response.sendRedirect("recipe.jsp");
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

		
		if(request.getParameter("function").equals("add"))
		{
			String filePath="";
			recipeBean in = new recipeBean();
			in.setId(Integer.parseInt(request.getParameter("id_re")));
			in.setName(request.getParameter("nameRe"));
			in.setMade_in(request.getParameter("made_in"));
			in.setProcessing(request.getParameter("processing"));
			in.setIdCat(Integer.parseInt(request.getParameter("id_cat")));
			in.setImage(uploadFile.upload(request, response));

			if(recipeModel.InsertRecipe(in)==1)
			{
				response.sendRedirect("recipe.jsp");
			}

		}
		if(request.getParameter("function").equals("edit"))
		{
			recipeBean in = new recipeBean();
			in.setId(Integer.parseInt(request.getParameter("id_re")));
			in.setName(request.getParameter("nameRe"));
			in.setMade_in(request.getParameter("made_in"));
			in.setProcessing(request.getParameter("processing"));
			in.setIdCat(Integer.parseInt(request.getParameter("id_cat")));
			if(recipeModel.EditRecipe(in)==1)
			{

				response.sendRedirect("recipe.jsp");

			}
			else
			{
				System.out.println("loi roi");

			}
		}



	}

}
