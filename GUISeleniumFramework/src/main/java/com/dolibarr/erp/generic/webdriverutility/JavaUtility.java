package com.dolibarr.erp.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Deepak
 *
 */
public class JavaUtility {
	/**
	 * get the random number , in the range of 0-5000
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ranDom = new Random();
		int ranDomNumber = ranDom.nextInt(5000);
		return ranDomNumber;
	}

	/**
	 * get the system date based on YYYY-DD-MM format
	 * 
	 * @return
	 */
<<<<<<< HEAD
	public String getSystemDateYYYYDDMM() {

=======
	public String getSystemDateMMDDYYYY() {
		
>>>>>>> branch 'Testing' of https://github.com/beatsane/Dolibarr_GUIFramework.git
		Date dateObj = new Date();
<<<<<<< HEAD

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
=======
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
>>>>>>> branch 'Testing' of https://github.com/beatsane/Dolibarr_GUIFramework.git
		String date = sdf.format(dateObj);
		return date.replace('-','/');
	}

	/**
	 * get the TAT date based on YYYY-DD-MM format
	 * 
	 * @return
	 */
	public String getRequriedDateYYYYDDMM(int days) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
