package cn.edu.qvtu.Message00.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MSGCallback {
	private boolean flag;
	private String msg;
	private Object obj;
	private Object data;
	private String code;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public MSGCallback(boolean flag, String msg) {
		this.flag = flag;
		this.msg = msg;
	}

	public MSGCallback(boolean flag, Object obj) {
		this.flag = flag;
		this.obj = obj;
	}

	public MSGCallback(boolean flag, String msg, Object obj) {
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MSGCallback(boolean flag, String msg, Object data,Object obj,String code) {
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
		this.data = data;
		this.code = code;
	}

	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
}
