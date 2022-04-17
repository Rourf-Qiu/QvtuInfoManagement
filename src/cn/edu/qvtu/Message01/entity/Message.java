package cn.edu.qvtu.Message01.entity;

public class Message {
	private long message_ID;
	private String message_Title;
	private String message_Txt;
	private String message_Name;
	private String beizhu;
	public long getMessage_ID() {
		return message_ID;
	}

	public void setMessage_ID(long message_ID) {
		this.message_ID = message_ID;
	}

	public String getMessage_Title() {
		return message_Title;
	}

	public void setMessage_Title(String message_Title) {
		this.message_Title = message_Title;
	}

	public String getMessage_Txt() {
		return message_Txt;
	}

	public void setMessage_Txt(String message_Txt) {
		this.message_Txt = message_Txt;
	}

	public String getMessage_Name() {
		return message_Name;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public void setMessage_Name(String message_Name) {
		this.message_Name = message_Name;
	}

}
