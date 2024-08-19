package com.main.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = null;

        // URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        

        switch(com) {
        	case "/login":
        		view = "login.jsp";
        		break;
        	case "/loginAction":
        		view = "redirect:main";
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
        		view = "myPage.jsp";
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
