package Logs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadLogs {
	
	private String file;
	private List<LogCard> data;
	
	ReadLogs(String file) {
		this. file = file;
		
	}
	
	void logReader() throws IOException {
		data = new ArrayList<>();
		int i, countSpace = 0;
		boolean ipFinish = false;
		String ip = "", dateString = "";
		String dir = System.getProperty("user.dir");
		System.out.println("user.dir: " + dir);
		FileInputStream reader = new FileInputStream(file);
		do {
			i = reader.read();
			if (i != -1){
			if (i == ' ')
				countSpace++;
			if (i == (char) ':')
				ipFinish = true;
			if (countSpace == 0 & ipFinish == false)
				ip += (char)i;
			if (countSpace == 2 & i != (char) ' ')
				dateString += (char) i;
			if (countSpace == 3 & i == (char) ' ')
				data.add(new LogCard(ip, Long.parseLong(dateString)));
			if (i == (char) '\n'){
				countSpace = 0;
				ip = "";
				dateString = "";
				ipFinish = false;
				}
			}
		}
		while (i != -1);
		reader.close();
	}
	
	String analizeDate(long Bottom, long Top) {
		String s = "";
		for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getDate() > Bottom & data.get(i).getDate() < Top) {
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("IP ");
					stringBuilder.append(data.get(i).getIp());
					stringBuilder.append(" connected at ");
					stringBuilder.append(new Date(data.get(i).getDate()));
					stringBuilder.append("\n");
					s += stringBuilder.toString();
				}
		}
		return s;
	}
}
