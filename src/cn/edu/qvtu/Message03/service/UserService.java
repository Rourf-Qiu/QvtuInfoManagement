package cn.edu.qvtu.Message03.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.edu.qvtu.Message00.base.MSGCallback;
import cn.edu.qvtu.Message00.base.NumberTool;
import cn.edu.qvtu.Message01.entity.User;
import cn.edu.qvtu.Message02.dao.UserDAO;

public class UserService {
	private UserDAO dao = new UserDAO();

	public MSGCallback login(User user) {
		user = dao.login(user);
		if (user == null) {
			System.out.println("flase");
			return new MSGCallback(false, "账号或密码错误");
		}
		System.out.println("true");
		return new MSGCallback(true, user);
	}
	public MSGCallback login2(User user) {
		user = dao.login(user);
		if (user == null) {
			System.out.println("flase");
			return new MSGCallback(false, "账号或密码错误");
		}else if(!user.getUserType().equals("管理员")) {
			return new MSGCallback(false, "权限不够");
		}
		System.out.println("true");
		return new MSGCallback(true, user);
	}
	public String add(User user) throws JsonProcessingException {
		user.setID(System.currentTimeMillis());
		user.setUserPSW("123456");
		int flag = dao.add(user);
		if (flag == 1) {
			return new MSGCallback(true, "添加成功").toJson();
		}
		return new MSGCallback(false, "添加失败").toJson();
	}

	public String selAll() throws JsonProcessingException {
		List<User> list = dao.selAll();
		MSGCallback msg = new MSGCallback(true, "共找到" + list.size() + "条记录", list, null, "0");
		return msg.toJson();
	}

	public String update(User user) throws JsonProcessingException {
		int flag = dao.update(user);
		if (flag == -1) {
			return new MSGCallback(false, "重置失败").toJson();
		}
		return new MSGCallback(true, "重置成功").toJson();
	}

	public String delete(String userID) throws JsonProcessingException {
		int flag = dao.delete(NumberTool.toLong(userID));
		if (flag == -1) {
			return new MSGCallback(false, "删除失败").toJson();
		}
		return new MSGCallback(true, "删除成功").toJson();
	}

	public String resetPSW(String newPSW1, String newPSW2, String userPSW, User user) throws JsonProcessingException {
		if (user == null || user.getUserID() == 0) {
			System.out.println("请先登录");
			return new MSGCallback(false, "请先登录").toJson();
		}
		if (!(userPSW != null && userPSW.length() >= 3)) {
			// 不 符合条件
			System.out.println("请输入密码");
			return new MSGCallback(false, "请输入密码").toJson();
		}
		if (!(newPSW1 != null && newPSW1.length() >= 3 && newPSW1.equals(newPSW2))) {
			return new MSGCallback(false, "请输入新密码").toJson();
		}
		int flag = dao.resetPSW(newPSW1, userPSW, user.getUserID());
		if (flag == 1) {
			return new MSGCallback(true, "密码修改成功").toJson();
		}
		System.out.println("密码修改失败");
		return new MSGCallback(false, "密码修改失败").toJson();

	}

	public String selUserName(User user) throws JsonProcessingException {
		user = dao.selUserName(user);
		if(user == null) {
			return new MSGCallback(true, "未登录").toJson();
		}
		return new MSGCallback(true, user.getUserName()).toJson();
	}
	/***
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
