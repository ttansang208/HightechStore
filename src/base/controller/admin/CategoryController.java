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
@RequestMapping("admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder(categoryService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "category.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("pr", categoryService.getParent());
		return "category.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@RequestParam(value = "parent", required = false) Integer parent, HttpServletRequest request) {
		Category category = new Category();
		category.setCategory(categoryService.find(parent));
		category.setName(request.getParameter("Name"));
		categoryService.create(category);
		return "redirect:/admin/category.html";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("category", categoryService.find(id));
		return "category.detail";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		categoryService.delete(categoryService.find(id));
		return "redirect:/admin/category.html";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("parent", categoryService.getParent());
		modelMap.put("category", categoryService.find(id));
		return "category.update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(HttpServletRequest request ,@RequestParam(value = "parent", required = false) Integer parent, 
			@RequestParam(value = "id", required = false) Integer id) {	
		Category category = categoryService.find(id);
		category.setCategory(categoryService.find(parent));
		category.setName(request.getParameter("Name"));
		categoryService.update(category);
			return "redirect:/admin/category.html";		
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<Category> categories = categoryService.search(keyword);
		PagedListHolder pagedListHolder = new PagedListHolder(categories);
		PagedListHolder pagedListHolder2 = new PagedListHolder(categoryService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("keyword", keyword);
		if(categories.isEmpty()) {			
			modelMap.put("result", "Have no result For" +" "+ keyword+" "+"Keyword");
			modelMap.put("pagedListHolder", pagedListHolder2);		
		} else {
			modelMap.put("pagedListHolder", pagedListHolder);
		}		
		return "category.index";
	}
	
}
