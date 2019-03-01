package com.codingdojo.goldgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class HomeController {
	public static String result="";
	public static int count=0;
	Random rand = new Random();
	
	@RequestMapping("/gold")
	public String home(Model model) {
		model.addAttribute("activities", result);
		model.addAttribute("count", count);
		return "index.jsp";
	}
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm() {
		int n = rand.nextInt(10)+10;
		count += n;
		String pattern = "MMMM d yyyy hh:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		result+="<p class='win'>You entered a farm and earned "+ n +" golds. ("+date+")</p><br>";
		return "redirect:/gold";
	}
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave() {
		int n = rand.nextInt(5)+5;
		count += n;
		String pattern = "MMMM d yyyy hh:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		result+="<p class='win'>You entered a cave and earned "+ n +" golds. ("+date+")</p><br>";
		return "redirect:/gold";
	}
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house() {
		int n = rand.nextInt(3)+2;
		count += n;
		String pattern = "MMMM d yyyy hh:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		result+="<p class='win'>You entered a house and earned "+ n +" golds. ("+date+")</p><br>";
		return "redirect:/gold";
	}
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino() {
		int n = rand.nextInt(100)-50;
		count += n;
		String pattern = "MMMM d yyyy hh:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		if(n<0) {
			result+="<p class='loss'>You entered a casino and lost "+ n +" golds. Ouch.. ("+date+")</p><br>";
		}else {
			result+="<p class='win'>You entered a casino and earned "+ n +" golds. ("+date+")</p><br>";
		}
		return "redirect:/gold";
	}
}
