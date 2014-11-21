package net.kc.spring.user.web;

import java.util.ArrayList;
import java.util.List;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;
import net.kc.spring.user.domain.UserGroupItem;
import net.kc.spring.user.service.UserService;

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

	// private static final String VN_REG_OK = "redirect:/users/reg_success";
	// private static final String VN_REG_OK = "users/registrationOk";

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "createUserForm", method = RequestMethod.GET)
	public String createUserForm(Model model) {
		model.addAttribute(new User());
		return "users/createUserForm";
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user) {
		service.createUser(user);
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
