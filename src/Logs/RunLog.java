package Logs;

import java.io.IOException;
import java.text.ParseException;

public class RunLog {
	public static void main (String[] args) throws IOException, ParseException {
		ReadLogs readLog = new ReadLogs("sessions_log.txt");
		readLog.timeLoader();
		}
	}	
