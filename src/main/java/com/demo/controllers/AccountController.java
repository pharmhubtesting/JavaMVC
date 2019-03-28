package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.entities.Account;
import com.demo.entities.Language;
import com.demo.entities.Role;

@Controller
@RequestMapping(value = "account")
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {

		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language("lang1", "Language 1"));
		languages.add(new Language("lang2", "Language 2"));
		languages.add(new Language("lang3", "Language 3"));
		languages.add(new Language("lang4", "Language 4"));
		modelMap.put("languages", languages);

		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("r1", "Role 1"));
		roles.add(new Role("r2", "Role 2"));
		roles.add(new Role("r3", "Role 3"));
		roles.add(new Role("r4", "Role 4"));
		modelMap.put("roles", roles);

		Account account = new Account();
		account.setId("acc1");
		account.setGender("male");
		account.setStatus(true);
		account.setLanguages(new String[] { "lang2", "lang4" });
		modelMap.put("account", account);
		return "account/index";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute(value = "account") Account account, ModelMap modelMap) {
		modelMap.put("account", account);
		return "account/success";
	}

}
