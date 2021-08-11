package base.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;


import base.entities.*;
import base.service.*;

@Controller
@RequestMapping("admin/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder(supplierService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "supplier.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("supplier", new Supplier());
		return "supplier.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("supplier") Supplier supplier) {
		supplierService.create(supplier);
		return "redirect:/admin/supplier.html";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("supplier", supplierService.find(id));
		return "supplier.detail";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		supplierService.delete(supplierService.find(id));
		return "redirect:/admin/supplier.html";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(
		@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("supplier", supplierService.find(id));
		return "supplier.update";
	}


	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(
		@ModelAttribute("supplier") Supplier supplier) {		
		supplierService.update(supplier);
			return "redirect:/admin/supplier.html";		
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<Supplier> suppliers = supplierService.search(keyword);
		PagedListHolder pagedListHolder = new PagedListHolder(suppliers);
		PagedListHolder pagedListHolder2 = new PagedListHolder(supplierService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("keyword", keyword);
		if(suppliers.isEmpty()) {			
			modelMap.put("result", "Have no result For" +" "+ keyword+" "+"Keyword");
			modelMap.put("pagedListHolder", pagedListHolder2);		
		} else {
			modelMap.put("pagedListHolder", pagedListHolder);
		}			
		return "supplier.index";
	}
}
