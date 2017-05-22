package Logs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadLogs {
	
	private String ip = "";
	private String dateString = "";
	private String file;
	private String bottomStr = "";
	private String topStr = "";
	private long date;
	
	ReadLogs(String file) {
		this. file = file;
		
	}
	
	void timeLoader() throws IOException, ParseException{
	try {
	BufferedReader dater = new BufferedReader(new InputStreamReader(System.in));
	int s;
	System.out.println("Create data for analize:\n"
			+ "Enter day:");
	s = Integer.parseInt(dater.readLine());
	if (s < 0 | s > 31)
		throw new IOException();
	bottomStr = s + " ";
	System.out.println("Enter month:");
	s = Integer.parseInt(dater.readLine());
	if (s < 0 | s > 12)
		throw new IOException();
	bottomStr += s + " ";
	System.out.println("Enter year:");
	topStr = bottomStr += dater.readLine() + " ";
	System.out.println("Enter time of beginning analize (hours):");
	s = Integer.parseInt(dater.readLine());
	if (s < 0 | s > 23)
		throw new IOException();
	bottomStr += s + ":00:00 MSK";
	System.out.println("Enter time of ending analize (hours):");
	s = Integer.parseInt(dater.readLine());
	if (s < 0 | s > 31)
		throw new IOException();
	topStr += s + ":00:00 MSK";
	logReader();
	}
	catch (IOException e) {
	System.err.println("Wrong numbers of the date or time!");	
	timeLoader();
	}
	catch (NumberFormatException a) {
		System.err.println("Is not integer!");
		timeLoader();
	}
	}
	
	void logReader() throws IOException, ParseException{


		int i, countSpace = 0;
		boolean ipFinish = false;
		String dir = System.getProperty("user.dir");
		System.out.println("user.dir: " + dir);
		FileInputStream reader = new FileInputStream(file);
		try {
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
			if (i == (char) '\n'){
				analizeDate();
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
		catch (ParseException e) {
			System.err.println("Enter date as number of the day, number of the month, number of the year, nubers of hours beginning and ending analizing");
			countSpace = 0;
			ipFinish = false;
			ip = "";
			dateString = "";
			timeLoader();
		}
	}
	
	void analizeDate() throws ParseException, IOException {
		date = (long) Long.parseLong(dateString);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd MM yyyy hh:mm:ss zzz");
		Date parsingBottom = formatDate.parse(bottomStr);
		Date parsingTop = formatDate.parse(topStr);
		if (date > parsingBottom.getTime() & date < parsingTop.getTime()) {
				System.out.println("IP " + ip + " connected at " + new Date((long) date));
		}
	}
}
