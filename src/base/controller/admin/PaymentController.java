package base.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import base.entities.*;
import base.service.*;

@Controller
@RequestMapping("admin/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("listPayment", paymentService.findAll());
		return "payment.index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.put("payment", new Payment());
		return "payment.create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("payment") Payment payment) {
		paymentService.create(payment);
		return "redirect:/admin/payment.html";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("payment", paymentService.find(id));
		return "payment.detail";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		paymentService.delete(paymentService.find(id));
		return "redirect:/admin/payment.html";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("payment", paymentService.find(id));
		return "payment.update";
	}


	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edit(
		@ModelAttribute("payment") Payment payment,
		ModelMap modelMap) {		
		paymentService.update(payment);
			return "redirect:/admin/payment.html";		
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(HttpServletRequest httpServletRequest, ModelMap modelMap) {
		String keyword = httpServletRequest.getParameter("keyword");
				modelMap.put("listPayment", paymentService.search(keyword));
		return "payment.index";
	}
	
}
