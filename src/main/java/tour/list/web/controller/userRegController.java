package tour.list.web.controller;

import java.util.Calendar;

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
	
	@RequestMapping(value="/tour_list/userReg.do", method= RequestMethod.GET)
	public String userReg(Model model) {
		return "tour_list/userReg";
	}
	
	@RequestMapping(value="/tour_list/userReg_ok.do", method= RequestMethod.POST)
	public ModelAndView userReg_ok(Model model) {
		String id = webHelper.getString("id");
		String password=webHelper.getString("password");
		String name=webHelper.getString("name");
		String gender=webHelper.getString("gender");
		String birth=webHelper.getString("birth");
		String mail=webHelper.getString("mail");
		String phone=webHelper.getString("phone");
		String address=webHelper.getString("address");
		
		String date = null;
		Calendar c = Calendar.getInstance();
		date = String.format("%04d-%02d-%02d-%02d-%02d-%02d", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
					c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		String reg=date.replace("-", "");
		
		if(id==null) {
			return webHelper.redirect(null, "아이디를 입력하세요.");
		}
		if(password==null) {
			return webHelper.redirect(null, "비민번호를 입력하세요.");
		}
		if(name==null) {
			return webHelper.redirect(null, "이름을 입력하세요.");
		}
		if(gender==null) {
			return webHelper.redirect(null, "성별을 입력하세요.");
		}
		if(birth==null) {
			return webHelper.redirect(null, "생일을 입력하세요.");
		}
		if(mail==null) {
			return webHelper.redirect(null, "이메일을 입력하세요.");
		}
		if(phone==null) {
			return webHelper.redirect(null, "휴대전화번호를 입력하세요.");
		}
		if(address==null) {
			return webHelper.redirect(null, "주소를 입력하세요.");
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
