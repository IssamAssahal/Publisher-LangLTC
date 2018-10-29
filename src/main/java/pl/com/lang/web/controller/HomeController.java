package pl.com.lang.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <b>Home Page Entry</b><br>
 */
@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("index");
	}
}
