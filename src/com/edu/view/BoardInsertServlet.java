/*
 * 	Created Date: 2020-09-19
 * 	Author: Dodo (rabbit.white at daum dot net)
 * 	Subject: 게시판 수정기능 (업데이트 원리)
 * 	Filename: BoardUpdate.java
 *  	Description: 
 *  	1. MyBatis 적용함.
 *      2. 2020-09-21 / Dodo / SQL형식 수정 Timestamp->Date로 변경
 *  
 */

package com.edu.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.db.AddressDto;
import com.edu.db.AddressImpl;

@WebServlet("/board/update.do")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.print("<br/>");
		
		AddressImpl address = new AddressImpl();
		AddressDto dbNode = new AddressDto();
		dbNode.setNum(3);
		dbNode.setName("도도수정" + serialVersionUID);
		dbNode.setAddress("행복시 행복동");

		// 버그1: new Date() 사용안됨. (2020을 3920으로 인식함.) 
		// 버그2: new Timestamp() 사용안됨. (2020을 3920으로 인식함.)
		String userDate = "2020-07-01";
		java.sql.Date sqlDate = java.sql.Date.valueOf(userDate);
		dbNode.setBirthdate(sqlDate);
		
		int result = address.updateAddress(dbNode);
		AddressDto addressDto = address.getAddress(3);
		
		out.println("<html><head><title>CRUD - Update</title></head>");
		out.println("<body><h2>MyBatis - Update</h2>");
		
		out.print("<br/>");
		out.print("수정여부:" + result + "</br>");
		out.print("<br/>");
		out.print(addressDto.getNum() + "/" + addressDto.getName() + "/");
		out.print(addressDto.getAddress() + "/" + addressDto.getBirthdate());
		
		out.println("</body></html>");
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
