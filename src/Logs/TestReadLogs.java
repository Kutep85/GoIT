package Logs;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class TestReadLogs {


	@Test
	public void testAnalizeLog() {
		ReadLogs readLog = new ReadLogs("sessions_log.txt");
		readLog.logReader();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd MM yyyy HH:mm:ss zzz");
		Date parsingBottom = formatDate.parse("19 05 2017 15:00:00 MSK");
		Date parsingTop = formatDate.parse("19 05 2017 21:00:00 MSK");
		String actualResult = readLog.analizeDate(parsingBottom.getTime(), parsingTop.getTime());
		String expectedResult = "IP 123.45.67.106 connected at Fri May 19 15:59:46 MSK 2017\n" + 
				"IP 123.45.67.107 connected at Fri May 19 16:59:52 MSK 2017\n" + 
				"IP 123.45.67.108 connected at Fri May 19 17:59:59 MSK 2017\n" + 
				"IP 123.45.67.109 connected at Fri May 19 19:00:06 MSK 2017\n" + 
				"IP 123.45.67.110 connected at Fri May 19 20:00:12 MSK 2017\n"
		Assert.assertEquals(expectedResult, actualResult);
	}

}
