package base.controller.superadmin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import base.conversion.DateEditor;
import base.entities.*;
import base.service.*;

@Controller
@RequestMapping("superadmin/account")
public class AccountController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new DateEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap,HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder(accountService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "account.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("account", new Account());
		modelMap.put("role", roleService.findAll());
		return "account.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("account") Account account,
			@RequestParam(value = "roleName", required = true) Integer role,
			@RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request) {

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setJoinTime(new Date());
		account.setPhoto(saveImage(image));
		accountService.create(account);

		UserRole userRole = new UserRole();
		userRole.setEnabled(true);
		userRole.setId(new UserRoleId(account.getUserName(), role));

		userRoleService.create(userRole);
		return "redirect:/superadmin/account.html";
	}

	@RequestMapping(value = "detail/{username}", method = RequestMethod.GET)
	public String detail(@PathVariable("username") String userName, ModelMap modelMap) {
		modelMap.put("account", accountService.find(userName));
		return "account.detail";
	}

	@RequestMapping(value = "delete/{userName}", method = RequestMethod.GET)
	public String delete(@PathVariable("userName") String userName) {
		accountService.delete(accountService.find(userName));
		return "redirect:/admin/account.html";
	}

	@RequestMapping(value = "update/{userName}", method = RequestMethod.GET)
	public String edit(@PathVariable("userName") String userName, ModelMap modelMap) {
		modelMap.put("account", accountService.find(userName));
		modelMap.put("roles", roleService.findAll());
		return "account.update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(@ModelAttribute("account") Account account, ModelMap modelMap,
			@RequestParam(value = "roleId", required = true) Integer role,
			@RequestParam(value = "image", required = false) MultipartFile image){
		modelMap.put("role", roleService.findAll());
		account = accountService.find(account.getUserName());
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		
		if (image.isEmpty()) {
			account.setPhoto(account.getPhoto());
		} else {
			File file = new File(servletContext.getRealPath("/") + "/assets/user/images/account/" + account.getPhoto());
			file.delete();
			account.setPhoto(saveImage(image));
		}

		accountService.update(account);

		UserRole userRole = userRoleService.find(account.getUserName());
		userRoleService.delete(userRole);
		userRole.setId(new UserRoleId(account.getUserName(), role));
		userRole.setEnabled(true);
		userRoleService.create(userRole);
		return "redirect:/superadmin/account.html";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");		
		List<Account> accounts = accountService.search(keyword);
		PagedListHolder pagedListHolder = new PagedListHolder(accounts);
		PagedListHolder pagedListHolder2 = new PagedListHolder(accountService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("keyword", keyword);
		if(accounts.isEmpty()) {			
			modelMap.put("result", "Have no result For" +" "+ keyword+" "+"Keyword");
			modelMap.put("pagedListHolder", pagedListHolder2);		
		} else {
			modelMap.put("pagedListHolder", pagedListHolder);
		}			
		return "account.index";
	}

	private String saveImage(MultipartFile image) {
		try {
			File file = new File(
					servletContext.getRealPath("/") + "/assets/user/images/account/" + image.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			return image.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
