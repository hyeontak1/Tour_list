package tour.list.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tour.list.web.helper.RegexHelper;
import tour.list.web.helper.WebHelper;
import tour.list.web.model.member;
import tour.list.web.service.memberService;

@Controller
public class MemberController {

	

	//webHelper객체 주입
	@Autowired
	WebHelper webHelper;
	//service 객체주입
	memberService memberService;
	
	
	@Autowired
	RegexHelper regexHelper;
	
	//"/프로젝트이름" 에 해당하는 ContextPath 변수주입
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	@RequestMapping(value="/member/add.do", method= RequestMethod.GET)
	public String add(Model model) {
		return "member/add";
		
	}
	
	
	@RequestMapping(value="/member/add_ok.do", method= RequestMethod.POST)
	public ModelAndView add_ok(Model model) {
		
		/**2)사용자가 입력한 파라미터 수신 및 유효성 검사**/
		String id = webHelper.getString("id");
		String password = webHelper.getString("password");
		String name = webHelper.getString("name");
		String gender = webHelper.getString("gender");
		String birth = webHelper.getString("birth");
		String mail = webHelper.getString("mail");
		String phone = webHelper.getString("phone");
		String address = webHelper.getString("address");
		String reg = webHelper.getString("reg");
		
		//필수항목 입력여부를 검사
		//위치는 미필수(null허용)이므로 입력 여부를 검사하지않는다.
		if(id == null) {
			return webHelper.redirect(null, "아이디를 입력하세요");
		}else if(password == null) {
			return webHelper.redirect(null, "패스워드를 입력하세요");
		}else if(name == null) {
			return webHelper.redirect(null, "이름을 입력하세요");
		}else if(gender == null) {
			return webHelper.redirect(null, "성별을 입력하세요");
		}else if(birth == null) {
			return webHelper.redirect(null, "생년월일을 입력하세요");
		}else if(mail == null) {
			return webHelper.redirect(null, "이메일을 입력하세요");
		}else if(phone == null) {
			return webHelper.redirect(null, "핸드폰번호를 입력하세요");
		}else if(address == null) {
			return webHelper.redirect(null, "주소를 입력하세요");
		}else if(reg == null) {
			return webHelper.redirect(null, "가입날짜를 입력하세요");
		}
		
		/**3) 데이터 저장하기*/
		//저장할 값들을 Beans에 담는다
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
			//데이터 저장
			//--> 데이터 저장에 성공하면 파라미터로 전달하는  input 객체에 pk값이 저장된다.
			memberService.addMember(input);
		}catch(Exception e) {
			/** 4) 결과를 확인하기 위한 페이지 이동 */
			// 저장 결과를 확인하기 위해서 데이터 저장시 생성된 PK값을 상세 페이지로 전달해야 한다.
			return webHelper.redirect(null,e.getLocalizedMessage());
		}
		
		return webHelper.redirect(contextPath +"/member/view.do?id=" + input.getId(),"회원가입이되엇습니다.");
		
	}
	
}

