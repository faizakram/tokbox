package com.st.TalkBox;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opentok.OpenTok;
import com.opentok.Role;
import com.opentok.TokenOptions;
import com.opentok.exception.OpenTokException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	 private static final String apiKey = "45973332";//System.getProperty("API_KEY");
	 private static final String apiSecret = "5e55de39e81f53303ce4d38b16b030d438c197cc";//System.getProperty("API_SECRET");
	    
 private static OpenTok opentok;
 private static String sessionId;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		 /*opentok = new OpenTok(Integer.parseInt(apiKey), apiSecret);
	     try {
			sessionId = opentok.createSession().getSessionId();
		} catch (OpenTokException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		/* String token = null;
         try {
             token = opentok.generateToken(sessionId, new TokenOptions.Builder()
                 .role(Role.MODERATOR)
                 .build());
         } catch (OpenTokException e) {
             e.printStackTrace();
         }*/
       /*  System.out.println("apiKey"+ apiKey);
         System.out.println("sessionId"+ sessionId);
         System.out.println("token"+ token);
         model.addAttribute("apiKey", apiKey);
         model.addAttribute("sessionId", sessionId);
         model.addAttribute("token", token);*/
         
		return "home";
	}
	
}
