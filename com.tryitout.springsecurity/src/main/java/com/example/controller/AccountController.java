package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.security.IChangePassword;

@Controller
public class AccountController extends BaseController{

	@Autowired
	IChangePassword changePasswordDao;
	
	@Autowired
	SessionRegistry sessionRegistry;

	@RequestMapping(value = "/account/home.htm")
	public void home() {
	}

	@RequestMapping(value = "/account/changePassword.htm", method = RequestMethod.POST)
	public String changePassword(@RequestParam("newPassword") String password) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		changePasswordDao.changePassword(username, password);
		SecurityContextHolder.clearContext();
		return "redirect:home.htm";
	}

	@RequestMapping(value = "/account/changePassword.htm", method = RequestMethod.GET)
	public void showPassword() {

	}
	
	@RequestMapping(value = "/account/listActiveUsers.htm", method = RequestMethod.GET)
	public void listActiveUsers(Model model){
		Map<Object,Date> lastActivityDates = new HashMap<Object, Date>();
		
		for (Object user : sessionRegistry.getAllPrincipals()) {
			// a principal can have multiple active sessions
			for (SessionInformation sessionInfo : sessionRegistry.getAllSessions(user, false)) {
				Date lastRequest = sessionInfo.getLastRequest();
				Date recordedRequestDate = lastActivityDates.get(user);
				if(recordedRequestDate == null){
					// this user has not yet logged in
					lastActivityDates.put(user, lastRequest);
				}else{
					if(lastRequest.after(recordedRequestDate)){
						// update information with last request date
						lastActivityDates.put(user, lastRequest);
					}
				}
			} 
		}
		model.addAttribute("activeUsers",lastActivityDates);
	}
}
