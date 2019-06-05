package com.dreamguard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * json
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/other1")
public class Test7Controller {
	
	/**
	 * cookie requestheader
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/test1.action")
	public String test1(@CookieValue String JSESSIONID,@RequestHeader("User-Agent") String UserAgent) throws IOException{
		System.out.println("JSESSIONID" + JSESSIONID);
		System.out.println(UserAgent);
		return "first";
	}

}
