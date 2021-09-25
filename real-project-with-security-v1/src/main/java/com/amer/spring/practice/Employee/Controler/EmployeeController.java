package com.amer.spring.practice.Employee.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amer.spring.practice.Employee.entity.Employee;
import com.amer.spring.practice.Employee.service.EmoloyeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmoloyeeService emservice ;
	
	// finding all employees 
		@GetMapping("/list")
		public String findall(Model model)
		{
		
		   List<Employee> listofemployee = 	emservice.findall();
		   model.addAttribute("employee", listofemployee);
		   return "view/employee-list";
		}
		
		// redirect to employee form for saving
				@GetMapping("/showaddform")
				public String showaddform(Model model)
				{
				   Employee empl = new Employee();
				   model.addAttribute("employee", empl);
				   return "view/employee-form";
				}	
				
				
		// saving or updating employee method
				@PostMapping("/save")
				public String save(@ModelAttribute Employee emp)
				{
					emservice.save(emp);
					return "redirect:/employee/list" ;
				}
				

				
				@GetMapping("/showupdateform")
				public String showupdateform(@RequestParam("empid") int id ,Model model)
				{
				   Employee empl = emservice.findsingale(id);
				   model.addAttribute("employee", empl);
				   return "view/employee-form";
				}	


				// saving or updating employee method
				@GetMapping("/delete")
				public String delete(@RequestParam("empid") int id)
				{
					Employee empl = emservice.findsingale(id);
					emservice.delete(id);
					return "redirect:/employee/list" ;
				}











 


}













