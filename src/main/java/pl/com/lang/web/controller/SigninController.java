package pl.com.lang.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <b>Signin Page Entry</b><br>
 * 
 * @author Issam As-sahal ISA
 */
@RestController
@RequestMapping("/signin")
public class SigninController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signin() {
		return new ModelAndView("signin");
	}
}
