package net.kc.spring.user.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;
import net.kc.spring.user.domain.UserGroupItem;
import net.kc.spring.user.domain.UserValidator;
import net.kc.spring.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "users")
// with @SessionAttributes annotation, "user" is updated by the data from HTTP parameters when controller method with the corresponding model attribute in its signature is invoked.  
@SessionAttributes({ "user" })
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ConversionService conversionService;

	private static final String CREATE_FORM = "users/createUserForm";
	private static final String UPDATE_FORM = "users/updateUserForm";

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// If InitBinder is enabled, JSR 303 Validation will be disabled
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.debug("initBinder");
		// this will apply the validator to all request-handling methods
		binder.setValidator(new UserValidator());
		binder.validate();
	}

	@RequestMapping(value = "createUserForm", method = RequestMethod.GET)
	public String createUserForm(Model model) {
		model.addAttribute(new User());
		return CREATE_FORM;
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user,
			BindingResult bindingResult, Errors errors) {
		if (bindingResult.hasErrors()) {
			for (FieldError fe : bindingResult.getFieldErrors()) {
				logger.info("code: " + fe.getCode() + ", field: " + fe.getField() + ", " + fe.getDefaultMessage());
			}
			return CREATE_FORM;
		}

		if (service.getUser(user.getUsername()) != null) {
			String[] args = new String[] { user.getUsername() };
			errors.rejectValue("number", "user.username.alreadyExsits", args, "username exists!!");
			return CREATE_FORM;
		}

		service.saveUser(user);
		return "redirect:/users/viewUser?id=" + user.getId();
	}

	@RequestMapping(value = "updateUserForm", method = RequestMethod.GET)
	public String updateUserForm(@RequestParam Long id, Model model) {
		User user = service.getUser(id);
		model.addAttribute(user);
		return UPDATE_FORM;
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute User user, BindingResult bindingResult, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) {
			for (FieldError fe : bindingResult.getFieldErrors()) {
				logger.info("code: " + fe.getCode() + ", field: " + fe.getField() + ", " + fe.getDefaultMessage());
			}
			return UPDATE_FORM;
		}

		service.saveUser(user);
		sessionStatus.setComplete();
		return "redirect:/users/viewUser?id=" + user.getId();
	}

	@RequestMapping(value = "viewUser")
	public String viewUser(@RequestParam Long id, Model model) {
		System.out.println("id: " + id);
		model.addAttribute("user", service.getUser(id));
		return "users/viewUser";
	}

	@RequestMapping(value = "listUsers")
	public String getAllUsers(Model model) {
		List<User> userList = service.getAllUsers();
		logger.debug("num user: " + userList.size());
		model.addAttribute("userList", userList);
		return "users/listAllUsers";
	}

	@RequestMapping(value = "createGroupForm", method = RequestMethod.GET)
	public String createGroupForm(Model model) {
		model.addAttribute(new UserGroup());
		return "users/createGroupForm";
	}

	@RequestMapping(value = "createGroup", method = RequestMethod.POST)
	public String createUserGroup(@ModelAttribute UserGroup userGroup) {
		List<User> userList = service.getAllUsers();
		List<UserGroupItem> itemList = new ArrayList<UserGroupItem>(userList.size());
		for (User user : userList) {
			UserGroupItem item = new UserGroupItem();
			item.setUser(user);
			itemList.add(item);
		}
		userGroup.setItemList(itemList);
		service.createUserGroup(userGroup);
		return "redirect:/users/viewGroup?id=" + userGroup.getId();
	}

	@RequestMapping(value = "viewGroup", method = RequestMethod.GET)
	public String viewUserGroup(@RequestParam Long id, Model model) {
		model.addAttribute("group", service.getUserGroup(id));
		return "users/viewGroup";
	}

	@RequestMapping(value = "listGroups", method = RequestMethod.GET)
	public String getAllUserGroups(Model model) {
		List<UserGroup> groupList = service.getAllUserGroups();
		model.addAttribute("groupList", groupList);
		return "users/listAllGroups";
	}
}
