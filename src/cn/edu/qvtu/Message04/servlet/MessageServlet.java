package cn.edu.qvtu.Message04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.qvtu.Message01.entity.Message;
import cn.edu.qvtu.Message03.service.MessageService;
import cn.edu.qvtu.Message03.service.UserService;

public class MessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		String method = req.getParameter("method");// 前端提交要执行的方法
		if ("add".equals(method)) {
			add(req, resp);
		} else if ("selAll".equals(method)) {
			selMax(req, resp);
		} else if ("selAllmsg".equals(method)) {
			selAllmsg(req, resp);
		} else if ("delete".equals(method)) {
			delete(req, resp);
		}
	}

	protected void selAllmsg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageService service = new MessageService();
		System.out.println(service.selAllmsg().toString());
		response.getWriter().write(service.selAllmsg());
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageService service = new MessageService();
		response.getWriter().write(service.delete());
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageService service = new MessageService();
		Message message = new Message();
		message.setMessage_Title(request.getParameter("message_Title"));
		message.setMessage_Txt(request.getParameter("message_Txt"));
		message.setMessage_Name(request.getParameter("message_Name"));
		String json = service.add(message);
		response.getWriter().write(json);
	}

	protected void selMax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageService service = new MessageService();
		String json = service.selMax();
		System.out.println(json);
		response.getWriter().write(json);
	}

}
