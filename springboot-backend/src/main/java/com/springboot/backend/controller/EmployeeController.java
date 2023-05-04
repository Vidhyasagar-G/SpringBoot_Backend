package com.springboot.backend.controller;



import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;
import com.springboot.backend.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeerepository;
	@Autowired
	private EmployeeService employeeService;


	
	 @RequestMapping("/emp")
		public String home(Model theModel){
		List<Employee> emp = employeeService.get();
					
			
			theModel.addAttribute("employee", emp);
			
			return "list-employee";
			
		}
	 @GetMapping("/search")
	    public String search(@RequestParam("q") String search, Model model) {
	        model.addAttribute("employee", employeerepository.findByzipcodeContainingIgnoreCase(search));
	        return "list-employee";
	    }
	
	 @RequestMapping("/showFormForAdd")
		public String addform(Model theModel){
			
					Employee emp = new Employee();
					
					theModel.addAttribute("employee", emp);
					
					return "employee-form";		
		}
	 
	 
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	
	@PostMapping("/saveemployee")
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/emp";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") long id,
									Model theModel) {
		
		
		Employee theemployee = employeeService.get(id);
		theModel.addAttribute("employee", theemployee);		
		return "employee-form";
	}
	

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") long id) {
		
		
		employeeService.deleteEmployee(id);
		return "redirect:/emp";
	}
	
	
	
}
