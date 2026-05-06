package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IStudentCRUDService;

@Controller
@RequestMapping("/student/crud")
public class StudentCRUDController {

	@Autowired
	private IStudentCRUDService studCrudService;
	
	@GetMapping("/all")
	public String getAllStudnets(Model model) {
		
		try {
		model.addAttribute("package", studCrudService.retrieveAll());
		return "show-all-students-page" ;
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
}
