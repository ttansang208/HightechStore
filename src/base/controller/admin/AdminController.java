package base.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import base.service.*;

@Controller
@RequestMapping("admin/index")
public class AdminController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("account", orderService.findAll());
		modelMap.put("orders", orderService.findAll());
		modelMap.put("products", productService.findActive());
		modelMap.put("contacts", contactService.findAll());
		return "admin.index";
	}
}
