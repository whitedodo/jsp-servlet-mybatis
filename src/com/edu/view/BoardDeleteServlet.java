/*
 * 	Created Date: 2020-09-19
 * 	Author: Dodo (rabbit.white at daum dot net)
 * 	Subject: MyBatis - CRUD 실험(삭제)
 * 	Filename: BoardDeleteServlet.java
 *  	Description: 
 *  	1. 
 *  
 */

package com.edu.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.db.Address;
import com.edu.db.AddressDto;
import com.edu.db.AddressImpl;

/**
 * Servlet implementation class boardInsertServlet
 */
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.print("<br/>");
		
		AddressImpl address = new AddressImpl();
		
		int result = address.deleteAddress(5);
		AddressDto addressDto = address.getAddress(5);
		
		out.println("<html><head><title>CRUD - Delete</title></head>");
		out.println("<body><h2>MyBatis - Delete</h2>");
		
		out.print("<br/>");
		out.print("삭제여부:" + result + "</br>");
		out.print("<br/>");
		
		if ( addressDto != null ) {
			out.print(addressDto.getNum() + "/" + addressDto.getName() + "/");
			out.print(addressDto.getAddress() + "/" + addressDto.getBirthdate());
		}
		
		out.println("</body></html>");
		
		out.close();
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
