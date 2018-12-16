package kr.ac.hansung.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.InfoModel;
import kr.ac.hansung.service.InfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private InfoService infoService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootcont(Locale locale, Model model) {
		
		
		return "home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "home";
	}
	
	@RequestMapping(value = "/semesterGrade", method = RequestMethod.GET)
	public String semesterGrade(Locale locale, Model model) {
		
		List<InfoModel> infoModel = infoService.myGetSemesterGrade();
		model.addAttribute("infoModel", infoModel);
		
		
		return "semesterGrade";
	}
	
	@RequestMapping(value = "/completeGrade", method = RequestMethod.GET)
	public String completeGrade(Locale locale, Model model) {
		
		List<InfoModel> infoModel = infoService.myGetcompleteGrade();
		model.addAttribute("infoModel", infoModel);
		
		
		return "completeGrade";
	}
	
	@RequestMapping(value = "/showDetails", method = RequestMethod.GET)
	public String showDetails(Locale locale, Model model, String year, String semester) {
		
		List<InfoModel> infoModel = infoService.myGetshowDetails(Integer.parseInt(year), Integer.parseInt(semester));
		model.addAttribute("infoModel", infoModel);
		
		
		return "showDetails";
	}
	
	@RequestMapping(value = "/registerCourse", method = RequestMethod.GET)
	public String registerCourse(Locale locale, Model model) {
		model.addAttribute("infoModel", new InfoModel());
		
		return "registerCourse";
	}
	
	@RequestMapping(value = "/doRegister")
	public String doRegister(Locale locale, Model model, @Valid InfoModel infoModel, BindingResult result) {
		
		if(result.hasErrors()){
			System.out.println("No");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors)
				System.out.println(error.getDefaultMessage());
			//에러 있으면 다시 생성페이지 
			return "registerCourse";
		}
		infoService.insert(infoModel);
		
		return "registerOK";
	}
	
	@RequestMapping(value = "/registerCourseCheck")
	public String doRegister(Locale locale, Model model) {
		List<InfoModel> infoModel = infoService.myGet2018register();
		model.addAttribute("infoModel", infoModel);
		
		return "registerCourseCheck";
	}
}
