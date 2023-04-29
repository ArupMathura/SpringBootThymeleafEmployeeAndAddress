package in.bushansirgur.springbootthymeleaf.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.bushansirgur.springbootthymeleaf.dao.AddressRepository;
import in.bushansirgur.springbootthymeleaf.dao.EmployeeRepository;
import in.bushansirgur.springbootthymeleaf.entity.Address;
//import in.bushansirgur.springbootthymeleaf.entity.Employee;
//import lombok.AllArgsConstructor;
import in.bushansirgur.springbootthymeleaf.entity.Employee;
import in.bushansirgur.springbootthymeleaf.service.EmployeeService;

@Controller
// @RequestMapping("/employee/{employeeId}/addresses")
public class AddressController {
/*	
	private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;

    public AddressController(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/employee/{id}/addresses/new")
    public String showAddAddressForm(@PathVariable("id") Long employeeId, Model model) {
        model.addAttribute("employee", employeeRepository.findById(employeeId).orElse(null));
        model.addAttribute("address", new Address());
        model.addAttribute("employeeId", employeeId);
        return "add-address-form";
    }

    @PostMapping("/employee/{id}/addresses/new")
    public String addAddress(@PathVariable("id") Long employeeId, @ModelAttribute("address") Address address) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            address.setEmployee(employee);
            addressRepository.save(address);
        }
        return "redirect:/employee/{id}/addresses";
    }

    @GetMapping("/employee/{employeeId}/addresses")
    public ModelAndView showAddressList(@PathVariable("employeeId") Long employeeId) {
        ModelAndView mav = new ModelAndView("list-addresses");
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            List<Address> addresses = addressRepository.findByEmployee(employee);
            mav.addObject("employee", employee);
            mav.addObject("addresses", addresses);
        }
        return mav;
    }
*/	

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressRepository addressRepository;
	 

	@GetMapping("/employee/{employeeId}/addresses")
	public String getAddressPage(@PathVariable Long employeeId, Model model) {
		Employee employee = employeeRepository.findById(employeeId).get();
		// .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		model.addAttribute("employee", employee);
		return "add-address-form";
	}

	@PostMapping("/employee/{employeeId}/addresses")
	public String addAddress(@PathVariable Long employeeId, @ModelAttribute Address address) {
		Employee employee = employeeRepository.findById(employeeId).get();
		// .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		address.setEmployee(employee);
		addressRepository.save(address);
//		return "redirect:/employee/" + employeeId + "/addresses";
		// return "list-addresses";
		return "redirect:/employee/{employeeId}/addresses";
	}
	
	@GetMapping("/employee/{employeeId}/addresslist")
    public ModelAndView showAddressList(@PathVariable("employeeId") Long employeeId) {
        ModelAndView mav = new ModelAndView("list-addresses");
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            List<Address> addresses = addressRepository.findByEmployee(employee);
            mav.addObject("employee", employee);
            mav.addObject("addresses", addresses);
        }
        return mav;
    }
	
	
}
