package com.main.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import service.FoodService;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String view = null; // 포워딩할 주소
		AccountService as = new AccountService();

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {
		case "/loginForm": // 로그인 페이지
			view = "account/loginForm.jsp";
			break;
		case "/login": // 로그인
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			int no = as.login(id, pw);
			if (no != 0) {
				request.getSession().setAttribute("no", no);
				response.getWriter().print("<script>alert('로그인 성공!');location.href='main';</script>"); // 얼럿창 띄운 후
																										// main으로 이동
			} else {
				response.getWriter().print("<script>alert('로그인 실패!');location.href='loginForm';</script>");
			}
			break;
		case "/logout": // 로그아웃
			request.getSession().setAttribute("no", 0); // 세션에 저장된 유저 번호를 지움
			response.getWriter().print("<script>alert('로그아웃됨.');location.href='main';</script>");
			break;
		case "/registerForm": // 회원가입 페이지
			view = "registerForm.jsp";
			break;
		case "/register": // 회원가입
			view = "redirect:main";
			break;
		case "/findAccount": // 계정찾기
			view = "findAccount.jsp";
			break;
		case "/myPage": // 마이페이지
			view = "account/myPage.jsp";
			request.setAttribute("dto", as.selectByNo((int) request.getSession().getAttribute("no")));
			// 세션에 저장된 유저 번호를 이용해 정보를 가져옴
			break;
		case "/updateForm": // 계정 업데이트 페이지
			break;
		case "/update": // 계정 업데이트
			view = "redirect:main";
			break;
		default:
			view = "main.jsp"; // 메인페이지
			FoodService fs = new FoodService();
			List<List<String>> week = fs.getFoodList(); // 식단표를 받아옴
			for (int w = 0; w > week.size(); w++) {
				int day = LocalDate.now().getDayOfWeek().getValue() - 1;	// 현재 날짜를 기준으로 요일의 번호를 가져옴( 0 = 월요일)
				day = day > 4 ? 0 : day;	// 현재 요일이 토요일 일요일인 경우 월요일의 식단표를 보여주기 위해 번호를 0으로 바꿈
				request.setAttribute("day", week.get(day));	// 요일에 맞는 식단표를 올림
				request.setAttribute("dayIndex", day);
			}
			break;
		}
		System.out.println(view);
		if (view.startsWith("redirect:")) { // view가 redirect로 시작하면
			response.sendRedirect(view.substring(9)); // redirect: 뒤의 주소로 리다이렉트를 보냄
		} else {
			request.getRequestDispatcher(view).forward(request, response); // 아니면 포워딩
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
