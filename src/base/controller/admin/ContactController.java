package base.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import base.entities.Contact;
import base.service.ContactService;

@Controller
@RequestMapping("admin/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder(contactService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "contact.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("contact") Contact contact) {
		contactService.create(contact);
		return "redirect:/admin/contact.html";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("contact", contactService.find(id));
		return "contact.detail";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		contactService.delete(contactService.find(id));
		return "redirect:/admin/contact.html";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("contact", contactService.find(id));
		return "contact.update";
	}


	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(
		@ModelAttribute("contact") Contact contact,
		ModelMap modelMap) {		
		contactService.update(contact);
			return "redirect:/admin/contact.html";	
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<Contact> contacts = contactService.search(keyword);
		PagedListHolder pagedListHolder = new PagedListHolder(contacts);
		PagedListHolder pagedListHolder2 = new PagedListHolder(contactService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("keyword", keyword);
		if(contacts.isEmpty()) {			
			modelMap.put("result", "Have no result For" +" "+ keyword+" "+"Keyword");
			modelMap.put("pagedListHolder", pagedListHolder2);		
		} else {
			modelMap.put("pagedListHolder", pagedListHolder);
		}		
		return "contact.index";
	}
	
}
