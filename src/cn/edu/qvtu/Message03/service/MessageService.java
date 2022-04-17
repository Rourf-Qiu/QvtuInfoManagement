package cn.edu.qvtu.Message03.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.edu.qvtu.Message00.base.MSGCallback;
import cn.edu.qvtu.Message01.entity.Message;
import cn.edu.qvtu.Message02.dao.MessageDAO;

public class MessageService {
	private MessageDAO dao = new MessageDAO();

	public String add(Message message) throws JsonProcessingException {
		message.setMessage_ID(System.currentTimeMillis());
		int flag = dao.add(message);
		if (flag == -1) {
			return new MSGCallback(false, "添加失败").toJson();
		}
		return new MSGCallback(true, "添加成功").toJson();
	}
	public String delete() throws JsonProcessingException {
		int flag = dao.delete();
		if (flag == -1) {
			return new MSGCallback(false, "添加失败").toJson();
		}
		return new MSGCallback(true, "添加成功").toJson();
	}
	public String selMax() throws JsonProcessingException {
		Message message = dao.selMax();
		if (message == null) {
			return new MSGCallback(false, "查询失败").toJson();
		}
		return new MSGCallback(true, message).toJson();
	}
	
	public String selAllmsg() throws JsonProcessingException {
		List<Message> list = dao.selAllmsg();
		return new MSGCallback(true,"共"+list.size()+"条记录",list).toJson();
	}
}
