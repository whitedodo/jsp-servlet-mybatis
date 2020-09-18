/*
 * 	Created Date: 2020-09-19
 * 	Author: Dodo (rabbit.white at daum dot net)
 * 	Subject: MyBatis - CRUD 실험(목록)
 * 	Filename: BoardListServlet.java
 *  	Description: 
 *  	1. 
 *  
 */

package com.edu.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.db.Address;
import com.edu.db.AddressDto;
import com.edu.db.AddressImpl;

/**
 * Servlet implementation class boardListServlet
 */
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
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
		AddressDto addressDto = address.getAddress(1);
		
		out.println("<html><head><title>CRUD - List2</title></head>");
		out.println("<body><h2>MyBatis - List</h2>");
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd" );
		String birthdate = format1.format(addressDto.getBirthdate());
		
		out.print(addressDto.getNum() + "/" + addressDto.getName() + "/");
		out.print(addressDto.getAddress() + "/" + birthdate);
		out.print("<br/>");
		
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
