package cn.edu.qvtu.Message00.base;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
	    long time = 1624804697451L;
	    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日-hh时mm分ss秒");
	    Date date = new Date(time);
	    System.out.println(time);
	    System.out.println(format.format(date));
	}
}
