package cn.edu.qvtu.Message00.base;

public class NumberTool {
	// 字符串转byte
	public static final byte toByte(String str) {
		try {
			return Byte.parseByte(str);
		} catch (NumberFormatException e) {
		}
		return 0;
	}

	// 字符串转long
	public static final long toLong(String str) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
