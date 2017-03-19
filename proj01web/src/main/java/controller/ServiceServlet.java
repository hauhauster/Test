package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service_model.ServiceDAOsvc;
import service_model.ServiceVO;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/Controller")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServiceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String action = request.getParameter("action");

		if ("get_one_for_display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("erroMsgs", errorMsgs);
			try {
				String str = request.getParameter("servno");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入服務代號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("test.jsp");
					failureView.forward(request, response);
					return;
				}
				Integer servnoint = null;
				try {
					servnoint = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("服務代號格式不正確");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("test.jsp");
					failureView.forward(request, response);
					return;
				}
				ServiceDAOsvc svc = new ServiceDAOsvc();
				ServiceVO svcVO = svc.getOne(str);
				if (svcVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("test.jsp");
					failureView.forward(request, response);
					return;
				}
				request.setAttribute("svcVO", svcVO);
				String url = "ListOneSVC.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);
				successView.forward(request, response);
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = request.getRequestDispatcher("test.jsp");
				failureView.forward(request, response);
			}
		}
		
	}

}
