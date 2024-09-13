package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.servlets.config.Config;
import com.servlets.dao.FeedbackDao;
import com.servlets.dto.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		try {

			String email = request.getParameter("email");
			long phoneNo = Long.parseLong(request.getParameter("phoneNumber"));
			String feedback = request.getParameter("feedback");
			Feedback feedbackObj = new Feedback(email, phoneNo, feedback);
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
			FeedbackDao bean = applicationContext.getBean(FeedbackDao.class);
			bean.save(feedbackObj);
			response.sendRedirect(request.getContextPath() + "/componants/welcome.jsp");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/componants/error.jsp");
			 
		}
	}

}
