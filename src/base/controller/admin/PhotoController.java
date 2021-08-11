package base.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import base.entities.*;
import base.service.*;

@Controller
@RequestMapping("admin/photo")
public class PhotoController implements ServletContextAware {
	private ServletContext servletContext;

	@Autowired
	private PhotoService photoService;

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder(
				photoService.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "ph", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "photo.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("product", productService.findAll());
		return "photo.create";
	}

	@RequestMapping(value = "chooseProduct", method = RequestMethod.POST)
	public String choose(@RequestParam(value = "productId") Integer id, ModelMap modelMap) {
		modelMap.put("product", productService.findAll());
		Product p = productService.find(id);
		modelMap.put("p", p);
		return "photo.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam(value = "main", defaultValue = "false") Boolean main,
			@RequestParam(value = "productId") Integer id) {
		Photo photo = new Photo();
		Product product = productService.find(id);
		photo.setProduct(product);
		photo.setUrl(saveImage(image));
		photo.setMain(main);
		photoService.create(photo);
		return "redirect:/admin/photo.html";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("photo", photoService.find(id));
		return "photo.detail";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("photo", photoService.find(id));
		modelMap.put("product", productService.findAll());
		return "photo.update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(HttpServletRequest request,
			@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam(value = "main", defaultValue = "false") Boolean main,
			@RequestParam(value = "photoID", required = true) Integer id,
			@RequestParam(value = "productName", required = true) String products) {
		
		Photo photo = photoService.find(id);
		Product product = productService.findByName(products);
		photo.setProduct(product);
		if(image.isEmpty()) {
			photo.setUrl(photo.getUrl());
		}
		else {
			File file = new File(servletContext.getRealPath("/") + "/assets/user/images/products/" + photo.getUrl());
			file.delete();
			photo.setUrl(saveImage(image));
		}
		photo.setMain(main);
		photoService.update(photo);
		return "redirect:/admin/photo.html";
	}
	
	

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Photo photo = photoService.find(id);
		File file = new File(servletContext.getRealPath("/") + "/assets/user/images/products/" + photo.getUrl());
		file.delete();
		photoService.delete(photo);
		return "redirect:/admin/photo.html";
	}

	private String saveImage(MultipartFile image) {
		try {
			File file = new File(
					servletContext.getRealPath("/") + "/assets/user/images/products/" + image.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			return image.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		PagedListHolder pagedListHolder = new PagedListHolder(photoService.search(keyword));		
		modelMap.put("keyword", keyword);
		modelMap.put("pagedListHolder", photoService.search(keyword));
		modelMap.put("pagedListHolder", pagedListHolder);
		return "photo.index";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}