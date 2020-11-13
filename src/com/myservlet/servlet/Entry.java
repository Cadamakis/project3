package com.myservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myservlet.product.Productc;

@WebServlet("/Entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Entry(){super();}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");	//show this response if jsp fail
		PrintWriter out = response.getWriter();	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		String check = insertProd(request, emf);//send the request params to get inserted
		
		try{
			checkifexists(request, response, check);//check if the barcode already exists
		} catch (SQLException ex) {
			out.println("problemmm..."+ex);
		}

		try{
			printBase(request, response, out, emf);
		} catch (SQLException ex) {
			out.println("problemmm..."+ex);
		}
	}


	public String insertProd(HttpServletRequest request, EntityManagerFactory emf) {
		//get the input parameters
		String c1 = request.getParameter("name");
		Long c2 = Long.parseLong(request.getParameter("barcode"));
		String c3 = request.getParameter("color");
		String c4 = request.getParameter("description");
		//create an entity manager
		EntityManager em = emf.createEntityManager();
		Productc prod = new Productc();
		//set the productc variables with PERSISTENCE
		prod.setName(c1);
		prod.setBarcode(c2);
		prod.setColor(c3);
		prod.setDescription(c4);
		//make a transaction
		EntityTransaction tx = null;
		String k = null;

		try{
			tx = em.getTransaction();
			tx.begin();						//begin transaction
			em.persist(prod);				//persist transaction
			em.getTransaction().commit();	//commit the transaction
			k = "1";
			return "1";						//return a non null value in order to check if exists
		}
		catch(Exception ex){
			em.getTransaction().commit();
			return null;					//return null if the key exists
		}
		finally{
			em.close(); 					//close the entity manager beacause we dont need it anymory
			return k;
		}
	}
	


	public void checkifexists(HttpServletRequest request, HttpServletResponse response, String check)
			throws SQLException, IOException, ServletException {
        if(check == null){//send an error because primary key already exists in table
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
    	}
	}

	private void printBase(HttpServletRequest request, HttpServletResponse response,PrintWriter out, EntityManagerFactory emf)
			throws SQLException, IOException, ServletException {

		EntityManager em1 = emf.createEntityManager();//create entity manager
		Query query = em1.createNativeQuery("select * from product",Productc.class);//request from mysql server the products table
	
		@SuppressWarnings("unchecked")//in order not get warning
		List<Productc> prods = query.getResultList();//get the list of objects and type cast to Productc

		request.setAttribute("prods", prods);//put in the request the list
		RequestDispatcher dispatcher = request.getRequestDispatcher("printProducts.jsp");
		dispatcher.forward(request, response);//call the printProducts.jsp view page
	}

}






