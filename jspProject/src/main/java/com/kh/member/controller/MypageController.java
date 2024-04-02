package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/myPage.me")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 전에 url쳐서 직접요청도 가능하기 때문에 이것을 방지하기 위해
		//로그인 후에만 요청하도록 세팅
		
		//세션값내부에 loginUser가 있는지 확인
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null){ //로그인이 안되있는 상태
			session.setAttribute("alertMsg", "로그인 후 이용하가능한 서비스입니다.");
			//위에 url이 다르기 때문에 메인페이지로 다시 보내기 위해 리다이렉트가 맞다
			response.sendRedirect(request.getContextPath());
			
		} else { //로그인이 되어있는 상태
			//여기는 포워드해주기
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
