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
import tour.list.web.service.memberService;

@Controller
public class userRegController {

	@Autowired
	WebHelper webHelper;
	
	@Autowired
	memberService memberService;
	
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	@RequestMapping(value="/tour_list/userReg.do", method= RequestMethod.POST)
	public ModelAndView userReg(Model model) {
		String id = webHelper.getString("id");
		String password=webHelper.getString("password");
		String name=webHelper.getString("name");
		String gender=webHelper.getString("gender");
		String birth=webHelper.getString("birth");
		String mail=webHelper.getString("mail");
		String phone=webHelper.getString("phone");
		String address=webHelper.getString("address");
		String reg=webHelper.getString("reg");
		
		if(id==null) {
			return webHelper.redirect(null, "아이디를 입력하세요.");
		}
		
		member input = new member();
		input.setId(id);
		input.setPassword(password);
		input.setName(name);
		input.setGender(gender);
		input.setBirth(birth);
		input.setMail(mail);
		input.setPhone(phone);
		input.setAddress(address);
		input.setReg(reg);
	
		try {
			memberService.addMember(input);
		} catch(Exception e) {
	         return webHelper.redirect(null,e.getLocalizedMessage());
	    }
		
		return webHelper.redirect(contextPath + ???);
	}
}
