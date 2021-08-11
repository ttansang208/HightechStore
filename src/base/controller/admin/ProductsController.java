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
@RequestMapping("admin/product")
public class ProductsController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder(productService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "product.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("product", new Product());
		modelMap.put("producer", producerService.findAll());
		modelMap.put("category", categoryService.getChild());
		return "product.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "status", defaultValue = "false") boolean status) {
		Product product = new Product();
		product.setQuantity(0);
		product.setDescription(request.getParameter("description"));
		product.setShortDescription(request.getParameter("shortDescription"));
		product.setSpecification(request.getParameter("specification"));
		product.setCategory(categoryService.findByName(request.getParameter("categoryName")));
		product.setProducer(producerService.findByName(request.getParameter("producerName")));
		product.setName(request.getParameter("name"));
		product.setStatus(status);
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		productService.create(product);
		return "redirect:/admin/product.html";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("product", productService.find(id));
		return "products.detail";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		productService.delete(productService.find(id));
		return "redirect:/admin/product.html";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("product", productService.find(id));
		modelMap.put("producer", producerService.findAll());
		modelMap.put("category", categoryService.getChild());
		return "product.update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, ModelMap modelMap, @ModelAttribute("product") Product product,
			@RequestParam(value = "status", defaultValue = "false") boolean status) {
		product.setDescription(request.getParameter("description"));
		product.setShortDescription(request.getParameter("shortDescription"));
		product.setSpecification(request.getParameter("specification"));
		product.setCategory(categoryService.findByName(request.getParameter("categoryName")));
		product.setProducer(producerService.findByName(request.getParameter("producerName")));
		product.setName(request.getParameter("name"));
		product.setStatus(status);
		product.setPrice(Double.parseDouble(request.getParameter("price")));

		productService.update(product);
		return "redirect:/admin/product.html";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<Product> products = productService.search(keyword);
		PagedListHolder pagedListHolder = new PagedListHolder(products);
		PagedListHolder pagedListHolder2 = new PagedListHolder(productService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("keyword", keyword);
		if(products.isEmpty()) {			
			modelMap.put("result", "Have no result For" +" "+ keyword+" "+"Keyword");
			modelMap.put("pagedListHolder", pagedListHolder2);		
		} else {
			modelMap.put("pagedListHolder", pagedListHolder);
		}		
		return "product.index";
	}
}
