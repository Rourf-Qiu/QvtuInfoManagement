package cn.edu.qvtu.Message04.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JScrollBar;

import cn.edu.qvtu.Message00.base.MSGCallback;
import cn.edu.qvtu.Message00.base.NumberTool;
import cn.edu.qvtu.Message01.entity.User;
import cn.edu.qvtu.Message03.service.UserService;
import netscape.javascript.JSObject;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端提交过来的数据
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");// 前端提交要执行的方法
		if ("login".equals(method)) {
			login(request, response);
		} else if ("logout".equals(method)) {
			logout(request, response);
		} else if ("add".equals(method)) {
			add(request, response);
		} else if ("selAll".equals(method)) {
			selAll(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("resetPSW".equals(method)) {
			resetPSW(request, response);
		} else if ("delete2".equals(method)) {
			delete2(request, response);
		} else if ("selUserName".equals(method)) {
			selUserName(request, response);
		} else if ("selUserInfo".equals(method)) {
			selUserInfo(request, response);
		} else if ("login2".equals(method)) {
			login2(request, response);
		}
	}

	protected void selUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 响应json值给浏览器
		String json;
		if (user == null) {
			MSGCallback msg = new MSGCallback(false, "未登录", user);
			json = msg.toJson();
		} else {
			MSGCallback msg = new MSGCallback(true, user.getUserName(), user);
			json = msg.toJson();
		}

		response.getWriter().write(json);
	}

	protected void resetPSW(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// userPSW : userPSW,
		// newPSW1 : newPSW1,
		// newPSW2 : newPSW2
		String userPSW = request.getParameter("oldPSW");
		String newPSW1 = request.getParameter("newPSW1");
		String newPSW2 = request.getParameter("newPSW2");
		System.out.println(userPSW + " " + newPSW1);
		UserService service = new UserService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 响应json值给浏览器
		String json = service.resetPSW(newPSW1, newPSW2, userPSW, user);
		response.getWriter().write(json);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		System.out.println(userID);
		UserService service = new UserService();
		String json = service.delete(userID);
		response.getWriter().write(json);
	}

	protected void delete2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] userIdArr = request.getParameterValues("userID[]");
		System.out.println(userIdArr);
		for (String userId : userIdArr) {
			UserService service = new UserService();
			String json = service.delete(userId);
			response.getWriter().write(json);
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setsetUserID(request.getParameter("userID"));
		user.setUserClass(request.getParameter("userClass"));
		user.setUserIdentity(request.getParameter("userIdentity"));
		user.setUserType(request.getParameter("userType"));
		user.setUserName(request.getParameter("userName"));
		user.setUserSex(request.getParameter("userSex"));
		UserService service = new UserService();
		String json = service.update(user);
		request.getSession().invalidate();// 注销--经过这个动作后，session已经被释放，说明当前请求没有session
		request.getSession().setAttribute("user", user);
		System.out.println(json);
		response.getWriter().write(json);
	}

	protected void selAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserService();
		String json = service.selAll();
		System.out.println(json);
		response.getWriter().write(json);
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		User user = new User();
		user.setsetUserID(request.getParameter("userID"));
		user.setUserName(request.getParameter("userName"));
		user.setUserSex(request.getParameter("userSex"));
		user.setUserClass(request.getParameter("userClass"));
		user.setUserIdentity(request.getParameter("userIdentity"));
		user.setUserType(request.getParameter("userType"));
		String json = service.add(user);
		response.getWriter().write(json);
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		MSGCallback msg = new MSGCallback(true, null);
		response.getWriter().write(msg.toJson());
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setsetUserID(request.getParameter("userID"));
		user.setUserPSW(request.getParameter("userPSW"));
		System.out.println(user.getUserID() + " " + user.getUserPSW());
		UserService service = new UserService();
		MSGCallback msg = service.login(user);
		System.out.println(msg.toJson());
		// HttpSession
		// session=request.getSession();//获取session对象，如果session已经存在，则直接返回，如果session不存在，则创建并返回
		request.getSession().invalidate();// 注销--经过这个动作后，session已经被释放，说明当前请求没有session
		request.getSession().setAttribute("user", msg.getObj());
		response.getWriter().write(msg.toJson());
	}

	protected void login2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setsetUserID(request.getParameter("userID"));
		user.setUserPSW(request.getParameter("userPSW"));
		System.out.println(user.getUserID() + " " + user.getUserPSW());
		UserService service = new UserService();
		MSGCallback msg = service.login2(user);
		System.out.println(msg.toJson());
		// HttpSession
		// session=request.getSession();//获取session对象，如果session已经存在，则直接返回，如果session不存在，则创建并返回
		request.getSession().invalidate();// 注销--经过这个动作后，session已经被释放，说明当前请求没有session
		request.getSession().setAttribute("user", msg.getObj());
		response.getWriter().write(msg.toJson());
	}

	protected void selUserName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 响应json值给浏览器
		String json;
		if (user == null) {
			MSGCallback msg = new MSGCallback(false, "未登录");
			json = msg.toJson();
		} else {
			MSGCallback msg = new MSGCallback(true, user.getUserName());
			json = msg.toJson();
		}

		response.getWriter().write(json);
	}
	
	protected void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
