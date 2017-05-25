package Logs;

public class LogCard {
	
	private String ip;
	private long date;
	
	LogCard(String i, long d) {
		ip = i;
		date = d;
	}
	
	String getIp() {
		return ip;
	}
	
	long getDate() {
		return date;
	}
}
