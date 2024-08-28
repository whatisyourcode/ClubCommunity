package com.main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
        String view = null;
        AccountService as = new AccountService();

        // URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        

        switch(com) {
        	case "/loginForm":
        		view = "account/loginForm.jsp";
        		break;
        	case "/login":
        		String id = request.getParameter("id");
        		String pw = request.getParameter("pw");
        		int no = as.login(id, pw);
        		if(no!=0) {
        			request.getSession().setAttribute("no", no);
        			response.getWriter().print("<script>alert('로그인 성공!');location.href='main';</script>");        		
        		}else {
        			response.getWriter().print("<script>alert('로그인 실패!');location.href='loginForm';</script>");
//        			view = "redirect:loginForm";
        		}
        		break;
        	case "/logout":
        		request.getSession().setAttribute("no", 0);
        		response.getWriter().print("<script>alert('로그아웃됨.');location.href='main';</script>");
        		break;
        	case "/register":
        		view = "register.jsp";
        		break;
        	case "/registerAction":
        		view = "redirect:main";
        		break;
        	case "/findAccount":
        		view = "findAccount.jsp";
        		break;
        	case "/myPage":
        		view = "account/myPage.jsp";
        		request.setAttribute("dto", as.selectByNo((int)request.getSession().getAttribute("no")));
        		break;
        	case "/update":
        		break;
        	case "/updateAction":
        		view = "redirect:main";
        		break;
        	default:
        		view = "main.jsp";
        		break;
        }
        System.out.println(view);
        if(view.startsWith("redirect:")) {
        	response.sendRedirect(view.substring(9));
        }else {
        	request.getRequestDispatcher(view).forward(request, response);
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
