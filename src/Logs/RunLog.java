package Logs;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunLog {
	public static void main (String[] args) throws IOException, ParseException {
		ReadLogs readLog = new ReadLogs("sessions_log.txt");
		readLog.logReader();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd MM yyyy HH:mm:ss zzz");
		Date parsingBottom = formatDate.parse("19 05 2017 15:00:00 MSK");
		Date parsingTop = formatDate.parse("19 05 2017 21:00:00 MSK");
		
		System.out.println(readLog.analizeDate(parsingBottom.getTime(), parsingTop.getTime()));
		}
	}	
