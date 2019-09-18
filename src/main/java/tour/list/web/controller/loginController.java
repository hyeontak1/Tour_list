package tour.list.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import tour.list.web.helper.WebHelper;
import tour.list.web.model.member;
import tour.list.web.service.loginService;

@Slf4j
@Controller
@RequestMapping("/memberMapper/*")
public class loginController {
	
	//webHelper 객체주입
	   @Autowired
	   WebHelper webHelper;
	   
	   @Autowired
	   loginService loginService;
	   
	   // 로그인 화면
	   @RequestMapping(value = "/tour_list/login.do", method = RequestMethod.GET)
	   public String login() {
		   return "tour_list/login";
	   }
	
	   // 로그인 처리
	   @RequestMapping(value = "/tour_list/loginCheck.do", method = RequestMethod.POST)
	   public ModelAndView loginCheck(@ModelAttribute member vo, HttpSession session) {
		   boolean result = loginService.loginCheck(vo, session);
		   ModelAndView mav = new ModelAndView();
		   if(result == true) { // 로그인 성공
			   // 메인페이지로 이동
			   mav.setViewName("/tour_list/home"); // "메인페이지 이름" 입력하기
			   mav.addObject("msg", "success");
		   } else { // 로그인 실패
			   // 로그인 페이지로 이동
			   mav.setViewName("tour_list/login");
			   mav.addObject("msg", "failure");
		   }
		   return mav;
	   }
	   
	   // 로그아웃
	   @RequestMapping(value = "/tour_list/logout.do", method = RequestMethod.GET)
	   public ModelAndView logout(HttpSession session) {
		   loginService.logout(session);
		   ModelAndView mav = new ModelAndView();
		   mav.setViewName("tour_list/home");
		   mav.addObject("msg", "logout");
		   return mav;
	   }
}
