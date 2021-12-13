package edu.cs.uga.project.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Promotion;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.PromotionService;
//import edu.cs.uga.project.service.UserService;
//import edu.cs.uga.project.util.UserState;
//import edu.cs.uga.project.web.dto.UserDto;
import edu.cs.uga.project.web.dto.PromotionDto;

	
@ComponentScan
@Controller
@RequestMapping("admin/addPromo")
public class AddPromoController {
	
	private CustomerServiceImpl customerService;
	private PromotionService promoService; 
	
	/**
	 * @param customerService
	 */
	public AddPromoController(CustomerServiceImpl customerService, PromotionService promoService) {
		super();
		this.customerService = customerService;
		this.promoService = promoService;

	}

	@ModelAttribute("promo")
    public PromotionDto promotionDto() {
        return new PromotionDto();
    }
	
	@GetMapping
	public String showPage() {
		return "admin/addPromo";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("promo") PromotionDto promoDto) {
		//Make Promo
		Promotion promo = new Promotion(promoDto);
		promoService.save(promo);
		customerService.sendPromoEmail(""+ promoDto.getPercentage(), promoDto.getStartTime(), promoDto.getEndTime(), promo.getPromotionCode());
		return "redirect:/admin/addPromo?success";
	}
}