/*
 * 	Created Date: 2020-09-19
 * 	Author: Dodo (rabbit.white at daum dot net)
 * 	Subject: MyBatis - CRUD 실험(삽입)
 * 	Filename: BoardInsertServlet.java
 *  	Description: 
 *  	1. 2020-09-21 / Dodo / Bug 수정 (Timestamp->Date로 SQL 업데이트 변경)
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
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
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
		AddressDto dbNode = new AddressDto(); 
		dbNode.setName("도도" + serialVersionUID);
		dbNode.setAddress("행복시 행복동");
		
		// 버그1: new Date() 사용안됨. (2020을 3920으로 인식함.) 
		// 버그2: new Timestamp() 사용안됨. (2020을 3920으로 인식함.)
		String userDate = "2020-02-01";
		java.sql.Date sqlDate = java.sql.Date.valueOf(userDate);
		dbNode.setBirthdate(sqlDate);
		
		int result = address.insertAddress(dbNode);
		AddressDto addressDto = address.getAddress(1);
		
		out.println("<html><head><title>CRUD - Insert</title></head>");
		out.println("<body><h2>MyBatis - Insert</h2>");
		
		out.print("<br/>");
		out.print("등록여부:" + result + "</br>");
		out.print("<br/>");
		out.print(addressDto.getNum() + "/" + addressDto.getName() + "/");
		out.print(addressDto.getAddress() + "/" + addressDto.getBirthdate());
		
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
