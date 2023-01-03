package main.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Helper {
	public static String[] _serviceIds = new String[] {};
	
	public static Date convertStringToDate(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
		    Date dateParse = dateFormat.parse(date);
		    return dateParse;
		} catch (ParseException e) {
		    System.out.println("Exception while parsing date: " + e);
		    return null;
		}
	}
	
	public static String getDayOfWeek(String date) {
		Calendar calendar = Calendar.getInstance();
		Date dateParse = convertStringToDate(date, Constants.FORMAT_DATE);
		calendar.setTime(dateParse);
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("vi", "VN"));
		return dayOfWeek;
	}
	
	public static String getMonthOfYear(String date) {
		Calendar calendar = Calendar.getInstance();
		Date dateParse = convertStringToDate(date, Constants.FORMAT_DATE);
		calendar.setTime(dateParse);
		int month = calendar.get(Calendar.MONTH);
		String monthString = String.format("%02d", month + 1);
		return monthString;
	}
	
	public static String getDayOfMonth(String date) {
		Calendar calendar = Calendar.getInstance();
		Date dateParse = convertStringToDate(date, Constants.FORMAT_DATE);
		calendar.setTime(dateParse);
		int day = calendar.get(Calendar.DATE);
		return String.valueOf(day);
	}
	
	public static String generateRandomSixNumber() {
        String alphabet = "0123456789";
        alphabet = alphabet.toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 6;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
	
	public static void sendMail(JavaMailSender mailer, String emailTo, String subject, String body) {
		MimeMessage mail = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		try {
			helper.setFrom(Constants.EMIAL_FROM);
			helper.setTo(emailTo);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			mailer.send(mail);
			
		} catch (Exception e) {
			System.out.println("Error while sending email...");
		}
	}
}
