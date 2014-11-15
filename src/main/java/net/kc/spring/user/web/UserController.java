package net.kc.spring.user.web;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	//private static final String VN_REG_OK = "redirect:/users/reg_success";
	//private static final String VN_REG_OK = "users/registrationOk";
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String getRegistrationForm(Model model) {
		model.addAttribute(new User());
		return "users/regForm";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user) {
		service.createUser(user);
		System.out.println("id: " + user.getId() + ", username: " + user.getUsername());
		return "redirect:/users/view?id=" + user.getId();
		//return VN_REG_OK;
	}
	
	@RequestMapping(value="view")
	public String viewUser(@RequestParam Long id, Model model) {
		System.out.println("id: " + id);
		model.addAttribute("user", service.getUser(id));
		return "users/viewUser";
	}
}
