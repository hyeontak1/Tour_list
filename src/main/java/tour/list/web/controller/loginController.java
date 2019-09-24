package tour.list.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tour.list.web.helper.WebHelper;
import tour.list.web.model.member;
import tour.list.web.service.loginService;

@Controller
public class loginController {
	@Autowired
	WebHelper webHelper;
	
	@Autowired
	loginService loginService;
	
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	@RequestMapping(value="/login/check.do", method = RequestMethod.GET)
	public String check(Model model) {
		return "login/check";
	}
	
	@RequestMapping(value = "/login/check_ok.do", method = RequestMethod.GET)
	public ModelAndView check_ok(Model model) {
	String id = webHelper.getString("id");
	String password = webHelper.getString("password");
	
	if(id == null) {
		return webHelper.redirect(null, "아이디를 입력하세요.");
	}
	if(password == null) {
		return webHelper.redirect(null, "비밀번호를 입력하세요.");
	}
	
	member input = new member();
	input.setId(id);
	input.setPassword(password);
	
	member output = null;
	
	try {
		output = loginService.login(input);
	} catch (Exception e) {
		return webHelper.redirect(null, e.getLocalizedMessage());
	}
	model.addAttribute("output", output);
	
	return new ModelAndView("login/check");
	}
	
}
