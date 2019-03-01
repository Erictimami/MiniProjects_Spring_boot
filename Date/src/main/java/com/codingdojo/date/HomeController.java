package com.codingdojo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		String pattern = "EEEE";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dayName = simpleDateFormat.format(new Date());
		pattern = "dd";
		simpleDateFormat = new SimpleDateFormat(pattern);
		String dayOfMonth = simpleDateFormat.format(new Date());
		pattern = "MMMM";
		simpleDateFormat = new SimpleDateFormat(pattern);
		String month = simpleDateFormat.format(new Date());
		pattern ="yyyy";
		simpleDateFormat = new SimpleDateFormat(pattern);
		String year = simpleDateFormat.format(new Date());
		String actualDate = dayName+", the "+dayOfMonth+" of "+month+", "+year;

		model.addAttribute("actualDate", actualDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		String pattern = "HH:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String actualTime = simpleDateFormat.format(new Date());
		
		model.addAttribute("actualTime", actualTime);
		return "time.jsp";
	}
}
