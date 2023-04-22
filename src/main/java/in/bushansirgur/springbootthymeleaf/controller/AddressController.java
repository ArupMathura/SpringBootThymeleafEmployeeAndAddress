package in.bushansirgur.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.bushansirgur.springbootthymeleaf.dao.AddressRepository;
import in.bushansirgur.springbootthymeleaf.entity.Address;
//import in.bushansirgur.springbootthymeleaf.entity.Employee;
//import lombok.AllArgsConstructor;

@Controller
//@AllArgsConstructor
//@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressRepository aRepo;
	
	@GetMapping({"/address/list", "/address/"})
	public ModelAndView getAllAddresses() {
		ModelAndView mav = new ModelAndView("list-addresses");
		mav.addObject("addresses", aRepo.findAll());
		return mav;
	}
	
	@GetMapping("/address/addAddressForm")
	public ModelAndView addAddressForm() {
		ModelAndView mav = new ModelAndView("add-address-form");
		Address newAddress = new Address();
		mav.addObject("address", newAddress);
		return mav;
	}
	
	@PostMapping("/address/saveAddress")
	public String saveAddress(@ModelAttribute Address address) {
		aRepo.save(address);
		return "redirect:/address/list";
	}
	
	@GetMapping("/address/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long addressId) {
		ModelAndView mav = new ModelAndView("add-address-form");
		Address address = aRepo.findById(addressId).get();
		mav.addObject("address", address);
		return mav;
	}
	
	@GetMapping("/address/deleteAddress")
	public String deleteAddress(@RequestParam Long addressId) {
		aRepo.deleteById(addressId);
		return "redirect:/address/list";
	}
	
}
